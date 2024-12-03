package com.demo.poc.products;

import com.demo.poc.commons.repository.list.ListRepository;
import java.util.Arrays;
import java.util.List;

public class ProductListRepository extends ListRepository<ProductEntity> {

  public ProductListRepository() {
    super(init());
  }

  private static List<ProductEntity> init() {
    ProductEntity firstProduct = new ProductEntity();
    firstProduct.setId(1L);
    firstProduct.setName("Laptop Lenovo Ideapad 320");
    firstProduct.setPrice(1999.99);

    ProductEntity secondProduct = new ProductEntity();
    secondProduct.setId(2L);
    secondProduct.setName("Iphone 13S Pro Max");
    secondProduct.setPrice(5500.00);

    ProductEntity thirdProduct = new ProductEntity();
    thirdProduct.setId(3L);
    thirdProduct.setName("Mouse Ryzen");
    thirdProduct.setPrice(249.99);

    return Arrays.asList(firstProduct, secondProduct, thirdProduct);
  }
}
