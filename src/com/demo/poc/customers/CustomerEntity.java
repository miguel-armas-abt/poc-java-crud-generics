package com.demo.poc.customers;

import com.demo.poc.commons.Entity;

public class CustomerEntity extends Entity {

  private String name;
  private String dni;

  public CustomerEntity(Long id, String name, String dni) {
    super(id);
    this.name = name;
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  @Override
  public String toString() {
    return "CustomerEntity{" +
        "name='" + name + '\'' +
        ", dni='" + dni + '\'' +
        ", id=" + id +
        '}';
  }
}
