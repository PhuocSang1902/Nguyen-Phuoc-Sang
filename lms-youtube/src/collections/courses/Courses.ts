import { CollectionConfig } from 'payload'
import { VideoBlock } from './blocks/VideoBlock'
import { QuizBlock } from './blocks/QuizBlock'

export const Courses: CollectionConfig = {
  slug: 'courses',
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
