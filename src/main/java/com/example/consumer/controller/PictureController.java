package com.example.consumer.controller;

import com.example.consumer.model.Picture;
import com.example.consumer.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/picture")
public class PictureController {

  @Value("${resource.producer-host}")
  private String host;

  @Autowired
  PictureService pictureService;

  @GetMapping("/test")
  public String display(@RequestParam int id, Model model) {
    Picture picture = pictureService.findById(id);
    System.out.println(host + picture.getUrl());
    model.addAttribute("url", host + picture.getUrl());
    return "picture";
  }
}
