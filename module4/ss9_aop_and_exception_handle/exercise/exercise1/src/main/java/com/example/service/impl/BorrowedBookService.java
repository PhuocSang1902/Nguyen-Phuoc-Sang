package com.example.service.impl;

import com.example.model.Book;
import com.example.model.BorrowedBook;
import com.example.repository.IBorrowedBookRepository;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BorrowedBookService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;
    @Override
    public boolean save(BorrowedBook borrowedBook) {
        if(borrowedBook.isStatus()){
            borrowedBook.setStatus(false);
            Set<Book> bookList = borrowedBook.getBookList();
            for (Book book : bookList) {
                book.setQuantityAvailable(book.getQuantityAvailable() + 1);
                borrowedBookRepository.save(borrowedBook);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exist(long code) {
        return borrowedBookRepository.existsByCode(code);
    }

    @Override
    public Optional<BorrowedBook> findByCode(long code) {
        return borrowedBookRepository.findBorrowedBookByCode(code);
    }

    @Override
    public List<BorrowedBook> findAll() {
        return borrowedBookRepository.findAll();
    }

    @Override
    public Optional<BorrowedBook> findById(Integer id) {
        return borrowedBookRepository.findById(id);
    }
}
