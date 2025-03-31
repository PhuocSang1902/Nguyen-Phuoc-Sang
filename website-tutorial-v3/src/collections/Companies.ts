import { CollectionConfig } from 'payload'

export const Companies: CollectionConfig = {
  slug: 'companies',
  admin: {
    useAsTitle: 'label',
  },
  fields: [
    {
      name: 'generateLabel',
      type: 'ui',
      admin: {
        components: { Field: '/src/components/GenerateCompanyLable' },
      },
    },
    { name: 'label', label: 'Label', type: 'text', admin: { hidden: true mm} },
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
    },
    {
      name: 'logo',
      label: 'Logo',
      type: 'upload',
      relationTo: 'media',
    },
    {
      name: 'website',
      label: 'Website',
      type: 'text',
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
      admin: {
        components: {
          Cell: '/src/components/cells/AddressCell',
        },
      },
    },
  ],
}
