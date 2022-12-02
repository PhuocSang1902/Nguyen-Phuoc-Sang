package com.example.controller;

import com.example.model.Book;
import com.example.model.BorrowedBook;
import com.example.service.IBookService;
import com.example.service.IBorrowedBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("borrow")
public class BorrowedBookController {
    @Autowired
    IBorrowedBookService borrowedBookService;
    @Autowired
    IBookService bookService;
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
    @GetMapping("{id}")
    public String saveBorrow(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) throws Exception {
        BorrowedBook borrowedBook = new BorrowedBook();
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent() && book.get().getQuantityAvailable() != 0) {
            long code;
            do {
                code = (long) (Math.random() * (99999 - 10000) + 10000);
            } while (borrowedBookService.exist(code));
            Set<Book> bookSet;
            if (borrowedBook.getBookList() != null) {
                bookSet = borrowedBook.getBookList();
            } else {
                bookSet = new LinkedHashSet<>();
            }
            bookSet.add(book.get());
            borrowedBook.setBookList(bookSet);
            borrowedBook.setCode(code);
            borrowedBookService.save(borrowedBook);
            book.get().setQuantityAvailable(book.get().getQuantityAvailable() - 1);
            bookService.save(book.get());
            redirectAttributes.addFlashAttribute("mess", "Book is borrowed successfully");
            redirectAttributes.addFlashAttribute("code", code);
            return "redirect:/";
        }
        throw new Exception();
    }

    @GetMapping("give-book-back")
    public String saveGiveBookBack(@RequestParam long code, RedirectAttributes redirectAttributes) throws Exception {
        Optional<BorrowedBook> borrowedBook = borrowedBookService.findByCode(code);
        if (borrowedBook.isPresent()) {
            boolean check = borrowedBookService.save(borrowedBook.get());
            if (check){
            redirectAttributes.addFlashAttribute("mess", "Give book back successfully");
            return "redirect:/";}
            else {
                redirectAttributes.addFlashAttribute("mess", "This borrow code given back before");
                return "redirect:/";
            }
        }
        throw new Exception();
    }
    @ExceptionHandler(Exception.class)
    public String handlerError(Exception e){
        return "/error";
    }
}
