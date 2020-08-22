package com.example.consumer.service;

import com.example.consumer.model.User;

import java.util.List;

public interface UserService {

  List<User> findAll();

  User findById(Long id);

}
