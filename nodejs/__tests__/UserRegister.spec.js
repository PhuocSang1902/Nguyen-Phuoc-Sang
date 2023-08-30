const request = require('supertest');
const app = require('../src/app');
const User = require('../src/user/User');
const sequelize = require('../src/config/database');

beforeAll(() => {
  return sequelize.sync();
});

beforeEach(() => {
  return User.destroy({ truncate: true });
});

const validUser = {
  username: 'user1',
  email: 'user1@gmail.com',
  password: 'Password1',
};
function postUser(user = validUser) {
  return request(app).post('/api/1.0/users').send(user);
}

describe('User Registration', () => {
  it('returns 200 ok when signup request is valid', async () => {
    const response = await postUser();
    expect(response.status).toBe(200);
  });

  it('returns success message when signup request is valid', async () => {
    const response = await postUser();
    expect(response.body.message).toBe('User created');
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

  const username_null = 'Username cannot be null';
  const username_size = 'Must have min 4 and max 32 characters';
  const email_null = 'E-mail cannot be null';
  const email_invalid = 'E-mail is not valid';
  const password_null = 'Password cannot be null';
  const password_size = 'Password must be at least 6 characters';
  const password_invalid = 'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters';
  const email_inuse = 'E-mail in use';

  it.each`
    field         | value              | expectedMessage
    ${'username'} | ${null}            | ${username_null}
    ${'username'} | ${'usr'}           | ${username_size}
    ${'username'} | ${'a'.repeat(33)}  | ${username_size}
    ${'email'}    | ${null}            | ${email_null}
    ${'email'}    | ${'mail.com'}      | ${email_invalid}
    ${'email'}    | ${'user.mail.com'} | ${email_invalid}
    ${'email'}    | ${'user@mail'}     | ${email_invalid}
    ${'password'} | ${null}            | ${password_null}
    ${'password'} | ${'Pass'}          | ${password_size}
    ${'password'} | ${'allowercase'}   | ${password_invalid}
    ${'password'} | ${'ADADAFDASFA'}   | ${password_invalid}
    ${'password'} | ${'12345657633'}   | ${password_invalid}
    ${'password'} | ${'lowerJDAKFD'}   | ${password_invalid}
    ${'password'} | ${'DFASDF12344'}   | ${password_invalid}
    ${'password'} | ${'afdsf111111'}   | ${password_invalid}
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

  it(`return ${email_inuse} when same email is already in use`, async () => {
    await User.create({ ...validUser });
    const response = await postUser();
    expect(response.body.validationErrors.email).toBe(email_inuse);
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
});
describe('Internationalization', () => {
  function postUser(user = validUser) {
    return request(app).post('/api/1.0/users').set('Accept-Language', 'vn').send(user);
  }

  const username_null = 'Ten nguoi dung khong duoc null';
  const username_size = 'Phai co it nhat 4 va nhieu nhat 32 ky tu';
  const email_null = 'E-mail khong duoc null';
  const email_invalid = 'E-mail khong dung dinh dang';
  const password_null = 'Password khong duoc null';
  const password_size = 'Password phai co it nhat 6 ky tu';
  const password_invalid = 'Password phai co it nhat mot tu viet hoa, 1 tu viet thuong, 1 so';
  const email_inuse = 'E-mail da duoc su dung';

  it.each`
    field         | value              | expectedMessage
    ${'username'} | ${null}            | ${username_null}
    ${'username'} | ${'usr'}           | ${username_size}
    ${'username'} | ${'a'.repeat(33)}  | ${username_size}
    ${'email'}    | ${null}            | ${email_null}
    ${'email'}    | ${'mail.com'}      | ${email_invalid}
    ${'email'}    | ${'user.mail.com'} | ${email_invalid}
    ${'email'}    | ${'user@mail'}     | ${email_invalid}
    ${'password'} | ${null}            | ${password_null}
    ${'password'} | ${'Pass'}          | ${password_size}
    ${'password'} | ${'allowercase'}   | ${password_invalid}
    ${'password'} | ${'ADADAFDASFA'}   | ${password_invalid}
    ${'password'} | ${'12345657633'}   | ${password_invalid}
    ${'password'} | ${'lowerJDAKFD'}   | ${password_invalid}
    ${'password'} | ${'DFASDF12344'}   | ${password_invalid}
    ${'password'} | ${'afdsf111111'}   | ${password_invalid}
  `(
    'return $expectedMessage when $field is $value when language duoc set viet nam',
    async ({ field, value, expectedMessage }) => {
      const user = {
        username: 'user1',
        email: 'user1@gmail.com',
        password: 'password',
      };
      user[field] = value;
      const response = await postUser(user);
      const body = response.body;
      expect(body.validationErrors[field]).toBe(expectedMessage);
    },
  );

  it(`return ${email_inuse} when same email is already in use`, async () => {
    await User.create({ ...validUser });
    const response = await postUser();
    expect(response.body.validationErrors.email).toBe(email_inuse);
  });
});
