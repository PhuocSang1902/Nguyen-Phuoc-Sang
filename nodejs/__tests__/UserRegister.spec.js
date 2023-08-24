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
  password: 'password',
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
      password: 'password',
    });
    const body = response.body;
    expect(Object.keys(body.validationErrors)).toEqual(['username', 'email']);
  });

  it.each`
    field         | value              | expectedMessage
    ${'username'} | ${null}            | ${'Username cannot be null'}
    ${'username'} | ${'usr'}           | ${'Must have min 4 and max 32 characters'}
    ${'username'} | ${'a'.repeat(33)}  | ${'Must have min 4 and max 32 characters'}
    ${'email'}    | ${null}            | ${'E-mail cannot be null'}
    ${'email'}    | ${'mail.com'}      | ${'E-mail is not valid'}
    ${'email'}    | ${'user.mail.com'} | ${'E-mail is not valid'}
    ${'email'}    | ${'user@mail'}     | ${'E-mail is not valid'}
    ${'password'} | ${null}            | ${'Password cannot be null'}
    ${'password'} | ${'Pass'}          | ${'Password must be at least 6 characters'}
    ${'password'} | ${'allowercase'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
    ${'password'} | ${'ADADAFDASFA'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
    ${'password'} | ${'12345657633'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
    ${'password'} | ${'lowerJDAKFD'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
    ${'password'} | ${'DFASDF12344'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
    ${'password'} | ${'afdsf111111'}   | ${'Password must have at least 1 uppercase, 1 lowercase letter and 1 number characters'}
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
});
