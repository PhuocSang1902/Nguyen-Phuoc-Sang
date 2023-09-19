const request = require('supertest');
const app = require('../src/app');
const User = require('../src/user/User');
const sequelize = require('../src/config/database');
const SMTPServer = require('smtp-server').SMTPServer;
const en = require('../locales/en/translation.json');
const vn = require('../locales/vn/translation.json');

let lastMail, server;
let simulateSmtpFailure = false;

beforeAll(async () => {
  server = new SMTPServer({
    authOptional: true,
    onData(stream, session, callback) {
      let mailBody;
      stream.on('data', (data) => {
        mailBody += data.toString();
      });
      stream.on('end', () => {
        if (simulateSmtpFailure) {
          const error = new Error('Invalid mailbox');
          error.responseCode = 553;
          return callback(error);
        }
        lastMail = mailBody;
        callback();
      });
    },
  });

  await server.listen(8587, 'localhost');

  await sequelize.sync();
  jest.setTimeout(20000);
});

beforeEach(async () => {
  simulateSmtpFailure = false;
  await User.destroy({ truncate: true });
});

afterAll(async () => {
  await server.close();
  jest.setTimeout(5000);
});

const validUser = {
  username: 'user1',
  email: 'user1@gmail.com',
  password: 'Password1',
};
function postUser(user = validUser, option = {}) {
  const agent = request(app).post('/api/1.0/users');
  if (option.language) {
    agent.set('Accept-Language', option.language);
  }
  return agent.send(user);
}

describe('User Registration', () => {
  it('returns 200 ok when signup request is valid', async () => {
    const response = await postUser();
    expect(response.status).toBe(200);
  });

  it('returns success message when signup request is valid', async () => {
    const response = await postUser();
    expect(response.body.message).toBe(en.user_created_success);
  });

  it('saves the user to database', async () => {
    await postUser();
    const userList = await User.findAll();
    expect(userList.length).toBe(1);
  });

  it('saves the username and email to database', async () => {
    await postUser();
    const userList = await User.findAll();
    const savedUser = userList[0];
    expect(savedUser.username).toBe('user1');
    expect(savedUser.email).toBe('user1@gmail.com');
  });

  it('hashes the password in database', async () => {
    await postUser();
    const userList = await User.findAll();
    const savedUser = userList[0];
    expect(savedUser.password).not.toBe('password');
  });

  it('return 400 when username is null', async () => {
    const response = await postUser({
      username: null,
      email: 'user1@gmail.com',
      password: 'password',
    });
    expect(response.status).toBe(400);
  });

  it('return validationErrors field in response when validation error occurs', async () => {
    const response = await request(app).post('/api/1.0/users').send({
      username: null,
      email: 'user1@gmail.com',
      password: 'password',
    });
    const body = response.body;
    expect(body.validationErrors).not.toBeUndefined();
  });

  it('return errors for both when username and email is null', async () => {
    const response = await postUser({
      username: null,
      email: null,
      password: 'Password1',
    });
    const body = response.body;
    expect(Object.keys(body.validationErrors)).toEqual(['username', 'email']);
  });

  it.each`
    field         | value              | expectedMessage
    ${'username'} | ${null}            | ${en.username_null}
    ${'username'} | ${'usr'}           | ${en.username_size}
    ${'username'} | ${'a'.repeat(33)}  | ${en.username_size}
    ${'email'}    | ${null}            | ${en.email_null}
    ${'email'}    | ${'mail.com'}      | ${en.email_invalid}
    ${'email'}    | ${'user.mail.com'} | ${en.email_invalid}
    ${'email'}    | ${'user@mail'}     | ${en.email_invalid}
    ${'password'} | ${null}            | ${en.password_null}
    ${'password'} | ${'Pass'}          | ${en.password_size}
    ${'password'} | ${'allowercase'}   | ${en.password_invalid}
    ${'password'} | ${'ADADAFDASFA'}   | ${en.password_invalid}
    ${'password'} | ${'12345657633'}   | ${en.password_invalid}
    ${'password'} | ${'lowerJDAKFD'}   | ${en.password_invalid}
    ${'password'} | ${'DFASDF12344'}   | ${en.password_invalid}
    ${'password'} | ${'afdsf111111'}   | ${en.password_invalid}
  `('return $expectedMessage when $field is $value', async ({ field, value, expectedMessage }) => {
    const user = {
      username: 'user1',
      email: 'user1@gmail.com',
      password: 'password',
    };
    user[field] = value;
    const response = await postUser(user);
    const body = response.body;
    expect(body.validationErrors[field]).toBe(expectedMessage);
  });

  it(`return ${en.email_inuse} when same email is already in use`, async () => {
    await User.create({ ...validUser });
    const response = await postUser();
    expect(response.body.validationErrors.email).toBe(en.email_inuse);
  });

  it('Returns errors for both username is null and email is in use', async () => {
    await User.create({ ...validUser });
    const response = await postUser({
      username: null,
      email: validUser.email,
      password: 'Password1',
    });

    const body = response.body;
    expect(Object.keys(body.validationErrors)).toEqual(['username', 'email']);
  });

  it('creates user in inactive mode', async () => {
    await postUser();
    const users = await User.findAll();
    const savedUser = users[0];
    expect(savedUser.inactive).toBe(true);
  });

  it('creates user in inactive mode even the request body contains inactive if false', async () => {
    const newUser = { ...validUser, inactive: false };
    await postUser(newUser);
    const users = await User.findAll();
    const savedUser = users[0];
    expect(savedUser.inactive).toBe(true);
  });

  it('creates an activationToken for user', async () => {
    await postUser();
    const users = await User.findAll();
    const savedUser = users[0];
    expect(savedUser.activationToken).toBeTruthy();
  });

  it('sends an Account activation email with activationToken', async () => {
    await postUser();
    const users = await User.findAll();
    const savedUser = users[0];
    expect(lastMail).toContain('user1@gmail.com');
    expect(lastMail).toContain(savedUser.activationToken);
  });

  it('returns 502 Bad Gateway when sending email fails', async () => {
    simulateSmtpFailure = true;
    const response = await postUser();
    expect(response.status).toBe(502);
  });

  it('returns Email failure message when sending email fails', async () => {
    simulateSmtpFailure = true;
    const response = await postUser();
    expect(response.body.message).toBe(en.email_failure);
  });

  it('does not save user to database if activation email fails', async () => {
    simulateSmtpFailure = true;
    await postUser();
    const users = await User.findAll();
    expect(users.length).toBe(0);
  });

  it('return Validation Failure message in error response body when validation fails', async () => {
    const response = await postUser({
      username: null,
      email: validUser.email,
      password: 'Password1',
    });
    expect(response.body.message).toBe(en.validation_failure);
  });
});

describe('Internationalization', () => {
  it.each`
    field         | value              | expectedMessage
    ${'username'} | ${null}            | ${vn.username_null}
    ${'username'} | ${'usr'}           | ${vn.username_size}
    ${'username'} | ${'a'.repeat(33)}  | ${vn.username_size}
    ${'email'}    | ${null}            | ${vn.email_null}
    ${'email'}    | ${'mail.com'}      | ${vn.email_invalid}
    ${'email'}    | ${'user.mail.com'} | ${vn.email_invalid}
    ${'email'}    | ${'user@mail'}     | ${vn.email_invalid}
    ${'password'} | ${null}            | ${vn.password_null}
    ${'password'} | ${'Pass'}          | ${vn.password_size}
    ${'password'} | ${'allowercase'}   | ${vn.password_invalid}
    ${'password'} | ${'ADADAFDASFA'}   | ${vn.password_invalid}
    ${'password'} | ${'12345657633'}   | ${vn.password_invalid}
    ${'password'} | ${'lowerJDAKFD'}   | ${vn.password_invalid}
    ${'password'} | ${'DFASDF12344'}   | ${vn.password_invalid}
    ${'password'} | ${'afdsf111111'}   | ${vn.password_invalid}
  `(
    'return $expectedMessage when $field is $value when language duoc set viet nam',
    async ({ field, value, expectedMessage }) => {
      const user = {
        username: 'user1',
        email: 'user1@gmail.com',
        password: 'password',
      };
      user[field] = value;
      const response = await postUser(user, { language: 'vn' });
      const body = response.body;
      expect(body.validationErrors[field]).toBe(expectedMessage);
    },
  );

  it(`return ${vn.email_inuse} when same email is already in use`, async () => {
    await User.create({ ...validUser });
    const response = await postUser({ ...validUser }, { language: 'vn' });
    expect(response.body.validationErrors.email).toBe(vn.email_inuse);
  });

  it(`returns success message ${vn.user_created_success} when signup request is valid and language set vietnam`, async () => {
    const response = await postUser({ ...validUser }, { language: 'vn' });
    expect(response.body.message).toBe(vn.user_created_success);
  });

  it(`returns ${vn.email_failure} message when sending email fails a language is set as vietnam`, async () => {
    simulateSmtpFailure = true;
    const response = await postUser({ ...validUser }, { language: 'vn' });
    expect(response.body.message).toBe(vn.email_failure);
  });

  it(`return ${vn.validation_failure} message in error response body when validation fails`, async () => {
    const response = await postUser(
      {
        username: null,
        email: validUser.email,
        password: 'Password1',
      },
      { language: 'vn' },
    );
    expect(response.body.message).toBe(vn.validation_failure);
  });
});

describe('Account activation', () => {
  it('actives the account when correct token is sent', async () => {
    await postUser();
    let users = await User.findAll();
    const token = users[0].activationToken;

    await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    users = await User.findAll();
    expect(users[0].inactive).toBe(false);
  });
  it('removes the token from the user table after successful activation', async () => {
    await postUser();
    let users = await User.findAll();
    const token = users[0].activationToken;

    await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    users = await User.findAll();
    expect(users[0].activationToken).toBeFalsy();
  });
  it('does not activate the account when token is wrong', async () => {
    await postUser();
    const token = 'This-token-does-not-exist';
    await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    const users = await User.findAll();
    expect(users[0].inactive).toBe(true);
  });
  it('returns bad request when token is wrong', async () => {
    await postUser();
    const token = 'This-token-does-not-exist';
    const response = await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    expect(response.status).toBe(400);
  });
  it.each`
    language | tokenStratus | message
    ${'vn'}  | ${'wrong'}   | ${vn.account_activation_failure}
    ${'en'}  | ${'wrong'}   | ${en.account_activation_failure}
    ${'vn'}  | ${'correct'} | ${vn.account_activation_success}
    ${'en'}  | ${'correct'} | ${en.account_activation_success}
  `(
    'returns $message when token is $tokenStratus token is sent and language is $language',
    async ({ language, message, tokenStratus }) => {
      await postUser();
      let token = 'This-token-does-not-exist';
      if (tokenStratus === 'correct') {
        let users = await User.findAll();
        token = users[0].activationToken;
      }
      const response = await request(app)
        .post('/api/1.0/users/token/' + token)
        .set('Accept-Language', language)
        .send();
      expect(response.body.message).toBe(message);
    },
  );
});

describe('Error Model', () => {
  it('returns path, timestamp, message and validationErrors in response when validation failure', async () => {
    const response = await postUser({ ...validUser, username: null });
    const body = response.body;
    expect(Object.keys(body)).toEqual(['path', 'timestamp', 'message', 'validationErrors']);
  });

  it('returns path, timestamp and message in response when request fails other than validation error', async () => {
    const token = 'This-token-does-not-exist';
    const response = await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    const body = response.body;
    expect(Object.keys(body)).toEqual(['path', 'timestamp', 'message']);
  });

  it('returns path in error body', async () => {
    const token = 'This-token-does-not-exist';
    const response = await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    const body = response.body;
    expect(body.path).toEqual('/api/1.0/users/token/' + token);
  });

  it('returns timestamp in milliseconds within 5 seconds value in error body', async () => {
    const nowInMillis = new Date().getTime();
    const fiveSecondsLater = nowInMillis + 5 * 1000;
    const token = 'This-token-does-not-exist';
    const response = await request(app)
      .post('/api/1.0/users/token/' + token)
      .send();
    const body = response.body;
    expect(body.timestamp).toBeGreaterThan(nowInMillis);
    expect(body.timestamp).toBeLessThan(fiveSecondsLater);
  });
});
