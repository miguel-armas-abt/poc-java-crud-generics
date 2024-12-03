package com.demo.poc.products;

import com.demo.poc.commons.repository.Entity;
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
