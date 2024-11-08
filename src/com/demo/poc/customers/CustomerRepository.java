package com.demo.poc.customers;

import com.demo.poc.commons.CrudRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerRepository extends CrudRepository<CustomerEntity> {

  private static final CustomerEntity[] CUSTOMERS = {
    new CustomerEntity(1L, "Mark Zuckerberg", "76543210"),
    new CustomerEntity(2L, "Elon Musk", "76543211"),
    new CustomerEntity(3L, "Freddy Vega", "76543212")
  };

  public CustomerRepository() {
    super(new ArrayList<>(Arrays.asList(CUSTOMERS)));
  }
}
