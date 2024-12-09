package com.demo.poc;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.customers.CustomerCsvRepository;
import com.demo.poc.customers.CustomerEntity;

public class CustomerApplication {

  public static void main(String[] args) {
//    CrudRepository<CustomerEntity> customerRepository = new CustomerListRepository();
    CrudRepository<CustomerEntity> customerRepository = new CustomerCsvRepository();

    System.out.println(customerRepository.findById(1L));
    System.out.println(customerRepository.findAll());

  }
}
