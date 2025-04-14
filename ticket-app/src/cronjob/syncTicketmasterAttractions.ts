import axios from 'axios'
import { Payload } from 'payload'

interface Attraction {
  id: string
  name: string
  type: string
  url: string
  locale: string
  externalLinks?: {
    youtube?: { url: string }[]
    twitter?: { url: string }[]
    itunes?: { url: string }[]
    lastfm?: { url: string }[]
    spotify?: { url: string }[]
    facebook?: { url: string }[]
    wiki?: { url: string }[]
    instagram?: { url: string }[]
    musicbrainz?: { id: string; url: string }[]
    homepage?: { url: string }[]
  }
  aliases?: string[]
  images?: {
    ratio: string
    url: string
    width: number
    height: number
    fallback: boolean
    attribution?: string
  }[]
  classifications?: {
    primary: boolean
    segment: { id: string; name: string }
    genre: { id: string; name: string }
    subGenre: { id: string; name: string }
    type: { id: string; name: string }
    subType: { id: string; name: string }
    family: boolean
  }[]
  _links?: {
    self: { href: string }
  }
}

export async function syncTicketmasterAttractions(payload: Payload): Promise<void> {
  const apiKey = process.env.TICKETMASTER_API_KEY

  if (!apiKey) {
    console.error('TICKETMASTER_API_KEY is not defined in .env')
    return
  }

  const url = `https://app.ticketmaster.com/discovery/v2/attractions?apikey=${apiKey}&page=0&size=20`

  try {
    const response = await axios.get(url)
    const attractions: Attraction[] = response.data._embedded?.attractions || []

    for (const attraction of attractions) {
      if (!attraction) {
        continue
      }

      // Check if attraction already exists
      const existingAttraction = await payload.find({
        collection: 'attractions',
        where: {
          id: { equals: attraction.id },
        },
      })

      if (existingAttraction.docs.length === 0) {
        // Create new attraction
        await payload.create({
          collection: 'attractions',
          data: {
            id: attraction.id,
            name: attraction.name,
            type: attraction.type,
            url: attraction.url,
            locale: attraction.locale,
            externalLinks: {
              youtube: attraction.externalLinks?.youtube?.map((link) => ({ url: link.url })) || [],
              twitter: attraction.externalLinks?.twitter?.map((link) => ({ url: link.url })) || [],
              itunes: attraction.externalLinks?.itunes?.map((link) => ({ url: link.url })) || [],
              lastfm: attraction.externalLinks?.lastfm?.map((link) => ({ url: link.url })) || [],
              spotify: attraction.externalLinks?.spotify?.map((link) => ({ url: link.url })) || [],
              facebook:
                attraction.externalLinks?.facebook?.map((link) => ({ url: link.url })) || [],
              wiki: attraction.externalLinks?.wiki?.map((link) => ({ url: link.url })) || [],
              instagram:
                attraction.externalLinks?.instagram?.map((link) => ({ url: link.url })) || [],
              musicbrainz:
                attraction.externalLinks?.musicbrainz?.map((link) => ({
                  id: link.id,
                  url: link.url,
                })) || [],
              homepage:
                attraction.externalLinks?.homepage?.map((link) => ({ url: link.url })) || [],
            },
            aliases: attraction.aliases?.map((alias) => ({ alias })) || [],
            images:
              attraction.images?.map((img) => ({
                ratio: img.ratio,
                url: img.url,
                width: img.width,
                height: img.height,
                fallback: img.fallback,
                attribution: img.attribution,
              })) || [],
            classifications:
              attraction.classifications?.map((cls) => ({
                primary: cls.primary,
                segment: {
                  id: cls.segment.id,
                  name: cls.segment.name,
                },
                genre: {
                  id: cls.genre.id,
                  name: cls.genre.name,
                },
                subGenre: {
                  id: cls.subGenre.id,
                  name: cls.subGenre.name,
                },
                type: {
                  id: cls.type.id,
                  name: cls.type.name,
                },
                subType: {
                  id: cls.subType.id,
                  name: cls.subType.name,
                },
                family: cls.family,
              })) || [],
            links: {
              self: {
                href: attraction._links?.self?.href,
              },
            },
          },
        })
        console.log(`Created attraction: ${attraction.name}`)
      } else {
        console.log(`Attraction ${attraction.name} already exists`)
      }
    }
    console.log('Ticketmaster attractions sync completed successfully')
  } catch (error) {
    console.error('Error syncing Ticketmaster attractions:', error)
  }
}
