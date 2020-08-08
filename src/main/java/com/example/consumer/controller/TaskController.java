package com.example.consumer.controller;

import com.example.consumer.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @GetMapping(value = "{id}")
  public String findById(@PathVariable Long id) {
    System.out.println(taskService.findById(id).getDescription());
    return "redirect:/";
  }

  @GetMapping("all")
  public String findAll(){
    taskService.findAll().forEach(task-> System.out.println(task.getDescription()));
    return "redirect:/";
  }

}
