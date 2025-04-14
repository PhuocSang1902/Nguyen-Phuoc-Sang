import axios from 'axios'
import { Payload } from 'payload'

interface Venue {
  id: string
  name: string
  type: string
  url: string
  locale: string
  aliases?: string[]
  images?: {
    ratio: string
    url: string
    width: number
    height: number
    fallback: boolean
  }[]
  postalCode: string
  timezone: string
  city: {
    name: string
  }
  state: {
    name: string
    stateCode: string
  }
  country: {
    name: string
    countryCode: string
  }
  address: {
    line1: string
  }
  location: {
    longitude: string
    latitude: string
  }
  markets: {
    name: string
    id: string
  }[]
  dmas: {
    id: number
  }[]
  social?: {
    twitter: {
      handle: string
    }
  }
  boxOfficeInfo?: {
    phoneNumberDetail: string
    openHoursDetail: string
    acceptedPaymentDetail: string
    willCallDetail: string
  }
  parkingDetail?: string
  accessibleSeatingDetail?: string
  generalInfo?: {
    generalRule: string
    childRule: string
  }
  upcomingEvents?: {
    archtics?: number
    ticketmaster?: number
    tmr?: number
    universe?: number
    _total: number
    _filtered: number
  }
  ada?: {
    adaPhones: string
    adaCustomCopy: string
    adaHours: string
  }
}

export async function syncTicketmasterVenues(payload: Payload): Promise<void> {
  const apiKey = process.env.TICKETMASTER_API_KEY

  if (!apiKey) {
    console.error('TICKETMASTER_API_KEY is not defined in .env')
    return
  }

  const url = `https://app.ticketmaster.com/discovery/v2/venues?apikey=${apiKey}`

  try {
    const response = await axios.get(url)
    const venues: Venue[] = response.data._embedded?.venues || []

    for (const venue of venues) {
      if (!venue) {
        continue
      }

      // Check if venue already exists
      const existingVenue = await payload.find({
        collection: 'venues',
        where: {
          id: { equals: venue.id },
        },
      })

      if (existingVenue.docs.length === 0) {
        // Create new venue
        await payload.create({
          collection: 'venues',
          data: {
            id: venue.id,
            name: venue.name,
            type: venue.type,
            locale: venue.locale,
            url: venue.url,
            aliases: venue.aliases?.map((alias) => ({ alias })) || [],
            images:
              venue.images?.map((img) => ({
                ratio: img.ratio,
                url: img.url,
                width: img.width,
                height: img.height,
                fallback: img.fallback,
              })) || [],
            location: {
              longitude: venue.location?.longitude,
              latitude: venue.location?.latitude,
            },
            postalCode: venue.postalCode,
            timeZone: venue.timezone,
            city: venue.city?.name,
            state: {
              name: venue.state?.name,
              stateCode: venue.state?.stateCode,
            },
            country: {
              name: venue.country?.name,
              countryCode: venue.country?.countryCode,
            },
            address: {
              line1: venue.address?.line1,
            },
            markets:
              venue.markets?.map((market) => ({
                name: market.name,
                id: market.id,
              })) || [],
            dmas: venue.dmas?.map((dma) => ({ id: String(dma.id) })) || [],
            social: {
              twitter: {
                handle: venue.social?.twitter?.handle,
              },
            },
            boxOfficeInfo: {
              phoneNumberDetail: venue.boxOfficeInfo?.phoneNumberDetail,
              openHoursDetail: venue.boxOfficeInfo?.openHoursDetail,
              acceptedPaymentDetail: venue.boxOfficeInfo?.acceptedPaymentDetail,
              willCallDetail: venue.boxOfficeInfo?.willCallDetail,
            },
            parkingDetail: venue.parkingDetail,
            generalInfo: {
              generalRule: venue.generalInfo?.generalRule,
              childRule: venue.generalInfo?.childRule,
            },
          },
        })
        console.log(`Created venue: ${venue.name}`)
      } else {
        console.log(`Venue ${venue.name} already exists`)
      }
    }
    console.log('Ticketmaster venues sync completed successfully')
  } catch (error) {
    console.error('Error syncing Ticketmaster venues:', error)
  }
}
