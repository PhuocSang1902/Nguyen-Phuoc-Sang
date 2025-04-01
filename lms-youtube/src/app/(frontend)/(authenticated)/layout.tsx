import { redirect } from 'next/navigation'
import React, { ReactNode } from 'react'
import { getUser } from './actions/getUser'
import Navbar from './components/Navbar'

interface Props {
  children: ReactNode
}

const Layout = async ({ children }: Props) => {
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

export default Layout
