import React from 'react'
import { User } from '../payload-types'
import { Payload } from 'payload'

interface WelcomeMessageProps {
  user: User
  payload: Payload
}

async function WelcomeMessage({ user, payload }: WelcomeMessageProps) {
  const companies = await payload.count({
    collection: 'companies',
    where: {
      id: {
        equals: user.id,
      },
    },
  })

  console.log('companies', companies)

  return (
    <div>
      <h1>Welcome back, {user.name}</h1>
      <p>You have store {companies.totalDocs} companies</p>
    </div>
  )
}

export default WelcomeMessage
