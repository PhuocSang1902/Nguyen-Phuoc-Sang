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
    {
      name: 'aliases',
      type: 'array',
      fields: [
        {
          name: 'alias',
          type: 'text',
        },
      ],
    },
    {
      name: 'location',
      type: 'group',
      fields: [
        {
          name: 'longitude',
          type: 'text',
        },
        {
          name: 'latitude',
          type: 'text',
        },
      ],
    },
    {
      name: 'images',
      type: 'array',
      fields: [
        {
          name: 'ratio',
          type: 'text',
        },
        {
          name: 'url',
          type: 'text',
        },
        {
          name: 'width',
          type: 'number',
        },
        {
          name: 'height',
          type: 'number',
        },
        {
          name: 'fallback',
          type: 'checkbox',
        },
      ],
    },
    { name: 'extensions', type: 'json' },
    { name: 'source', type: 'text' },
    {
      name: 'markets',
      type: 'array',
      fields: [
        {
          name: 'name',
          type: 'text',
        },
        {
          name: 'id',
          type: 'text',
        },
      ],
    },
    { name: 'timeZone', type: 'text' },
    {
      name: 'address',
      type: 'group',
      fields: [
        {
          name: 'line1',
          type: 'text',
        },
      ],
    },
    { name: 'city', type: 'text' },
    {
      name: 'country',
      type: 'group',
      fields: [
        {
          name: 'name',
          type: 'text',
        },
        {
          name: 'countryCode',
          type: 'text',
        },
      ],
    },
    {
      name: 'state',
      type: 'group',
      fields: [
        {
          name: 'name',
          type: 'text',
        },
        {
          name: 'stateCode',
          type: 'text',
        },
      ],
    },
    { name: 'postalCode', type: 'text' },
    {
      name: 'dmas',
      type: 'array',
      fields: [
        {
          name: 'id',
          type: 'text',
        },
      ],
    },
    {
      name: 'social',
      type: 'group',
      fields: [
        {
          name: 'twitter',
          type: 'group',
          fields: [
            {
              name: 'handle',
              type: 'text',
            },
          ],
        },
      ],
    },
    {
      name: 'boxOfficeInfo',
      type: 'group',
      fields: [
        {
          name: 'phoneNumberDetail',
          type: 'text',
        },
        {
          name: 'openHoursDetail',
          type: 'text',
        },
        {
          name: 'acceptedPaymentDetail',
          type: 'text',
        },
        {
          name: 'willCallDetail',
          type: 'text',
        },
      ],
    },
    {
      name: 'parkingDetail',
      type: 'text',
    },
    {
      name: 'generalInfo',
      type: 'group',
      fields: [
        {
          name: 'generalRule',
          type: 'text',
        },
        {
          name: 'childRule',
          type: 'text',
        },
      ],
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
