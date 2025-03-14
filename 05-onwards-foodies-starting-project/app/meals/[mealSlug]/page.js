export default function MealDetailsPage({ param }) {
  return (
    <main>
      <h1>Meal Details</h1>
      <h1>{param.mealSlug}</h1>
    </main>
  );
}
