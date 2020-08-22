package com.example.consumer.service;

import com.example.consumer.model.Picture;
import com.example.consumer.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PictureServiceImpl implements PictureService {

  @Value("${resource.pictures}?id={id}")
  private String resource;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public Picture findById(Integer id) {
    System.out.println(resource);
    return restTemplate.getForObject(resource, Picture.class, id.toString());
  }
}
