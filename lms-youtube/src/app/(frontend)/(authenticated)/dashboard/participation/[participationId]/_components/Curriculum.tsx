import { Course } from '@/payload-types'
import { HiPencilAlt, HiVideoCamera } from 'react-icons/hi'

export default function Curriculum({
  course,
  currentProgress,
}: {
  course: Course
  currentProgress: number
}) {
  return (
    <div className="flex flex-col gap-4 max-h-[20rem] overflow-y-auto">
      {course.curriculum.map((block, index) => {
        const isCurrent = index === currentProgress

        const baseClass = 'p-4 border rounded bg-gray-900'
        const borderClass = isCurrent ? 'border-white' : 'border-gray-700'

        const classNames = `${baseClass} ${borderClass}`

        if (block.blockType === 'video') {
          return (
            <div key={index} className={classNames}>
              <div className="flex items-center gap-2 text-teal-400 font-semibold">
                <HiVideoCamera className="text-xl" />
                {block.title}
              </div>
              <div className="text-sm text-gray-400">Duration: {block.duration} min</div>
            </div>
          )
        }

        if (block.blockType === 'quiz') {
          return (
            <div key={index} className={classNames}>
              <div className="flex items-center gap-2 text-teal-400 font-semibold">
                <HiPencilAlt className="text-xl" />
                {block.title}
              </div>
              <div className="text-sm text-gray-400">Questions: {block.questions?.length || 0}</div>
            </div>
          )
        }

        return null
      })}
    </div>
  )
}
