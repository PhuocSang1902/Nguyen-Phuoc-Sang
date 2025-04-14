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
    { name: 'url', type: 'text' },
    { name: 'locale', type: 'text' },
    {
      name: 'externalLinks',
      type: 'group',
      fields: [
        {
          name: 'youtube',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'twitter',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'itunes',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'lastfm',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'spotify',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'facebook',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'wiki',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'instagram',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
        {
          name: 'musicbrainz',
          type: 'array',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'url', type: 'text' },
          ],
        },
        {
          name: 'homepage',
          type: 'array',
          fields: [{ name: 'url', type: 'text' }],
        },
      ],
    },
    {
      name: 'aliases',
      type: 'array',
      fields: [{ name: 'alias', type: 'text' }],
    },
    {
      name: 'images',
      type: 'array',
      fields: [
        { name: 'ratio', type: 'text' },
        { name: 'url', type: 'text' },
        { name: 'width', type: 'number' },
        { name: 'height', type: 'number' },
        { name: 'fallback', type: 'checkbox' },
        { name: 'attribution', type: 'text' },
      ],
    },
    {
      name: 'classifications',
      type: 'array',
      fields: [
        { name: 'primary', type: 'checkbox' },
        {
          name: 'segment',
          type: 'group',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'name', type: 'text' },
          ],
        },
        {
          name: 'genre',
          type: 'group',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'name', type: 'text' },
          ],
        },
        {
          name: 'subGenre',
          type: 'group',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'name', type: 'text' },
          ],
        },
        {
          name: 'type',
          type: 'group',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'name', type: 'text' },
          ],
        },
        {
          name: 'subType',
          type: 'group',
          fields: [
            { name: 'id', type: 'text' },
            { name: 'name', type: 'text' },
          ],
        },
        { name: 'family', type: 'checkbox' },
      ],
    },
    {
      name: 'links',
      type: 'group',
      fields: [
        {
          name: 'self',
          type: 'group',
          fields: [{ name: 'href', type: 'text' }],
        },
      ],
    },
  ],
}

export default Attractions
