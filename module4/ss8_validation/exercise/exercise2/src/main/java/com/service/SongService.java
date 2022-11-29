package com.service;

import com.model.Song;
import com.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService{
    @Autowired
    ISongRepository songRepository;
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }
}
