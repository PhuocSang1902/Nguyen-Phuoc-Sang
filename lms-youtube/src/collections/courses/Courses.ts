import { CollectionConfig } from 'payload'
import { VideoBlock } from './blocks/VideoBlock'
import { QuizBlock } from './blocks/QuizBlock'

export const Courses: CollectionConfig = {
  slug: 'courses',
  access: {
    read: ({ req: { user } }) => {
      return !!user
    },
    create: ({ req: { user } }) => {
      return user?.collection === 'users'
    },
    update: ({ req: { user } }) => {
      return user?.collection === 'users'
    },
    delete: ({ req: { user } }) => {
      return user?.collection === 'users'
    },
  },
  admin: {
    useAsTitle: 'title',
  },
  fields: [
    { name: 'title', label: 'Title', type: 'text', required: true },
    { name: 'description', label: 'Description', type: 'textarea', required: true },
    { name: 'image', label: 'Image', type: 'upload', required: true, relationTo: 'media' },
    {
      name: 'curriculum',
      label: 'Curriculum',
      type: 'blocks',
      required: true,
      blocks: [VideoBlock, QuizBlock],
    },
  ],
}
