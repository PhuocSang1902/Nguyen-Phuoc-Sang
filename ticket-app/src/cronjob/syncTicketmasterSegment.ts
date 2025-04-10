import axios from 'axios'
import { Payload } from 'payload'

interface Segment {
  id: string
  name: string
  _embedded: {
    genres: {
      id: string
      name: string
      _embedded: {
        subGenres: {
          id: string
          name: string
        }[]
      }
    }[]
  }
}

export async function syncTicketmasterSegment(payload: Payload): Promise<void> {
  const apiKey = process.env.TICKETMASTER_API_KEY

  if (!apiKey) {
    console.error('TICKETMASTER_API_KEY is not defined in .env')
    return
  }

  const url = `https://app.ticketmaster.com/discovery/v2/classifications?apikey=${apiKey}`

  try {
    const response = await axios.get(url)
    const classifications: any[] = response.data._embedded?.classifications || []

    for (const classification of classifications) {
      const segment: Segment = classification?.segment
      // Kiểm tra xem sự kiện đã tồn tại chưa
      console.log('segment', JSON.stringify(segment, null, 2))
      const existingSegment = await payload.find({
        collection: 'segments',
        where: {
          id: { equals: segment.id },
        },
      })

      if (existingSegment.docs.length === 0) {
        // Nếu chưa tồn tại, tạo mới
        await payload.create({
          collection: 'segments',
          data: {
            id: segment.id,
            name: segment.name,
          },
        })
        console.log(`Created segment: ${segment.name}`)
      } else {
        console.log(`Segment ${segment.name} already exists`)
      }
    }
    console.log('Ticketmaster sync completed successfully')
  } catch (error) {
    console.error('Error syncing Ticketmaster events:', error)
  }
}
