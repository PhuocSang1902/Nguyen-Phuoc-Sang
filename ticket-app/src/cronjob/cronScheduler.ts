import cron from 'node-cron'
import { Payload } from 'payload'
import { syncTicketmasterSegment } from './syncTicketmasterSegment'
import { syncTicketmasterVenues } from './syncTicketmasterVenues'
import { syncTicketmasterAttractions } from './syncTicketmasterAttractions'
import { syncTicketmasterEvents } from './syncTicketmasterEvent'

export function startCronJobs(payload: Payload): void {
  if (process.env.ENABLE_CRON_JOBS !== 'true') {
    console.log('Cron jobs are disabled')
    return
  }

  cron.schedule('0 0 * * *', async () => {
    console.log('Starting syncTicketmasterSegment cron job...')
    await syncTicketmasterSegment(payload)
  })

  cron.schedule('15 0 * * *', async () => {
    console.log('Starting syncTicketmasterVenues cron job...')
    await syncTicketmasterVenues(payload)
  })

  cron.schedule('30 0 * * *', async () => {
    console.log('Starting syncTicketmasterAttractions cron job...')
    await syncTicketmasterAttractions(payload)
  })

  cron.schedule('*/1 * * * *', async () => {
    console.log('Starting syncTicketmasterEvent cron job...')
    await syncTicketmasterEvents(payload)
  })

  console.log('All cron jobs scheduled')
}
