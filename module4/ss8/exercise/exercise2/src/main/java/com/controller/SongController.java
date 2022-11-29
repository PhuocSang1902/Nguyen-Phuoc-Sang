package com.controller;

import com.dto.SongDto;
import com.model.Song;
import com.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping("create")
    public String showCreateForm(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);
        return "/create";
    }
    @PostMapping("create")
    public String save(@Validated @ModelAttribute("songDto")SongDto songDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        model.addAttribute("mess", "Song is added successfully");
        return "/create";
    }

}
