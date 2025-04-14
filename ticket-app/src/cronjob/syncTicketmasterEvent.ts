import axios from 'axios'
import { Payload } from 'payload'

interface Event {
  id: string
  name: string
  type: string
  test: boolean
  locale: string
  url: string
  sales: any
  dates: any
  _embedded: {
    venues: { id: string }[]
    attractions: { id: string }[]
  }
  pleaseNote: string
  promoter: any
  promoters: any[]
  info: string
  classifications: any[]
  seatmap: any
  accessibility: any
  ticketLimit: any
  ageRestrictions: any
  ticketing: any
  images: { ratio: string; url: string; width: number; height: number; fallback: boolean }[]
  outlets: { url: string; type: string }[]
}

export async function syncTicketmasterEvents(payload: Payload): Promise<void> {
  const apiKey = process.env.TICKETMASTER_API_KEY

  if (!apiKey) {
    console.error('TICKETMASTER_API_KEY is not defined in .env')
    return
  }

  const url = `https://app.ticketmaster.com/discovery/v2/events?apikey=${apiKey}`

  try {
    const response = await axios.get(url)
    const events: Event[] = response.data._embedded?.events || []

    for (const event of events) {
      // Kiểm tra xem sự kiện đã tồn tại chưa
      const existingEvent = await payload.find({
        collection: 'events',
        where: {
          id: { equals: event.id },
        },
      })

      if (existingEvent.docs.length === 0) {
        // Nếu chưa tồn tại, tạo mới

        // Chuẩn bị dữ liệu cho các mối quan hệ
        const venueIds = event._embedded?.venues?.map((venue) => venue.id) || []
        const attractionIds = event._embedded?.attractions?.map((attraction) => attraction.id) || []

        // Chuẩn bị dữ liệu cho images (bây giờ là array, không cần collection media)
        const images =
          event.images?.map((image) => ({
            ratio: image.ratio,
            url: image.url,
            width: image.width,
            height: image.height,
            fallback: image.fallback,
          })) || []

        // Chuẩn bị dữ liệu cho outlets
        const outlets =
          event.outlets?.map((outlet) => ({
            url: outlet.url,
            type: outlet.type,
          })) || []

        await payload.create({
          collection: 'events',
          data: {
            id: event.id,
            name: event.name,
            type: event.type,
            test: event.test,
            locale: event.locale,
            url: event.url,
            sales: event.sales,
            dates: event.dates,
            attractions: attractionIds,
            pleaseNote: event.pleaseNote,
            promoter: event.promoter,
            venue: venueIds[0], // Giả định mỗi event chỉ có 1 venue
            images: images,
            info: event.info,
            classifications: event.classifications,
            seatmap: event.seatmap,
            accessibility: event.accessibility,
            ticketLimit: event.ticketLimit,
            ageRestrictions: event.ageRestrictions,
          },
        })
        console.log(`Created event: ${event.name}`)
      } else {
        console.log(`Event ${event.name} already exists`)
      }
    }
    console.log('Ticketmaster events sync completed successfully')
  } catch (error) {
    console.error('Error syncing Ticketmaster events:', error)
  }
}
