'use client'

import { useState, MouseEvent } from 'react'
import { AiOutlineCheckCircle, AiOutlineLoading } from 'react-icons/ai'
import { HiExclamation, HiPlay } from 'react-icons/hi'
import { participate } from '../../../../_actions/participate'
import { useRouter } from 'next/navigation'
import { Course, Participation } from '../../../../../../../payload-types'
import Link from 'next/link'

export default function ResumeButton({ participation }: { participation: Participation }) {
  const course: Course = participation.course
  const courseLength = course.curriculum.length
  const progress = participation.progress ?? 0
  const progressPercentage = Math.round((progress / courseLength) * 100)

  return (
    <Link
      href={`/dashboard/participation/${participation.id}`}
      className="w-full bg-teal-500 text-white hover:bg-teal-600 font-bold transition rounded duration-300 ease-in-out overflow-hidden"
    >
      <div className="flex flex-row items-center justify-between pl-2">
        <p className="text-sm font-semibold">{course.title}</p>
        <div className="flex items-center justify-center bg-teal-600 h-12 w-12 rounded-full">
          <HiPlay className="w-6 h-6 " />
        </div>
      </div>
      <div className="absolute bottom-0 left-0 w-full h-1 overflow-hidden">
        <div className="h-full bg-white" style={{ width: `${progressPercentage}%` }}></div>
      </div>
    </Link>
  )
}
