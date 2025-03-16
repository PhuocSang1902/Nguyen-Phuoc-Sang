import sql from 'better-sqlite3';

const db = sql('meals.db');

export async function getMeals() {
  await new Promise((resolve) => setTimeout(resolve, 1000));

  // throw new Error('Loading meals failed');
  return db.prepare('SELECT * FROM meals').all();
}

export async function getMeal(mealSlug) {
  return db.prepare('SELECT * FROM meals WHERE slug = ?').get(mealSlug);
}
