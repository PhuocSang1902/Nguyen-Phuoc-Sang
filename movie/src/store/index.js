import { configureStore, createSlice } from '@reduxjs/toolkit';

const movieSlice = createSlice({
  name: 'movies',
  initialState: [],
  reducers: {},
});

const store = configureStore({
  reducer: {},
});

export default store;
