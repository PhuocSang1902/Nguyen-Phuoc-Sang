// collections/Events.ts
import { CollectionConfig } from 'payload'

const Events: CollectionConfig = {
  slug: 'events',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
    { name: 'type', type: 'text' },
    { name: 'locale', type: 'text' },
    { name: 'url', type: 'text' },
    { name: 'sales', type: 'json' },
    { name: 'dates', type: 'json' },
    {
      name: 'attractions',
      type: 'relationship',
      relationTo: 'attractions',
      hasMany: true,
    },
    { name: 'pleaseNote', type: 'text' },
    { name: 'promoter', type: 'text' },
    // Mối quan hệ với Venue
    { name: 'venue', type: 'relationship', relationTo: 'venues' },
    // Mối quan hệ với Images
    {
      name: 'images',
      type: 'relationship',
      relationTo: 'media',
      hasMany: true,
    },
    // Mối quan hệ với Info và Classifications
    { name: 'info', type: 'text' },
    { name: 'classifications', type: 'json' },
  ],
}

export default Events
