package com.demo.poc;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.customers.CustomerCsvRepository;
import com.demo.poc.customers.CustomerEntity;
import com.demo.poc.customers.CustomerListRepository;

public class CustomerApplication {

  public static void main(String[] args) {
//    CrudRepository<CustomerEntity> customerRepository = new CustomerListRepository();
    CrudRepository<CustomerEntity> customerRepository = new CustomerCsvRepository();

    System.out.println(customerRepository.findById(1L));

    CustomerEntity customer = new CustomerEntity("Linus Torvalds", "76543213");
    customerRepository.add(customer);

    System.out.println(customerRepository.findAll());

    customerRepository.deleteById(3L);
  }
}
