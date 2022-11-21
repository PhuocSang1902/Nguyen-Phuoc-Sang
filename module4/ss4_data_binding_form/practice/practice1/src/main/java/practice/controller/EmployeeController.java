package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.model.Employee;
import practice.service.EmployeeService;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public String home(Model model){
        List<Employee> employeeList = employeeService.getList();
        model.addAttribute("employeeList", employeeList);
        return "home";
    }

    @GetMapping("showAddForm")
    public String showAddForm(Model model){
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("add")
    public String add(@ModelAttribute Employee employee, RedirectAttributes attributes){
        boolean checkAdd = employeeService.add(employee);
        String mess;
        if(checkAdd){
            mess = "Thêm mới thành công";
        }else {
            mess = "Thêm mới không thành công";
        }
        attributes.addFlashAttribute("mess", mess);
        return "redirect:/";
    }

}
