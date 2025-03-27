import type { Metadata } from 'next'

import config from '@payload-config'
import React, { cache } from 'react'

import type { Page as PageType } from '@/payload-types'

import { RenderBlocks } from '@/utils/RenderBlocks'
import { notFound } from 'next/navigation'
import { getPayloadHMR } from '@payloadcms/next/utilities'

const queryPageBySlug = cache(async ({ slug }: { slug: string }) => {
  const parsedSlug = decodeURIComponent(slug)

  const payload = await getPayloadHMR({ config })

  const result = await payload.find({
    collection: 'pages',
    limit: 1,
    where: {
      slug: {
        equals: parsedSlug,
      },
    },
  })

  return result.docs?.[0] || null
})

export async function generateStaticParams() {
  const payload = await getPayloadHMR({ config })
  const pages = await payload.find({
    collection: 'pages',
    draft: false,
    limit: 1000,
  })

  const slugs = pages.docs
    ?.filter((doc) => {
      return doc.slug !== 'index'
    })
    .map(({ slug }) => {
      return { slug }
    })

  return slugs
}

export default async function Page({ params: { slug = 'index' } }) {
  const page = await queryPageBySlug({
    slug,
  })

  if (!page) {
    return notFound()
  }

  return (
    <div className="pt-16 pb-24">
      <RenderBlocks blocks={page.layout} />
    </div>
  )
}
