const transporter = require('../config/emailTransporter');

const sendAccountActivation = async (email, token) => {
  await transporter.sendMail({
    from: 'My App <info@myapp.com>',
    to: email,
    subject: 'Account activation',
    html: `Token is ${token}`,
  });
};

module.exports = { sendAccountActivation };