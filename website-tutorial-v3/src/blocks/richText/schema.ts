import { lexicalEditor } from '@payloadcms/richtext-lexical'
import { Block } from 'payload'

export const RichText: Block = {
  slug: 'richText',
  fields: [
    {
      name: 'content',
      label: 'Content',
      type: 'richText',
      required: true,
      editor: lexicalEditor({}),
    },
  ],
}
