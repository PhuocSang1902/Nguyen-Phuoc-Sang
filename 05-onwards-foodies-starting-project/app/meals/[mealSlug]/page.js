export default function MealsPage({ param }) {
  return (
    <main>
      <h1>Meals Page</h1>
      <h1>{param.mealSlug}</h1>
    </main>
  );
}
