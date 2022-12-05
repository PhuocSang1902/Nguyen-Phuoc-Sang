package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blogs")
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Page<Blog>> showListBlog(@PageableDefault(value = 0, size = 2,sort = {"author"}) Pageable pageable){
        Page<Blog> blogList =  blogService.findAll(pageable);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<BlogDto> showBlogDetail(@PathVariable("id")Integer id){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            BlogDto blogDto = new BlogDto();
            BeanUtils.copyProperties(blog.get(), blogDto);
            return new ResponseEntity<>(blogDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("")
    public ResponseEntity saveNewBlog(@RequestBody BlogDto blogDto){
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Blog> removeBlog(@PathVariable("id")Integer id){
        Blog blog = blogService.findById(id).get();
        blogService.remove(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);

    }
    @PatchMapping("")
    public ResponseEntity<Blog> saveEditBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
