'use client'
import { appClient } from 'payload-auth-plugin/client'
import { Button } from '@payloadcms/ui'

export default function AuthButton() {
  return (
    <button
      type="button"
      className="w-full !my-0"
      onClick={() => {
        console.log('redirect uri', process.env.GOOGLE_REDIRECT_URI)
        window.location.href = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${process.env.GOOGLE_CLIENT_ID}&redirect_uri=${process.env.GOOGLE_REDIRECT_URI}&response_type=code&scope=email%20profile&prompt=select_account`
      }}
    >
      Sign in with Google
    </button>
  )
}
