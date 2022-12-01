package com.example.service.impl;

import com.example.model.BorrowedBook;
import com.example.repository.IBorrowedBookRepository;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowedBookService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;
    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
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
