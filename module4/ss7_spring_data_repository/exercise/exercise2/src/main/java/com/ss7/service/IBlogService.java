package com.ss7.service;

import com.ss7.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findByTitleContainingOrAuthor(String content, String author, Pageable pageable);
}
