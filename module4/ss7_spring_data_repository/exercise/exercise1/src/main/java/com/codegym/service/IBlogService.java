package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    List<Blog> findByTitleContainingOrAuthor(String content, String author);
}
