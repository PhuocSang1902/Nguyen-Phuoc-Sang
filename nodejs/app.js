const express = require('express');

const app = express();

app.post('/api/1.0/users', (req, res) => {
  return res.send({ message: 'User created' });
});

app.listen(3000, () => console.log('app is running!'));

module.exports = app;
