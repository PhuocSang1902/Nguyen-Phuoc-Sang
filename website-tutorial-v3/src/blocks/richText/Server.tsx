'use client'

import React from 'react'
import type { DefaultNodeTypes, SerializedUploadNode } from '@payloadcms/richtext-lexical'
import type { SerializedEditorState } from '@payloadcms/richtext-lexical/lexical'

import { type JSXConvertersFunction, RichText } from '@payloadcms/richtext-lexical/react'
import Image from 'next/image'

type NodeTypes = DefaultNodeTypes

// Custom upload converter component that uses next/image
const CustomUploadComponent: React.FC<{
  node: SerializedUploadNode
}> = ({ node }) => {
  if (node.relationTo === 'media') {
    const uploadDoc = node.value
    if (typeof uploadDoc !== 'object') {
      return null
    }
    const { alt, height, url, width } = uploadDoc
    return <Image alt={alt} height={height ?? 0} src={url ?? ''} width={width ?? 0} />
  }

  return null
}

const jsxConverters: JSXConvertersFunction<NodeTypes> = ({ defaultConverters }) => ({
  ...defaultConverters,
  // Override the default upload converter
  upload: ({ node }) => {
    return <CustomUploadComponent node={node} />
  },
})

export default function RichTextBlockServer({ content }: { content: SerializedEditorState }) {
  return (
    <div className="max-w-5xl py-20 text-center">
      <RichText className="richText max-w-5xl mx-auto" data={content} converters={jsxConverters} />
    </div>
  )
}
