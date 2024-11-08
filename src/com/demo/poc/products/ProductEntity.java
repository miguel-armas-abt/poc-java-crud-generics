package com.demo.poc.products;

import com.demo.poc.commons.Entity;

public class ProductEntity extends Entity {

  private String name;
  private double price;

  public ProductEntity(Long id, String name, double price) {
    super(id);
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrince() {
    return this.price;
  }

  public void setPrince(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "ProductEntity{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", id=" + id +
        '}';
  }
}
