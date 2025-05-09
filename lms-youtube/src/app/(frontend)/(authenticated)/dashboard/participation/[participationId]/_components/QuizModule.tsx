'use client'

import { useEffect, useState } from 'react'
import { Participation } from '@/payload-types'
import NextButton from './NextButton'
import { markProgress } from '../_actions/markProgress'
import { HiDocumentSearch } from 'react-icons/hi'

interface QuizModuleProps {
  module: any
  participation: Participation
  onCompleted: (nextIndex: number) => void
}

export default function QuizModule({ module, participation, onCompleted }: QuizModuleProps) {
  const [message, setMessage] = useState('')
  const [userAnswers, setUserAnswers] = useState([])
  const [loading, setLoading] = useState(false)
  const [allAnswerCorrect, setAllAnswerCorrect] = useState(false)

  useEffect(() => {
    setEmptyUserAnswers()
  }, [])

  async function setEmptyUserAnswers() {
    const temp = module.questions.map((question: any) => {
      return question.answers.map((answer: any) => {
        return false
      })
    })
    setUserAnswers(temp)
  }

  async function handleNextModule() {
    setLoading(true)
    try {
      const updatedParticipation = await markProgress(participation)
      if (updatedParticipation?.progress) {
        onCompleted(updatedParticipation.progress)
      } else {
        console.error('Failed to update participation progress')
      }
    } catch (err) {
      console.error(err)
    } finally {
      setLoading(false)
    }
  }

  function checkAnswer(answerIndex: number) {
    let correct = true
    const length = module.questions[answerIndex].answers.length

    for (let n = 0; n < length; n++) {
      const val = module.questions[answerIndex].answers[n].correct ? true : false
      if (userAnswers[answerIndex][n] !== val) {
        correct = false
        break
      }
    }

    return correct
  }

  function checkAllAnswers() {
    for (let n = 0; n < module.questions.length; n++) {
      if (!checkAnswer(n)) {
        setMessage('Some answers are incorrect')
        return false
      }
    }
    return true
  }

  function handleCheckAnswers() {
    if (checkAllAnswers()) {
      setAllAnswerCorrect(true)
      setUserAnswers([])
    }
  }

  return (
    <div className="w-full flex flex-col gap-6">
      <h2 className="text-2xl font-bold">{module.title}</h2>
      <div className="relative w-full aspect-video border border-white overflow-y-auto p-6">
        {module.questions.map((question: any, index: number) => {
          return (
            <div key={index} className="flex flex-col gap-4 mb-6">
              <p className="font-bold">
                {index + 1}. {question.question}
              </p>
              {question.answers.map((answer: any, answerIndex: number) => {
                return (
                  <div key={`${index}-${answerIndex}`} className="flex items-center cursor-pointer">
                    <input
                      type="checkbox"
                      id={`answer-${index}-${answerIndex}`}
                      onClick={(e) => {
                        setMessage('')
                        const tempUserAnswers = JSON.parse(JSON.stringify(userAnswers))
                        tempUserAnswers[index][answerIndex] = e.currentTarget.checked
                        setUserAnswers(tempUserAnswers)
                      }}
                      className="h-4 w-4 text-teal-400 bg-gray-100 border-gray-600 rounded-full focus:ring-teal-500 focus:ring-2"
                    />
                    <label
                      htmlFor={`answer-${index}-${answerIndex}`}
                      className="ml-4 text-white text-2xl font-medium text-gray-300"
                    >
                      {answer.answer}
                    </label>
                  </div>
                )
              })}
            </div>
          )
        })}
      </div>

      {message && <div className="text-red-500 p-2 font-bold">{message}</div>}

      <div className="flex flex-col gap-4 justify-center">
        {allAnswerCorrect ? (
          <NextButton loading={loading} text="Next" onClick={handleNextModule} />
        ) : (
          <div>
            <button
              disabled={allAnswerCorrect}
              onClick={handleCheckAnswers}
              className="flex gap-2 items-center border border-white px-4 py-2"
            >
              Check Answers
              <HiDocumentSearch className="h-4 w-4" />
            </button>
          </div>
        )}
      </div>
    </div>
  )
}
