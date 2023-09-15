const request = require('supertest');
const app = require('../src/app');
const User = require('../src/user/User');
const sequelize = require('../src/config/database');
const bcrypt = require('bcrypt');
const en = require('../locales/en/translation.json');
const vn = require('../locales/vn/translation.json');

beforeAll(async () => {
  await sequelize.sync();
});

beforeEach(async () => {
  return User.destroy({ truncate: true });
});

const activeUser = {
  username: 'user1',
  email: 'user1@gmail.com',
  password: 'Password1',
  inactive: false,
};

const addUser = async (user = { ...activeUser }) => {
  const hash = await bcrypt.hash(user.password, 10);
  user.password = hash;
  return await User.create(user);
};

const putUser = (id = 5, body = null, option = {}) => {
  const agent = request(app).put('/api/1.0/users/' + id);
  if (option.language) {
    agent.set('Accept-Language', option.language);
  }
  if (option.auth) {
    const { email, password } = option.auth;
    agent.auth(email, password);
  }
  return agent.send(body);
};

describe('User update', () => {
  it('returns forbidden when request sent without basic authorization', async () => {
    const response = await putUser();
    expect(response.status).toBe(403);
  });
  it.each`
    language | message
    ${'vn'}  | ${vn.unauthorized_user_update}
    ${'en'}  | ${en.unauthorized_user_update}
  `(
    'return error body with $message for unauthorized request when language is set to $language',
    async ({ language, message }) => {
      const nowInMillis = new Date().getTime();
      const response = await putUser(5, null, { language });
      expect(response.body.path).toEqual('/api/1.0/users/5');
      expect(response.body.timestamp).toBeGreaterThan(nowInMillis);
      expect(response.body.message).toBe(message);
    },
  );
  it('returns forbidden when request sent with incorrect email in basic authorization', async () => {
    await addUser();
    const response = await putUser(5, null, { auth: { email: 'user1000@gmail.com', password: 'Password1' } });
    expect(response.status).toBe(403);
  });
  it('returns forbidden when request sent with incorrect password in basic authorization', async () => {
    await addUser();
    const response = await putUser(5, null, { auth: { email: 'user1@gmail.com', password: 'password' } });
    expect(response.status).toBe(403);
  });
  it('returns forbidden when request is sent with correct credentials but for different user', async () => {
    await addUser();
    const userToBeUpdated = await addUser({ ...activeUser, username: 'user2', email: 'user2@gmail.com' });
    const response = await putUser(userToBeUpdated.id, null, {
      auth: { email: 'user1@gmail.com', password: 'Password1' },
    });
    expect(response.status).toBe(403);
  });
  it('returns forbidden when request is sent by inactive user with correct credentials for its own user', async () => {
    const inactiveUser = await addUser({ ...activeUser, inactive: true });
    const response = await putUser(inactiveUser.id, null, {
      auth: { email: 'user1@gmail.com', password: 'Password1' },
    });
    expect(response.status).toBe(403);
  });
  it('returns 200 ok when valid update request sent from authorized user', async () => {
    const savedUser = await addUser();
    const validUpdate = { username: 'user1-update' };
    const response = await putUser(savedUser.id, validUpdate, {
      auth: { email: savedUser.email, password: 'Password1' },
    });
    expect(response.status).toBe(200);
  });
  it('update user in database  when valid update request is sent from authorized user', async () => {
    const savedUser = await addUser();
    const validUpdate = { username: 'user1-update' };
    const response = await putUser(savedUser.id, validUpdate, {
      auth: { email: savedUser.email, password: 'Password1' },
    });
    const inDBUser = await User.findOne({ where: { id: savedUser.id } });
    expect(inDBUser.username).toBe(validUpdate.username);
  });
});
