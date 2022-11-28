package com.ss7.controller;

import com.ss7.model.Blog;
import com.ss7.model.Category;
import com.ss7.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("create")
    public String createCategory(@ModelAttribute("category") Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("category", new Category());
        model.addAttribute("mess", "Category added new successfully");
        return "/category/create";
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String search, Model model) {
        List<Category> categoryList = categoryService.findByName(search);
        model.addAttribute("categoryList", categoryList);
        return "/category/list";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category);
            return "/category/edit";
        }
        return "redirect:/category";
    }

    @PostMapping("edit")
    public String editCategory(@ModelAttribute("category") Category category, Model model) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("remove")
    public String remove(@RequestParam("id") Integer id) {
        categoryService.remove(id);
        return "redirect:/category";
    }

    @GetMapping("detail/{id}")
    public String categoryDetail(@PathVariable("id") Integer id, Model model) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            Set<Blog> blogList = category.get().getBlogSet();
            model.addAttribute("blogList", blogList);
        }
        return "/category/detail";
    }

}
