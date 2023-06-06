package com.controller;

import com.dto.SongDto;
import com.model.Song;
import com.service.ISongService;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id")Integer id, Model model){
        Optional<Song> song = songService.findById(id);
        if (song.isPresent()){
            model.addAttribute("songDto", song.get());
            return "/edit";
        }
        return "/create";
    }
    @PostMapping("edit")
    public String edit(@Validated @ModelAttribute("songDto")SongDto songDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        return "redirect:/";
    }
    @GetMapping("")
    public String showList(Pageable pageable,Model model){
        Page<Song> songList = songService.findAll(pageable);
        model.addAttribute("songList", songList);
        return "/list";
    }

}
