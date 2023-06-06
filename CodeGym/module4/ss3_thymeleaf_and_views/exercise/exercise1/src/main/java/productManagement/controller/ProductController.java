package productManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import productManagement.model.Product;
import productManagement.service.impl.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String showList(Model model){
        List<Product> productList = productService.getList();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("show-add-form")
    public String showAddForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("add")
    public String add(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("show-edit-form")
    public String showEditForm(Model model, int id){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Product product, int id){
        productService.edit(product, id);
        return "redirect:/";
    }
    @PostMapping("delete")
    public String remove(int id){
        productService.remove(id);
        return "redirect:/";
    }
    @GetMapping("search")
    public String search(String search, Model model){
        List<Product> productList = productService.search(search);
        model.addAttribute("productList", productList);
        return "list";
    }
}
