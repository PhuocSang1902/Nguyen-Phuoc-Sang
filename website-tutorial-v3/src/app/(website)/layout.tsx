import React from 'react'
import HeaderServer from '../../blocks/global/Header/Server'
import FooterServer from '../../blocks/global/Footer/Server'

export default function Layout({ children }: { children: React.ReactNode }) {
  return (
    <div>
      <HeaderServer />
      {children}
      <FooterServer />
    </div>
  )
}
