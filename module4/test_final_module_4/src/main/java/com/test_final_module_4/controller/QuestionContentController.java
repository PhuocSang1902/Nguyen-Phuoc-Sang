package com.test_final_module_4.controller;

import com.test_final_module_4.model.QuestionContent;
import com.test_final_module_4.model.QuestionType;
import com.test_final_module_4.repository.IQuestionContentRepository;
import com.test_final_module_4.service.IQuestionContentService;
import com.test_final_module_4.service.IQuestionTypeService;
import com.test_final_module_4.service.impl.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionContentController {
    @Autowired
    IQuestionContentService questionContentService;
    @Autowired
    IQuestionTypeService questionTypeService;

    @GetMapping("")
    public String showList(@PageableDefault(size = 4) Pageable pageable, @RequestParam(defaultValue = "") String questionContent, @RequestParam(defaultValue = "-1") int questionTypeId, Model model) {
        Page<QuestionContent> questionContentList = questionContentService.findQuestion(questionContent, questionTypeId, pageable);
//        Page<QuestionContent> questionContentList1 = questionContentService.findAll(pageable);
        model.addAttribute("questionContentList", questionContentList);
        List<QuestionType> questionTypeList = questionTypeService.findAll();
        model.addAttribute("questionTypeList", questionTypeList);
        model.addAttribute("questionContent", questionContent);
        model.addAttribute("questionTypeId", questionTypeId);
        return "/list";
    }

    @GetMapping("remove")
    public String removeQuestion(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        questionContentService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        QuestionContent questionContent = new QuestionContent();
        model.addAttribute("questionContent", questionContent);
        List<QuestionType> questionTypeList = questionTypeService.findAll();
        model.addAttribute("questionTypeList", questionTypeList);
        return "/create";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<QuestionContent> questionContent = questionContentService.findById(id);
        if (questionContent.isPresent()) {
            model.addAttribute("questionContent", questionContent.get());
            List<QuestionType> questionTypeList = questionTypeService.findAll();
            model.addAttribute("questionTypeList", questionTypeList);
            return "/edit";
        }
        return "/";
    }

    @PostMapping("create")
    public String saveQuestion(@Validated @ModelAttribute("questionContent") QuestionContent questionContent, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()){
            List<QuestionType> questionTypeList = questionTypeService.findAll();
            model.addAttribute("questionTypeList", questionTypeList);
            redirectAttributes.addFlashAttribute("mess", "thông tin không chính xác");
            return "/create";
        }
        questionContent.setDateCreate(String.valueOf(LocalDate.now()));
        questionContentService.save(questionContent);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/";
    }
}
