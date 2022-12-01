package com.example.repository;

import com.example.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IBorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    boolean existsByCode(long code);
    Optional<BorrowedBook> findBorrowedBookByCode(long code);
}
