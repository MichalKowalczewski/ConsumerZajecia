package com.example.consumer.controller;

import com.example.consumer.model.Task;
import com.example.consumer.model.User;
import com.example.consumer.service.TaskService;
import com.example.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

  @Autowired
  private TaskService taskService;

  @Autowired
  private UserService userService;

  @GetMapping(value = "{id}")
  public String findById(@PathVariable Long id) {
    System.out.println(taskService.findById(id).getDescription());
    return "redirect:/";
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("tasks", taskService.findAll());
    model.addAttribute("newTask", new Task());
    model.addAttribute("users", userService.findAll());
    return "tasks";
  }

  @PostMapping(value = "delete")
  public String delete(@RequestParam Long id) {
    taskService.delete(id);
    return "redirect:/";
  }

  @PostMapping(value = "put")
  public String update(Task task) {
    Task tempTask = taskService.findById(task.getId());
    task.setUser(tempTask.getUser());
    taskService.update(task.getId(), task);
    return "redirect:/";
  }

  @PostMapping(value = "user-update")
  public String userUpdate(@RequestParam("taskId") Long taskId, @RequestParam("userId") Long id) {
    System.out.println("podaje id: "+id);
    Task tempTask = taskService.findById(taskId);
    if (id == null) {
      tempTask.setUser(null);
      taskService.update(tempTask.getId(), tempTask);
    } else {
      User user = userService.findById(id);
      tempTask.setUser(user);
      taskService.update(tempTask.getId(), tempTask);
    }
    return "redirect:/";
  }

  // rozwinąć to tak aby można było ustawiać userów

  @PostMapping
  public String create(@ModelAttribute("newTask") Task task) {
    taskService.create(task);
    return "redirect:/";
  }

}
