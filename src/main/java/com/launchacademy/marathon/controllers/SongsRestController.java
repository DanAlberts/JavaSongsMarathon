package com.launchacademy.marathon.controllers;

import com.launchacademy.marathon.models.Songs;
import com.launchacademy.marathon.repositories.SongsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongsRestController {

  @Autowired
  private SongsRepository songsRepo;

  @GetMapping("/api/V1/songs")
  public Page<Songs> getList(Pageable pageable) {
    return songsRepo.findAll(pageable);
  }

  @GetMapping("/api/V1/songs/{id}")
  public Songs getOne(@PathVariable Integer id) {
    return songsRepo.findById(id).orElseThrow(UrlNotFoundException::new);
  }

  @NoArgsConstructor
  private class UrlNotFoundException extends RuntimeException {

  };

  @ControllerAdvice
  private class UrlNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UrlNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(UrlNotFoundException e) {
      return e.getMessage();
    }
  }
}
