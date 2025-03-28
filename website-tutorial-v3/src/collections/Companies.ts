import { CollectionConfig } from 'payload'

export const Companies: CollectionConfig = {
  slug: 'companies',
  fields: [
    {
      name: 'name',
      label: 'Name',
      type: 'text',
      required: true,
    },
    {
      name: 'description',
      label: 'Description',
      type: 'richText',
      required: true,
    },
    {
      name: 'logo',
      label: 'Logo',
      type: 'upload',
      relationTo: 'media',
      required: true,
    },
    {
      name: 'website',
      label: 'Website',
      type: 'text',
      required: true,
    },
    {
      name: 'address',
      label: 'Address',
      type: 'group',
      fields: [
        {
          name: 'street',
          label: 'Street',
          type: 'text',
          required: true,
        },
        {
          type: 'row',
          fields: [
            {
              name: 'zip',
              label: 'Zip',
              type: 'text',
              required: true,
            },
            {
              name: 'city',
              label: 'City',
              type: 'text',
              required: true,
            },
          ],
        },
      ],
    },
  ],
}
