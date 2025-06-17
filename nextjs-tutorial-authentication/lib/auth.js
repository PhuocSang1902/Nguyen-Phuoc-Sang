import { Lucia } from 'lucia';
import { BetterSqlite3Adapter } from '@lucia-auth/adapter-sqlite';
import db from './db';

const adapter = new BetterSqlite3Adapter(db, {
  user: 'users',
});

const lucia = new Lucia();
