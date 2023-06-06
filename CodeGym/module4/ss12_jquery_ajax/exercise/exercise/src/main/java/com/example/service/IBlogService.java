package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService{

    Page<Blog> findAll(String search,Pageable pageable);

    Optional<Blog> findById(Integer Id);

    void save(Blog blog);

    void remove(Integer id);
}
