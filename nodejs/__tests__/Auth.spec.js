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

const postAuthentication = async (credentials, options = {}) => {
  let agent = request(app).post('/api/1.0/auth');
  if (options.language) {
    agent.set('Accept-Language', options.language);
  }
  return await agent.send(credentials);
};

const postLogout = (options = {}) => {
  const agent = request(app).post('/api/1.0/logout');
  if (options.token) {
    agent.set('Authrization', `Bearer ${options.token}`);
  }
  return agent.send();
};

describe('Authentication', () => {
  it('returns 200 when credentials are correct', async () => {
    await addUser();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    expect(response.status).toBe(200);
  });
  it('returns only user id and username and token when login success', async () => {
    const user = await addUser();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    expect(response.body.id).toBe(user.id);
    expect(response.body.username).toBe(user.username);
    expect(Object.keys(response.body)).toEqual(['id', 'username', 'token']);
  });
  0;
  it('returns 401 when user does not exist', async () => {
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    expect(response.status).toBe(401);
  });
  it('returns proper error body when authentication fails', async () => {
    const nowInMillis = new Date().getTime();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    const error = response.body;
    expect(error.path).toBe('/api/1.0/auth');
    expect(error.timestamp).toBeGreaterThan(nowInMillis);
    expect(Object.keys(error)).toEqual(['path', 'timestamp', 'message']);
  });
  it.each`
    language | message
    ${'vn'}  | ${vn.authentication_failure}
    ${'en'}  | ${en.authentication_failure}
  `('return $message for authentication fail when language is set to $language', async ({ language, message }) => {
    const response = await postAuthentication(
      { email: 'user1@gmail.com', password: 'Password1' },
      { language: language },
    );
    expect(response.body.message).toBe(message);
  });
  it('returns 401 when password is wrong', async () => {
    await addUser();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'password' });
    expect(response.status).toBe(401);
  });
  it('returns 403 when login in with an inactive account', async () => {
    await addUser({ ...activeUser, inactive: true });
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    expect(response.status).toBe(403);
  });
  it('returns proper error body when inactive authentication fails', async () => {
    await addUser({ ...activeUser, inactive: true });
    const nowInMillis = new Date().getTime();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    const error = response.body;
    expect(error.path).toBe('/api/1.0/auth');
    expect(error.timestamp).toBeGreaterThan(nowInMillis);
    expect(Object.keys(error)).toEqual(['path', 'timestamp', 'message']);
  });
  it.each`
    language | message
    ${'vn'}  | ${vn.inactive_authentication_failure}
    ${'en'}  | ${en.inactive_authentication_failure}
  `(
    'return $message when authentication fails for iactive account and language is set to $language',
    async ({ language, message }) => {
      await addUser({ ...activeUser, inactive: true });
      const response = await postAuthentication(
        { email: 'user1@gmail.com', password: 'Password1' },
        { language: language },
      );
      expect(response.body.message).toBe(message);
    },
  );
  it('returns 401 when e-mail is not valid', async () => {
    const response = await postAuthentication({ password: 'password' });
    expect(response.status).toBe(401);
  });
  it('returns 401 when password is not valid', async () => {
    const response = await postAuthentication({ email: 'user1@gmail.com' });
    expect(response.status).toBe(401);
  });
  it('returns token in response body when credentials are correct', async () => {
    await addUser();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    expect(response.body.token).not.toBeUndefined();
  });
});

describe('Logout', () => {
  it('returns 200 ok when unauthorization request send for logout', async () => {
    const response = await postLogout();
    expect(response.status).toBe(200);
  });
  it('removes the token from database', async () => {
    await addUser();
    const response = await postAuthentication({ email: 'user1@gmail.com', password: 'Password1' });
    const token = response.body.token;
    await postLogout({ token: token });
    const storedToken = await Token.findOne({ where: { token: token } });
    expect(storedToken).toBeNull();
  });
});

describe('Token Expiration', () => {
  const putUser = async (id = 5, body = null, options = {}) => {
    let agent = request(app);

    agent = request(app).put('/api/1.0/users/' + id);

    if (options.token) {
      agent.set('Authorization', `Bearer ${options.token}`);
    }
    return agent.send(body);
  };
  it('returns 403 when token is older than 1 week', async () => {
    const savedUser = await addUser();

    const token = 'test-token';
    const oneWeekAgo = new Date(Date.now() - 7 * 24 * 60 * 60 * 1000 - 1);
    await Token.create({
      token: token,
      userId: savedUser.id,
      lastUsedAt: oneWeekAgo,
    });
    const validUpdate = { username: 'user1-updated' };
    const response = await putUser(savedUser.id, validUpdate, { token: token });
    expect(response.status).toBe(403);
  });
  it('refreshes lastUsedAt when unexpired token is used', async () => {
    const savedUser = await addUser();

    const token = 'test-token';
    const fourDayAgo = new Date(Date.now() - 4 * 24 * 60 * 60 * 1000);
    await Token.create({
      token: token,
      userId: savedUser.id,
      lastUsedAt: fourDayAgo,
    });
    const validUpdate = { username: 'user1-updated' };
    const rightBeforeSendingRequest = new Date();
    await putUser(savedUser.id, validUpdate, { token: token });
    const tokenInDb = await Token.findOne({ where: { token: token } });
    expect(tokenInDb.lastUsedAt.getTime()).toBeGreaterThan(rightBeforeSendingRequest);
  });
  it('refreshes lastUsedAt when unexpired token is used for authentication endpoint', async () => {
    const savedUser = await addUser();

    const token = 'test-token';
    const fourDayAgo = new Date(Date.now() - 4 * 24 * 60 * 60 * 1000);
    await Token.create({
      token: token,
      userId: savedUser.id,
      lastUsedAt: fourDayAgo,
    });
    const rightBeforeSendingRequest = new Date();
    (await request(app).get('/api/1.0/users/5')).setEncoding('Authorization', `Bearer ${token}`)
    const tokenInDb = await Token.findOne({ where: { token: token } });
    expect(tokenInDb.lastUsedAt.getTime()).toBeGreaterThan(rightBeforeSendingRequest);
  });
});
