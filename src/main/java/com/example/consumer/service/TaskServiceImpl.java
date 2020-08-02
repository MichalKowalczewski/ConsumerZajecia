package com.example.consumer.service;

import com.example.consumer.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskServiceImpl implements TaskService {

    @Value("${resource.tasks}")
    private String resource;

    @Value("${resource.tasks}/{id}")
    private String idResource;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Task findById(Long id) {
        return restTemplate.getForObject(idResource, Task.class, id.toString());
    }
}
