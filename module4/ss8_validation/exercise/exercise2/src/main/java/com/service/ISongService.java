package com.service;

import com.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISongService {
    void save(Song song);

    Optional<Song> findById(Integer id);

    Page<Song> findAll(Pageable pageable);
}
