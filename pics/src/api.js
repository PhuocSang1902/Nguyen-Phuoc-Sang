import axios from 'axios';

const searchImages = async (term) => {
  const response = await axios.get('https://api.unsplash.com/search/photos', {
    headers: {
      Authorization: `Client-ID slUs9m3kH4U-6JoPPBOl7cj2Cev76XBwJ0y5sChkEYI`,
    },
    params: {
      query: term,
    },
  });
  return response.data.results ;
};

export default searchImages;
