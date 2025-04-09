// collections/Attractions.ts
import { CollectionConfig } from 'payload'

const Attractions: CollectionConfig = {
  slug: 'attractions',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
    { name: 'type', type: 'text' },
    {
      name: 'images',
      type: 'relationship',
      relationTo: 'media',
      hasMany: true,
    },
    { name: 'url', type: 'text' },
    { name: 'classifications', type: 'json' },
    { name: 'locale', type: 'text' },
    // Mối quan hệ với Venues
    {
      name: 'venues',
      type: 'relationship',
      relationTo: 'venues',
      hasMany: true,
    },
  ],
}

export default Attractions
