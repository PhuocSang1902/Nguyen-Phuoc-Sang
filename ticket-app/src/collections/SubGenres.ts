// collections/SubGenres.ts
import { CollectionConfig } from 'payload'

const SubGenres: CollectionConfig = {
  slug: 'sub-genres',
  admin: {
    useAsTitle: 'name',
  },
  fields: [
    { name: 'id', type: 'text', required: true, unique: true },
    { name: 'name', type: 'text', required: true },
  ],
}

export default SubGenres
