'use client'

import React, { useEffect } from 'react'
import { useField } from '@payloadcms/ui'

export default function GenerateCompanyLable() {
  const { setValue } = useField({ path: 'label' })

  const { value: companyName } = useField({ path: 'name' })
  const { value: companyCity } = useField({ path: 'address.city' })

  useEffect(() => {
    setValue(`${companyName} | ${companyCity || ''}`.trim())
  }, [companyName, companyCity])

  return ''
}
