package com.service;

import com.model.Song;
import com.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository songRepository;
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
