const express = require('express');
const User = require('./User');
const UserService = require('./UserService');
const router = express.Router();
const { check, validationResult } = require('express-validator');
const { max } = require('./User');

var Regex = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).*$/);

router.post(
  '/api/1.0/users',
  check('username')
    .notEmpty()
    .withMessage('username_null')
    .bail()
    .isLength({ min: 4, max: 32 })
    .withMessage('username_size')
    .bail(),
  check('email')
    .notEmpty()
    .withMessage('email_null')
    .bail()
    .isEmail()
    .withMessage('email_invalid')
    .bail()
    .custom(async (email) => {
      const user = await UserService.findByEmail(email);
      if (user) {
        throw new Error('email_inuse');
      }
    })
    .bail(),
  check('password')
    .notEmpty()
    .withMessage('password_null')
    .bail()
    .isLength({ min: 6 })
    .withMessage('password_size')
    .bail()
    .matches(Regex)
    .withMessage('password_invalid')
    .bail(),
  async (req, res) => {
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
      const validationErrors = {};
      errors.array().forEach((element) => {
        validationErrors[element.path] = element.msg;
      });
      return res.status(400).send({ validationErrors: validationErrors });
    }
    await UserService.save(req.body);
    return res.send({ message: 'User created' });
  },
);

module.exports = router;
