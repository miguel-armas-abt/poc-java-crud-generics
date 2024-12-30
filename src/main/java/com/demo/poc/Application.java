package com.demo.poc;

import com.demo.poc.commons.CrudRepository;
import com.demo.poc.products.repository.ProductCsvRepository;
import com.demo.poc.products.entity.ProductEntity;

public class Application {

  public static void main(String[] args) {
//    CrudRepository<ProductEntity> productRepository = new ProductListRepository();
    CrudRepository<ProductEntity> productRepository = new ProductCsvRepository();

    System.out.println(productRepository.findById(1L));
    System.out.println(productRepository.findAll());
  }
}
