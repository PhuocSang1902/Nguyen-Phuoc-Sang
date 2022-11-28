package com.ss7.controller;

import com.ss7.model.Blog;
import com.ss7.model.Category;
import com.ss7.service.IBlogService;
import com.ss7.service.ICategoryService;
import com.ss7.service.impl.BlogService;
import com.ss7.service.impl.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {
    private IBlogService blogService;
    private ICategoryService categoryService;

    public BlogController(BlogService blogService, CategoryService categoryService){
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        Iterable<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/blog/create";
    }

    @PostMapping("create")
    public String saveBlog(@ModelAttribute("blog")Blog blog, Model model){
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("mess", "New blog created successfully");
        return "/blog/create";
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "")String search, Model model){
        List<Blog> blogList = blogService.findByTitleContainingOrAuthor(search, search);
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog.get());
            Iterable<Category> categoryList = categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            return "/blog/edit";
        }
        return "/";
    }

    @PostMapping("edit")
    public String editBlog(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id")Integer id, Model model){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            model.addAttribute("blog", blog.get());
            return "/blog/detail";
        }
        return "/blog";
    }
    @PostMapping("remove")
    public String removeBlog(Integer id){
        blogService.remove(id);
        return "redirect:/blog";
    }
}
