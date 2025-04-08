export function GET(request) {
  console.log(request);
  return Response.json({ message: 'Hello, world!' });
}

export function POST(request) {
  return Response.json({ message: 'Hello, world!' });
}

export function PUT(request) {
  return Response.json({ message: 'Hello, world!' });
}
