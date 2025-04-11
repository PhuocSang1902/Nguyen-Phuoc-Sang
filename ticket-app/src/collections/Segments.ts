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
      type: 'array',
      fields: [
        { name: 'id', type: 'text', required: true },
        { name: 'name', type: 'text', required: true },
        // Lưu trữ subGenres như một array lồng nhau
        {
          name: 'subGenres',
          type: 'array',
          fields: [
            { name: 'id', type: 'text', required: true },
            { name: 'name', type: 'text', required: true },
          ],
        },
      ],
    },
  ],
}

export default Segments
