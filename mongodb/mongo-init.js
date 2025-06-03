db = db.getSiblingDB('livestream');
db.createCollection('init');
db = db.getSiblingDB('example-payload-website');
db.createCollection('init');
