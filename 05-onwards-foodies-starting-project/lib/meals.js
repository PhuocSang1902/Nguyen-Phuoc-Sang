import fs from 'node:fs';
import sql from 'better-sqlite3';
import slugify from 'slugify';
import xss from 'xss';

const db = sql('meals.db');

export async function getMeals() {
  await new Promise((resolve) => setTimeout(resolve, 1000));

  // throw new Error('Loading meals failed');
  return db.prepare('SELECT * FROM meals').all();
}

export async function getMeal(mealSlug) {
  return db.prepare('SELECT * FROM meals WHERE slug = ?').get(mealSlug);
}

export async function saveMeal(meal) {
  meal.slug = slugify(meal.title, { lower: true });
  meal.instructions = xss(meal.instructions);

  const extension = meal.image.name.split('.').pop();
  const filename = `${meal.slug}.${extension}`;

  const fileStream = fs.createWriteStream(`public/images/${filename}`);
  const bufferImage = await meal.image.arrayBuffer();
  fileStream.write(Buffer.from(bufferImage), (err) => {
    if (err) {
      throw new Error('Failed to save image');
    }
  });
  meal.image = `/images/${filename}`;

  fileStream.end();

  const stmt = db.prepare(
    'INSERT INTO meals (title, summary, instructions, image, creator, creator_email, slug) VALUES (?, ?, ?, ?, ?, ?, ?)'
  );
  stmt.run(
    meal.title,
    meal.summary,
    meal.instructions,
    meal.image,
    meal.creator,
    meal.creator_email,
    meal.slug
  );
}
