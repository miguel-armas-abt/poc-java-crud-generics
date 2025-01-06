package com.demo.poc;

import com.demo.poc.commons.CrudRepository;
import com.demo.poc.products.entity.ProductEntity;
import com.demo.poc.products.repository.ProductCsvRepository;
import com.demo.poc.products.repository.ProductJsonRepository;
import com.demo.poc.products.repository.ProductListRepository;

public class Application {

  public static void main(String[] args) {
    CrudRepository<ProductEntity> productRepository;
//    productRepository = new ProductListRepository();
//    productRepository = new ProductCsvRepository();
    productRepository = new ProductJsonRepository();

    System.out.println(productRepository.findById(1L));
    System.out.println(productRepository.findAll());
  }
}
