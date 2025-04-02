import React from 'react'
import Image from 'next/image'
import logo from '@/assets/logo.svg'

export default function Logo() {
  return (
    <div>
      <Image className="h-20 object-contain" src={logo} alt="Logo" />
    </div>
  )
}
