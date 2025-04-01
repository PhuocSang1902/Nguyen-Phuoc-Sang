'use client'

import React, { ReactElement, useState, FormEvent } from 'react'
import { useRouter } from 'next/navigation'
import SubmitButton from '../../components/SubmitButton'
import { login, LoginResponse } from '../actions/login'

export default function LoginForm(): ReactElement {
  const [error, setError] = useState<string | null>(null)
  const [isPending, setIsPending] = useState(false)
  const router = useRouter()

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault()
    setIsPending(true)
    setError(null)

    const formData = new FormData(e.currentTarget)
    const email = formData.get('email') as string
    const password = formData.get('password') as string

    const result: LoginResponse = await login({ email, password })

    setIsPending(false)

    if (result.success) {
      router.push('/dashboard')
    } else {
      setError(result.error || 'An error occurred')
    }
  }

  return (
    <div className="flex gap-8 min-h-full flex-col justify-center items-center">
      <div className="text-h3">LoginForm</div>
      <div className="w-full mx-auto sm:max-w-sm">
        <form className="flex flex-col gap-4" onSubmit={handleSubmit}>
          <div className="flex flex-col gap-2">
            <label htmlFor="email">Email</label>
            <input className="w-full textInput" type="email" id="email" name="email" />
          </div>
          <div className="flex flex-col gap-2 mb-4">
            <label htmlFor="password">Password</label>
            <input className="w-full textInput" type="password" id="password" name="password" />
          </div>
          {error && <div className="text-red-500">{error}</div>}
          <SubmitButton loading={isPending} text="Login" />
        </form>
        <p className="mt-10 text-center text-sm text-black">
          Don&apos;t have an account?{' '}
          <a href="/register" className="text-blue-500">
            Signup
          </a>
        </p>
      </div>
    </div>
  )
}
