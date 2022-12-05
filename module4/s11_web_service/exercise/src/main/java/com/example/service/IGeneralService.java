package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService <E> {

    Page<Blog> findAll(Pageable pageable);

    Optional<E> findById(Integer Id);

    void save(E e);

    void remove(Integer id);
}
