// collections/Segments.ts
import { CollectionConfig } from 'payload'

const Segments: CollectionConfig = {
  slug: 'segments',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
    // Mối quan hệ với Genres
    {
      name: 'genres',
      type: 'relationship',
      relationTo: 'genres',
      hasMany: true,
    },
  ],
}

export default Segments
