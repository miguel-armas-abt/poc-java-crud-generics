package com.demo.poc;

import com.demo.poc.customers.CustomerRepository;
import com.demo.poc.products.ProductRepository;

public class Application {

  public static void main(String[] args) {
    CustomerRepository customerRepository = new CustomerRepository();
    System.out.println(customerRepository.findAll());

    ProductRepository productRepository = new ProductRepository();
    System.out.println(productRepository.findAll());
  }
}
