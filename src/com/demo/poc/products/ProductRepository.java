package com.demo.poc.products;

import com.demo.poc.commons.CrudRepository;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductRepository extends CrudRepository<ProductEntity> {

  private static final ProductEntity[] CUSTOMERS = {
    new ProductEntity(1L, "Ipad", 1649.99),
    new ProductEntity(2L, "Mac", 3499.99),
    new ProductEntity(3L, "WebCam", 300.00)
  };

  public ProductRepository() {
    super(new ArrayList<>(Arrays.asList(CUSTOMERS)));
  }
}
