package com.example.consumer.service;

import com.example.consumer.model.Task;
import com.example.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  @Value("${resource.users}")
  private String resource;

  @Value("${resource.users}/{id}")
  private String idResource;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<User> findAll() {
    return Arrays.stream(Objects.requireNonNull(
      restTemplate.getForObject(resource, User[].class))).collect(Collectors.toList());
  }

  @Override
  public User findById(Long id) {
    return restTemplate.getForObject(idResource, User.class, id.toString());
  }
}
