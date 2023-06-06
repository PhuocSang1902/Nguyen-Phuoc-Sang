package com.case_study.controller;

import com.case_study.dto.CustomerDto;
import com.case_study.dto.FacilityDto;
import com.case_study.model.facility.Facility;
import com.case_study.model.facility.FacilityType;
import com.case_study.model.facility.RentType;
import com.case_study.service.facility.IFacilityService;
import com.case_study.service.facility.IFacilityTypeService;
import com.case_study.service.facility.IRentTypeService;
import com.case_study.dtoView.FacilityView;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("facility")
public class FacilityController {
    final
    IFacilityService facilityService;
    IFacilityTypeService facilityTypeService;
    IRentTypeService rentTypeService;


    public FacilityController(IFacilityService facilityService, IFacilityTypeService facilityTypeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "") String facilityName,
                           @RequestParam(defaultValue = "-1") int facilityTypeId,
                           @PageableDefault(size = 5) Pageable pageable,
                           Model model) {
        Page<FacilityView> facilityList = facilityService.showList(facilityName, facilityTypeId, pageable);
        model.addAttribute("facilityList", facilityList);
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("facilityName", facilityName);
        model.addAttribute("facilityTypeId", facilityTypeId);
        return "/facility/list";
    }

    @GetMapping("create")
    public String ShowCreateForm(Model model) {
        Facility facility = Facility.builder().build();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("facility", facility);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "/facility/form";
    }

    @GetMapping("edit/{id}")
    public String ShowEditForm(@PathVariable("id") int id, Model model) {
        Optional<Facility> facility = facilityService.findById(id);
        if (facility.isPresent()) {
            FacilityDto facilityDto = FacilityDto.builder().build();
            Facility editFacility = facility.get();
            BeanUtils.copyProperties(editFacility, facilityDto);
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("facility", facilityDto);
            return "/facility/form";
        }
        return "redirect:/facility";
    }

    @PostMapping("save")
    public String saveFacility(@Validated @ModelAttribute("facility") FacilityDto facilityDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        FacilityDto.builder().build().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            List<RentType> rentTypeList = rentTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("mess", "Thông tin không chính xác");
            return "/facility/form";
        }
        Facility facility = Facility.builder().build();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Lưu thành công");
        return "redirect:/facility";
    }

    @GetMapping("remove")
    public String removeFacility(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        facilityService.removeById(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/facility";
    }
}
