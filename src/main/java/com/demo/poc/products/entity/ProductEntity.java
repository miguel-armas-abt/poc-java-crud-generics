package com.demo.poc.products.entity;

import com.demo.poc.commons.Entity;
import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends Entity {

  private String name;
  private double price;
}
