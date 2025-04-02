import React from 'react'
import Image from 'next/image'
import logo from '@/assets/logo.svg'

export default function Icon() {
  return (
    <div>
      <Image className="h-20 object-contain" src={logo} alt="Logo" />
    </div>
  )
}
