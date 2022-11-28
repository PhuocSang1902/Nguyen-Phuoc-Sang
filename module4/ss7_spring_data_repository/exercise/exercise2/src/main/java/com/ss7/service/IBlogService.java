package com.ss7.service;

import com.ss7.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findByTitleContainingOrAuthor(String content, String author);
}
