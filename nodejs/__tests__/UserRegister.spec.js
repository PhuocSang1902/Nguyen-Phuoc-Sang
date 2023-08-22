const request = require('supertest');
const app = require('../app');

describe('User Registration', () => {
  it('returns 200 ok when signup request is valid', (done) => {
    request(app)
      .post('/api/1.0/user')
      .send({
        username: 'user1',
        email: 'user1@gmail.com',
        password: 'password',
      })
      .then((response) => {
        expect(response.status).toBe(200);
        done();
      });
  });

  it('returns success message when signup request is valid', (done) => {
    request(app)
      .post('/api/1.0/user')
      .send({
        username: 'user1',
        email: 'user1@gmail.com',
        password: 'password',
      })
      .then((response) => {
        expect(response.body.message).toBe('User created');
        done();
      });
  });
});
