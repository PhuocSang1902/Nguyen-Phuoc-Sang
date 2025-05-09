import { Block } from 'payload'

export const FinishBlock: Block = {
  slug: 'finish',
  labels: { singular: 'Finish', plural: 'Finishes' },
  fields: [
    {
      name: 'template',
      label: 'CertificateTemplate',
      type: 'code',
      required: true,
      admin: {
        description: 'The template for the certificate',
        language: 'html',
      },
    },
  ],
}
