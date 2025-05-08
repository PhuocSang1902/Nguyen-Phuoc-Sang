'use client'

import { AiOutlineLoading3Quarters } from 'react-icons/ai'

interface NextButtonProps {
  loading: boolean
  text: string
  onClick: () => void
}

export default function NextButton({ loading, text, onClick }: NextButtonProps) {
  return (
    <button
      className="bg-teal-500 relative text-black py-2 rounded-md w-full"
      onClick={onClick}
      disabled={loading}
    >
      {text}
      <div className="h-full absolute top-0 left-2 flex items-center justify-center">
        <AiOutlineLoading3Quarters className={`animate-spin ${loading ? 'block' : 'hidden'}`} />
      </div>
    </button>
  )
}
