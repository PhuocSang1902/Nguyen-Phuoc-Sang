import cron from 'node-cron'
import { Payload } from 'payload'
import { syncTicketmasterSegment } from './syncTicketmasterSegment'

export function startCronJobs(payload: Payload): void {
  if (process.env.ENABLE_CRON_JOBS !== 'true') {
    console.log('Cron jobs are disabled')
    return
  }

  cron.schedule('*/1 * * * *', async () => {
    console.log('Starting syncTicketmasterSegment cron job...')
    await syncTicketmasterSegment(payload)
  })

  console.log('All cron jobs scheduled')
}
