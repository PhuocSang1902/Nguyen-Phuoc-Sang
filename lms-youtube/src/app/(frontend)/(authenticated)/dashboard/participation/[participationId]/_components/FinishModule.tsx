import { Course, Participation } from '@/payload-types'
import axios from 'axios'
import { useState } from 'react'
import NextButton from './NextButton'

export default function FinishModule({ participation }: { participation: Participation }) {
  const [loading, setLoading] = useState(false)

  async function handleDownloadCertificate() {
    setLoading(true)
    try {
      const course = participation.course as Course
      const response = await axios.get(`/api/printCertificate/${participation.id}`, {
        responseType: 'blob',
      })
      const url = window.URL.createObjectURL(response.data)
      const link = document.createElement('a')
      link.href = url
      link.setAttribute('download', `${course.title} Certificate.pdf`)
      document.body.appendChild(link)
      link.click()
    } catch (error) {
      console.error(error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="w-full flex flex-col gap-6">
      <h1 className="text-2xl font-bold">Congratulations!</h1>
      <p className="text-gray-400">You have completed the course.</p>
      <NextButton
        loading={loading}
        text="Download Certificate"
        onClick={handleDownloadCertificate}
      />
    </div>
  )
}
