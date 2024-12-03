package com.demo.poc;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.products.ProductCsvRepository;
import com.demo.poc.products.ProductEntity;
import com.demo.poc.products.ProductListRepository;

public class ProductApplication {

  public static void main(String[] args) {
//    CrudRepository<ProductEntity> productRepository = new ProductListRepository();
    CrudRepository<ProductEntity> productRepository = new ProductCsvRepository();

    System.out.println(productRepository.findById(1L));

    ProductEntity product = new ProductEntity("Cámara web Logitech", 230.00);
    productRepository.add(product);

    System.out.println(productRepository.findAll());

    productRepository.deleteById(3L);
  }
}
