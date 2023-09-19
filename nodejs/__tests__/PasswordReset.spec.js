const request = require('supertest');
const app = require('../src/app');
const en = require('../locales/en/translation.json');
const vn = require('../locales/vn/translation.json');

describe('Password Reset Request', () => {
  it('returns 404 when a password rest request is sent for unknown e-mail', async () => {
    const response = (await request(app).post('/api/1.0/password-reset')).send({ email: 'user1@gmail.com' });
    expect(response.status).toBe(404);
  });
  it.each`
    language | message
    ${'vn'}  | ${vn.email_not_inuse}
    ${'en'}  | ${en.email_not_inuse}
  `(
    'return error body with $message for unknow email for password reset request when language is set to $language',
    async ({ language, message }) => {
      const nowInMillis = new Date().getTime();
      const response = (await request(app).post('/api/1.0/password-reset'))
        .set('Accept-Language', language)
        .send({ email: 'user1@gmail.com' });
      expect(response.body.path).toEqual('/api/1.0/password-reset');
      expect(response.body.timestamp).toBeGreaterThan(nowInMillis);
      expect(response.body.message).toBe(message);
    },
  );
});
