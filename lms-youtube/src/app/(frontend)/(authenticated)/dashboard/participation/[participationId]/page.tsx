import configPromise from '@payload-config'
import { getPayload } from 'payload'
import { getUser } from '../../../_actions/getUser'
import { notFound } from 'next/navigation'
import Link from 'next/link'

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
    <div className="w-full max-w-4xl mx-auto p-6 flex flex-col gap-6 min-h-screen">
      <Link
        href="/dashboard"
        className="inline-flex items-center gap-2 text-sm text-gray-300 hover:text-white transition duration-300 ease-in-out"
      ></Link>
      <div>{participation.course.title}</div>
    </div>
  )
}
