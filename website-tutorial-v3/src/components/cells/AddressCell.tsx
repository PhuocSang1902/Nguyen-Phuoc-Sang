import Link from 'next/link'
import { DefaultServerCellComponentProps } from 'payload'
import React from 'react'

export default function AddressCell({ cellData }: DefaultServerCellComponentProps) {
  const address = `${cellData.street} ${cellData.city} ${cellData.zip}`
  const googleMapsUrl = `https://www.google.com/maps/search/?api=1&query=${encodeURIComponent(address)}`

  return (
    <Link href={googleMapsUrl} target="_blank">
      <p>{cellData.street}</p>
      <p>
        {cellData.zip} {cellData.city}
      </p>
    </Link>
  )
}
