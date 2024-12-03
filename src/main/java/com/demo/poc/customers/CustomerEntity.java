package com.demo.poc.customers;

import com.demo.poc.commons.repository.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends Entity {

  private String name;
  private String dni;
}
