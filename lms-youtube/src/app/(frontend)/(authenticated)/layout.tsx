import { redirect } from 'next/navigation'
import React, { ReactNode } from 'react'
import { getUser } from './actions/getUser'

interface Props {
  children: ReactNode
}

const Layout = async ({ children }: Props) => {
  const user = await getUser()
  if (!user) {
    redirect('/login')
  }
  return <>{children}</>
}

export default Layout
