package com.example.dto;

import com.example.model.Blog;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;


public class CategoryDto {
    private Integer id;
    private String categoryName;
    private Set<Blog> blogSet;

    public CategoryDto() {
    }

    public CategoryDto(Integer id, String categoryName, Set<Blog> blogSet) {
        this.id = id;
        this.categoryName = categoryName;
        this.blogSet = blogSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
