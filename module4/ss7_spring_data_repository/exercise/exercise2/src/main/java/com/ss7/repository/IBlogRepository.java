package com.ss7.repository;

import com.ss7.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByTitleContainingOrAuthor(String content, String author);
}
