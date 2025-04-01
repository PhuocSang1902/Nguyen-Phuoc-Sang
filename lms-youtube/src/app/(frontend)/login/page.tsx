import React, { ReactElement } from 'react'
import LoginForm from './components/LoginForm'

export default function page() {
  return (
    <div className="h-[calc(100vh-3rem)]">
      <LoginForm />
    </div>
  )
}
