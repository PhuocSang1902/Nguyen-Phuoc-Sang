// collections/Venues.ts
import { CollectionConfig } from 'payload'

const Venues: CollectionConfig = {
  slug: 'venues',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
    { name: 'type', type: 'text' },
    { name: 'locale', type: 'text' },
    { name: 'url', type: 'text' },
    { name: 'location', type: 'text' },
    { name: 'extensions', type: 'json' },
    { name: 'source', type: 'text' },
    {
      name: 'markets',
      type: 'array',
      fields: [{ name: 'market', type: 'text' }],
    },
    { name: 'timeZone', type: 'text' },
    { name: 'address', type: 'text' },
    { name: 'city', type: 'text' },
    { name: 'country', type: 'text' },
    { name: 'state', type: 'text' },
    { name: 'postalCode', type: 'text' },
    {
      name: 'dmas',
      type: 'array',
      fields: [{ name: 'dma', type: 'text' }],
    },
    // Mối quan hệ với Events
    {
      name: 'events',
      type: 'relationship',
      relationTo: 'events',
      hasMany: true,
    },
    // Mối quan hệ với Attractions
    {
      name: 'attractions',
      type: 'relationship',
      relationTo: 'attractions',
      hasMany: true,
    },
  ],
}

export default Venues
