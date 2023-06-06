package com.example.service;

import com.example.model.BorrowedBook;

import java.util.List;
import java.util.Optional;

public interface IBorrowedBookService {
    boolean save(BorrowedBook borrowedBook);

    boolean exist(long code);

    Optional<BorrowedBook> findByCode(long code);

    List<BorrowedBook> findAll();

    Optional<BorrowedBook> findById(Integer id);
}
