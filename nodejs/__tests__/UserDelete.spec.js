const request = require('supertest');
const app = require('../src/app');
const User = require('../src/user/User');
const Token = require('../src/auth/Token');
const sequelize = require('../src/config/database');
const bcrypt = require('bcrypt');
const en = require('../locales/en/translation.json');
const vn = require('../locales/vn/translation.json');

beforeAll(async () => {
  await sequelize.sync();
});

beforeEach(async () => {
  await User.destroy({ truncate: { cascade: true } });
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

const auth = async (options = {}) => {
  let token;
  if (options.auth) {
    const response = await request(app).post('/api/1.0/auth').send(options.auth);
    token = response.body.token;
  }
  return token;
};

const deleteUser = async (id = 5, options = {}) => {
  const agent = request(app).delete('/api/1.0/users/' + id);
  if (options.language) {
    agent.set('Accept-Language', options.language);
  }
  if (options.token) {
    agent.set('Authorization', `Bearer ${options.token}`);
  }
  return agent.send();
};

describe('User delete', () => {
  it('returns forbidden when request sent authorization', async () => {
    const response = await deleteUser();
    expect(response.status).toBe(403);
  });
  it.each`
    language | message
    ${'vn'}  | ${vn.unauthorized_user_delete}
    ${'en'}  | ${en.unauthorized_user_delete}
  `(
    'return error body with $message for unauthorized request when language is set to $language',
    async ({ language, message }) => {
      const nowInMillis = new Date().getTime();
      const response = await deleteUser(5, { language });
      expect(response.body.path).toEqual('/api/1.0/users/5');
      expect(response.body.timestamp).toBeGreaterThan(nowInMillis);
      expect(response.body.message).toBe(message);
    },
  );
  it('returns forbidden when request is sent with correct credentials but for different user', async () => {
    await addUser();
    const userToBeDeleted = await addUser({ ...activeUser, username: 'user2', email: 'user2@gmail.com' });
    const token = await auth({ auth: { email: 'user1@gmail.com', password: 'Password1' } });
    const response = await deleteUser(userToBeDeleted.id, { token: token });
    expect(response.status).toBe(403);
  });
  it('returns forbidden when request is sent by inactive user with correct credentials for its own user', async () => {
    const inactiveUser = await addUser({ ...activeUser, inactive: true });
    const response = await deleteUser(inactiveUser.id, {
      auth: { email: 'user1@gmail.com', password: 'Password1' },
    });
    expect(response.status).toBe(403);
  });
  it('returns 200 ok when valid update request sent from authorized user', async () => {
    const savedUser = await addUser();
    const token = await auth({ auth: { email: 'user1@gmail.com', password: 'Password1' } });
    const response = await deleteUser(savedUser.id, { token: token });
    expect(response.status).toBe(200);
  });
  it('deletes user in database  when request is sent from authorized user', async () => {
    const savedUser = await addUser();
    const token = await auth({ auth: { email: 'user1@gmail.com', password: 'Password1' } });
    await deleteUser(savedUser.id, { token: token });
    const inDBUser = await User.findOne({ where: { id: savedUser.id } });
    expect(inDBUser).toBeNull();
  });
  it('deletes token from database when request is sent from authorized user', async () => {
    const savedUser = await addUser();
    const token = await auth({ auth: { email: savedUser.email, password: 'Password1' } });
    await deleteUser(savedUser.id, { token: token });
    const inDBToken = await Token.findOne({ where: { token: token } });
    expect(inDBToken).toBeNull();
  });
  it('deletes all token from database when request is sent from authorized user', async () => {
    const savedUser = await addUser();
    const token1 = await auth({ auth: { email: savedUser.email, password: 'Password1' } });
    const token2 = await auth({ auth: { email: savedUser.email, password: 'Password1' } });
    await deleteUser(savedUser.id, { token: token1 });
    const inDBToken = await Token.findOne({ where: { token: token2 } });
    expect(inDBToken).toBeNull();
  });
});
