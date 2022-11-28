package com.customermanegement.practice1.controller;

import com.customermanegement.practice1.model.Province;
import com.customermanegement.practice1.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProvinceController {
    final
    IProvinceService provinceService;

    public ProvinceController(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("provinceList")
    public String provinceList(Model model){
        Iterable<Province> provinceList = provinceService.findAll();
        model.addAttribute("provinceList", provinceList);
        return"/province/list";
    }
    @GetMapping("create-province")
    public String showCreateForm(Model model){
        model.addAttribute("province", new Province());
        return "/province/create";
    }
    @PostMapping("create-province")
    public String saveProvince(@ModelAttribute("province")Province province, Model model){
        provinceService.save(province);
        model.addAttribute("mess", "Add new successfully");
        return "/province/create";
    }
    @GetMapping("edit-province/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Province>province = provinceService.findById(id);
        if (province.isPresent()){
            model.addAttribute("province",province);
            return "/province/edit";
        }
        return "redirect:/provinceList";
    }
    @PostMapping("edit-province")
    public String editProvince(@ModelAttribute("province")Province province){
        provinceService.save(province);
        return"redirect:/provinceList";
    }
    @GetMapping("delete-province/{id}")
    public String deleteCustomerById(@PathVariable("id")Integer id){
        provinceService.remove(id);
        return "redirect:/provinceList";
    }
}
