package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Songs;
import com.launchacademy.marathon.repositories.SongsRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/songs")
public class SongsController {

  @Autowired
  SongsRepository repository;

  @GetMapping
  public String getIndex(Model model) {
    Pageable pageable = PageRequest.of(0,10);
    Page<Songs> songs = repository.findAll(pageable);
    model.addAttribute("songs", songs);
    return "songs/index";
  }

  @GetMapping("/new")
  public String getNew(Model model) {
    Songs song = new Songs();
    model.addAttribute("song", song);
    return "songs/new";
  }

  @PostMapping("/new")
  public String saveSong(@ModelAttribute @Valid Songs song, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()) {
      return "songs/new";
    } else {
      repository.save(song);
      return "redirect:/songs";
    }
  }
}
