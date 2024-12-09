package com.demo.poc;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.products.ProductCsvRepository;
import com.demo.poc.products.ProductEntity;

public class ProductApplication {

  public static void main(String[] args) {
//    CrudRepository<ProductEntity> productRepository = new ProductListRepository();
    CrudRepository<ProductEntity> productRepository = new ProductCsvRepository();

    System.out.println(productRepository.findById(1L));
    System.out.println(productRepository.findAll());
  }
}
