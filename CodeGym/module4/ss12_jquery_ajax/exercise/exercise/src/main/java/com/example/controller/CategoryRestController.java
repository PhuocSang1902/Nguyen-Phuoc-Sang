package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryRestController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> showListCategory() {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Set<Blog>> showBlogListInCategory(@PathVariable("id") Integer id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            Set<Blog> blogSet = category.get().getBlogSet();
            return new ResponseEntity<>(blogSet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
