'use server';
import { createUser, getUserByEmail } from '@/lib/user';
import { hashUserPassword, verifyPassword } from '@/lib/hash';
import { redirect } from 'next/navigation';
import { createAuthSession, destroySession } from '@/lib/auth';

export async function signup(prevState, formData) {
  const email = formData.get('email');
  const password = formData.get('password');

  let errors = {};

  if (!email.includes('@')) {
    errors.email = 'Invalid email address';
  }

  if (password.trim().length < 8) {
    errors.password = 'Password must be at least 8 characters long';
  }

  if (Object.keys(errors).length > 0) {
    return { errors };
  }

  const hashedPassword = hashUserPassword(password);
  try {
    const userId = await createUser(email, hashedPassword);

    createAuthSession(userId);
    redirect('/training');
  } catch (error) {
    if (error.code === 'SQLITE_CONSTRAINT_UNIQUE') {
      errors.email = 'Email already exists';
      return { errors };
    }
    throw error; // Re-throw unexpected errors
  }
}

export async function login(prevState, formData) {
  const email = formData.get('email');
  const password = formData.get('password');

  const existingUser = getUserByEmail(email);

  if (!existingUser) {
    return {
      errors: {
        email: 'Could not authenticate user, please check your credentials.',
      },
    };
  }

  const isValidPassword = verifyPassword(existingUser.password, password);

  if (!isValidPassword) {
    return {
      errors: {
        password: 'Could not authenticate user, please check your credentials.',
      },
    };
  }

  await createAuthSession(existingUser.id);
  redirect('/training');
}

export async function auth(mode, prevState, formData) {
  if (mode === 'login') {
    return await login(prevState, formData);
  } else if (mode === 'signup') {
    return await signup(prevState, formData);
  } else {
    throw new Error('Invalid authentication mode');
  }
}

export async function logout() {
  await destroySession();
  redirect('/');
}
