import { getPayload } from 'payload'
import config from '@/payload.config'
import React from 'react'
import Image from 'next/image'
import Link from 'next/link'

export default async function FooterServer() {
  const payload = await getPayload({ config })
  const footer = await payload.findGlobal({ slug: 'footer' })

  return (
    <div className="bg-green-300 border-t border-t-green-500">
      <div className="py-12 max-w-5xl mx-auto flex justify-between w-full items-center">
        <div className="relative w-64 h-20 ">
          <Image src={footer.logo.url} alt={footer.logo.alt} fill className="object-contain" />
        </div>
        <div>{footer.copyrightNotice}</div>
        <div>
          {footer.nav.map((item, index) => (
            <Link key={index} href={item.link} className="text-white text-lg mx-4">
              {item.label}
            </Link>
          ))}
        </div>
      </div>
    </div>
  )
}
