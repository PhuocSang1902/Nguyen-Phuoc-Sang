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

import javax.swing.text.html.Option;
import java.util.*;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowedBookService borrowedBookService;

    @GetMapping("create")
    public String showCreateForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/book/create";
    }

    @PostMapping("create")
    public String save(@ModelAttribute("book") Book book, Model model) {
        book.setQuantityAvailable(book.getTotalQuantity());
        bookService.save(book);
        model.addAttribute("mess", "Book added new successfully");
        return "/book/create";
    }

    @GetMapping("")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }

    @GetMapping("detail/{id}")
    public String bookDetail(@PathVariable("id") Integer id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/detail";
        }
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/edit";
        }
        return "redirect:/";
    }

    @PostMapping("edit")
    public String saveEdit(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {

        book.setQuantityAvailable(book.getTotalQuantity() - book.getBorrowedBookList().size());
        if (book.getQuantityAvailable()>=0) {
            bookService.save(book);
            redirectAttributes.addFlashAttribute("mess", "Book is edited successfully");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("mess", "Total Quantity is not correct");
        return "redirect:/";
    }
    @GetMapping("remove/{id}")
    public String saveRemoveBook(@PathVariable("id")Integer id, Model model){
        bookService.removeById(id);
        model.addAttribute("mess", "This book is removed successfully");
        return "redirect:/";
    }
}
