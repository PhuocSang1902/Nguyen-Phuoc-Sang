'use client'

import { useState, MouseEvent } from 'react'
import { AiOutlineCheckCircle, AiOutlineLoading } from 'react-icons/ai'
import { HiExclamation, HiPlay } from 'react-icons/hi'
import { participate } from '../../../../_actions/participate'
import { useRouter } from 'next/navigation'

export default function StartCourseButton({ courseId }: { courseId: string }) {
  const [status, setStatus] = useState<'loading' | 'idle' | 'error'>('idle')
  const [error, setError] = useState<string | null>(null)

  const router = useRouter()

  const handleStartCourse = async (e: MouseEvent<HTMLButtonElement>) => {
    setStatus('loading')
    setError(null)

    try {
      const participation = await participate({ courseId })

      if (!participation) {
        throw new Error('Error creating participation')
      }

      router.push(`/dashboard/participation/${participation.id}`)
    } catch (error) {
      console.error(error)
      setStatus('error')
      setError('Failed to start course. Please try again.')
    }
  }

  const isLoading = status === 'loading'

  const isError = status === 'error'

  const buttonIcon = isLoading ? (
    <AiOutlineLoading className="animate-spin text-xl" />
  ) : isError ? (
    <AiOutlineCheckCircle className="animate-spin" />
  ) : (
    <HiPlay className="text-xl" />
  )

  return (
    <div className="mt-6">
      <button
        onClick={handleStartCourse}
        disabled={isLoading}
        className={`relative inline-flex items-center gap-2 px-6 py-3 font-semibold rounded transition-colors duration-300 ease-in-out
          ${isError ? 'bg-red-600 text-white' : 'bg-teal-500 text-white hover:bg-teal-600'}
          disabled:opacity-50 disabled:cursor-not-allowed`}
      >
        <div className="absolute left-4 top-1/2 transform -translate-y-1/2">{buttonIcon}</div>
        <span className="pl-6">Start Course</span>
      </button>
      {isError && (
        <p className="mt-2 text-sm text-red-400 flex items-center gap-2">
          <HiExclamation className="text-lg" />
          {error}
        </p>
      )}
    </div>
  )
}
