package com.example.dto;

import com.example.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


public class BlogDto {

    private Integer id;
    private String title;
    private String content;
    private String author;
    private String writingDate;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(Integer id, String title, String content, String author, String writingDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.writingDate = writingDate;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWritingDate() {
        return writingDate;
    }

    public void setWritingDate(String writingDate) {
        this.writingDate = writingDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
