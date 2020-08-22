package com.example.consumer.model;

public class Task {

  private Long id;
  private String description;
  private boolean completed;
  private Integer completionPercentage;
  private User user;

  public Task() { }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public Integer getCompletionPercentage() {
    return completionPercentage;
  }

  public void setCompletionPercentage(Integer completionPercentage) {
    this.completionPercentage = completionPercentage;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Task{" +
      "id=" + id +
      ", description='" + description + '\'' +
      ", completed=" + completed +
      ", completionPercentage=" + completionPercentage +
      ", user=" + user +
      '}';
  }
}
