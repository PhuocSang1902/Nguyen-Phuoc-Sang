package com.example.controller;

import com.example.model.BorrowedBook;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("borrow")
public class BorrowedBookController {
    @Autowired
    IBorrowedBookService borrowedBookService;
    @GetMapping("")
    public String showList(Model model){
        List<BorrowedBook> borrowedBookList = borrowedBookService.findAll();
        model.addAttribute("borrowedBookList", borrowedBookList);
        return "/borrowedBook/list";
    }
    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id")Integer id, Model model){
        Optional<BorrowedBook> borrowedBook = borrowedBookService.findById(id);
        model.addAttribute("borrowedBook", borrowedBook.get());
        return"/borrowedBook/detail";
    }
}
