import { NextResponse } from 'next/server';

export default function middleware(request) {
  return NextResponse.next();
}
