package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findByName(String search);
    List<Category> findAll();

    Optional<Category> findById(Integer Id);

    void save(Category category);

    void remove(Integer id);
}
