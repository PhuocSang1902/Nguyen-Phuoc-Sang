package com.example.service;

import com.example.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Integer id);

    void borrow(Book book, long code);
}
