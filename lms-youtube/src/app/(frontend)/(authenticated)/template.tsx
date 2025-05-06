import { redirect } from 'next/navigation'
import React, { ReactNode } from 'react'
import { getUser } from './_actions/getUser'
import Navbar from './_components/Navbar'

interface TemplateProps {
  children: ReactNode
}

const Template = async ({ children }: TemplateProps) => {
  const user = await getUser()
  if (!user) {
    redirect('/login')
  }
  return (
    <div>
      <Navbar />
      {children}
    </div>
  )
}

export default Template
