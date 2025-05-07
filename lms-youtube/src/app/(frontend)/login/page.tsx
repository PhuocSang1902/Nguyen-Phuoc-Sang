import React, { ReactElement } from 'react'
import LoginForm from './_components/LoginForm'

export default function page() {
  return (
    <div className="h-[calc(100vh-3rem)] bg-black text-white">
      <LoginForm />
    </div>
  )
}
