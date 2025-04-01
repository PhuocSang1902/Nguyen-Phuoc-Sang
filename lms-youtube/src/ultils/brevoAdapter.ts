import axios from 'axios'
import { EmailAdapter, SendEmailOptions } from 'payload'

const brevoAdapter = (): EmailAdapter => {
  const adapter = () => ({
    name: 'brevo',
    defaultFromAddress: process.env.BREVO_SENDER_EMAIL as string,
    defaultFromName: process.env.BREVO_SENDER_NAME as string,
    sendEmail: async (message: SendEmailOptions): Promise<unknown> => {
      if (!process.env.BREVO_EMAILS_ACTIVE) {
        console.log('Email service is not active')
        console.log(message)
        return
      }

      try {
        const response = await axios({
          method: 'POST',
          url: 'https://api.brevo.com/v3/smtp/email',
          headers: {
            'api-key': process.env.BREVO_API_KEY as string,
            'Content-Type': 'application/json',
            Accept: 'application/json',
          },
          data: {
            sender: {
              name: process.env.BREVO_SENDER_NAME as string,
              email: process.env.BREVO_SENDER_EMAIL as string,
            },
            to: [{ email: message.to }],
            subject: message.subject,
            textContent: message.text,
            htmlContent: message.html,
          },
        })

        return response.data
      } catch (error) {
        console.log('Error sending email', error)
      }
    },
  })

  return adapter
}

export default brevoAdapter
