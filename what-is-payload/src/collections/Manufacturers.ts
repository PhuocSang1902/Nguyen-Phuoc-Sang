import { CollectionConfig } from 'payload'

export const Manufacturers: CollectionConfig = {
  slug: 'manufacturers',
  admin: { useAsTitle: 'title' },
  hooks: {
    afterRead: [
      ({ doc }) => {
        doc.doILikeIt = doc.title.includes('Vantage')
        return doc
      },
    ],
  },
  fields: [
    { name: 'title', type: 'text' },
    { name: 'logo', type: 'upload', relationTo: 'media' },
    { name: 'cars', type: 'relationship', relationTo: 'cars', hasMany: true },
  ],
}
