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
    {
      name: 'test',
      type: 'checkbox',
    },
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
    {
      name: 'promoter',
      type: 'json', // Updated to JSON to store the promoter object
    },
    // Mối quan hệ với Venue
    { name: 'venue', type: 'relationship', relationTo: 'venues' },
    // Mối quan hệ với Images
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
    // Mối quan hệ với Info và Classifications
    { name: 'info', type: 'text' },
    { name: 'classifications', type: 'json' },
    {
      name: 'seatmap',
      type: 'json', // Added to store seatmap information
    },
    {
      name: 'accessibility',
      type: 'json', // Added to store accessibility information
    },
    {
      name: 'ticketLimit',
      type: 'json', // Added to store ticket limit information
    },
    {
      name: 'ageRestrictions',
      type: 'json', // Added to store age restrictions
    },
  ],
}

export default Events
