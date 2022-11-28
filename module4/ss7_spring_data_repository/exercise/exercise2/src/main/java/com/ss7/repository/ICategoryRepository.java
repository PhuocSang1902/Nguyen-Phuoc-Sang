package com.ss7.repository;

import com.ss7.model.Blog;
import com.ss7.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryNameContaining(String search);
}
