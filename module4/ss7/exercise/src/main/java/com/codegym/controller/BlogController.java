package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.impl.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    private IBlogService blogService;

    public BlogController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("create-blog")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("create-blog")
    public String saveBlog(@ModelAttribute("blog")Blog blog, Model model){
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("mess", "New blog created successfully");
        return "/create";
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "")String search, Model model){
        List<Blog> blogList = blogService.findByTitleContainingOrAuthor(search, search);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
    @GetMapping("edit-blog/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog.get());
            return "/edit";
        }
        return "/";
    }

    @PostMapping("edit-blog")
    public String editBlog(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id")Integer id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog.get());
            return "/detail";
        }
        return "/";
    }
    @PostMapping("remove-blog")
    public String removeBlog(Integer id){
        blogService.remove(id);
        return "redirect:/";
    }
}
