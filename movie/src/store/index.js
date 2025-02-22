import { configureStore } from '@reduxjs/toolkit';
import { addMovie, removeMovie, movieReducer } from './slices/moviesSlice';
import { addSong, removeSong, songsReducer } from './slices/songSlice';
import { reset } from './action';

const store = configureStore({
  reducer: {
    songs: songsReducer,
    movies: movieReducer,
  },
});

export { addSong, removeSong, addMovie, removeMovie, reset, store };
