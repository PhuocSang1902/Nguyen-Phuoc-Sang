import configPromise from '@payload-config'
import { getPayload } from 'payload'
import { getUser } from '../../../_actions/getUser'
import { notFound } from 'next/navigation'
import Link from 'next/link'
import { HiArrowLeft } from 'react-icons/hi'
import CourseViewer from './_components/CourseViewer'

export default async function ParticipationPage({
  params,
}: {
  params: Promise<{ participationId: string }>
}) {
  const { participationId } = await params

  const payload = await getPayload({ config: configPromise })

  const user = await getUser()

  let participation = null

  try {
    const res = await payload.findByID({
      collection: 'participation',
      id: participationId,
      overrideAccess: false,
      user: user,
    })

    participation = res
  } catch (error) {
    console.error(error)
  }

  if (!participation) {
    return notFound()
  }

  return (
    <div className="flex flex-col w-full max-w-4xl mx-auto p-4 gap-4">
      <Link
        href="/dashboard"
        className="inline-flex items-center gap-2 text-sm text-gray-300 hover:text-white transition duration-300 ease-in-out"
      >
        <HiArrowLeft className="text-lg" />
        Back to Dashboard
      </Link>

      <CourseViewer participation={participation} />
    </div>
  )
}
