package com.demo.poc.customers;

import com.demo.poc.commons.repository.list.ListRepository;
import java.util.Arrays;
import java.util.List;

public class CustomerListRepository extends ListRepository<CustomerEntity> {

  public CustomerListRepository() {
    super(init());
  }

  private static List<CustomerEntity> init() {
    CustomerEntity firstCustomer = new CustomerEntity();
    firstCustomer.setId(1L);
    firstCustomer.setName("Mark Zuckerberg");
    firstCustomer.setDni("76543210");

    CustomerEntity secondCustomer = new CustomerEntity();
    secondCustomer.setId(2L);
    secondCustomer.setName("Elon Musk");
    secondCustomer.setDni("76543211");

    CustomerEntity thirdCustomer = new CustomerEntity();
    thirdCustomer.setId(3L);
    thirdCustomer.setName("Freddy Vega");
    thirdCustomer.setDni("76543212");

    return Arrays.asList(firstCustomer, secondCustomer, thirdCustomer);
  }
}
