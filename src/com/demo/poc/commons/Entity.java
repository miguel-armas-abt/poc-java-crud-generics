package com.demo.poc.commons;

public class Entity {

  public Entity(Long id) {
    this.id = id;
  }

  protected Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
