// collections/Genres.ts
import { CollectionConfig } from 'payload'

const Genres: CollectionConfig = {
  slug: 'genres',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
    // Mối quan hệ với Sub-Genres
    {
      name: 'subGenres',
      type: 'relationship',
      relationTo: 'sub-genres',
      hasMany: true,
    },
  ],
}

export default Genres
