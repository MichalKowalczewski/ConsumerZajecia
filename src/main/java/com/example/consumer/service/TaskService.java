package com.example.consumer.service;

import com.example.consumer.model.Task;

import java.util.List;

public interface TaskService {

  Task findById(Long id);
  List<Task> findAll();
  void delete(Long id);

}
