'use server'

import { getPayload } from 'payload'
import configPromise from '@payload-config'
import { headers as getHeaders } from 'next/headers'
import type { Payload } from 'payload'
import { Customer } from '../../../../payload-types'

export const getUser = async (): Promise<Customer | null> => {
  const headers = await getHeaders()
  console.log('headers', headers)
  const payload: Payload = await getPayload({ config: configPromise })

  const { user } = await payload.auth({ headers })
  return user || null
}
