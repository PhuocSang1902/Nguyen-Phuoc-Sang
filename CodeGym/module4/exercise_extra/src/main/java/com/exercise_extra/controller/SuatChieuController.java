package com.exercise_extra.controller;

import com.exercise_extra.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SuatChieuController {
    @Autowired
    IPhimService phimService;
}
