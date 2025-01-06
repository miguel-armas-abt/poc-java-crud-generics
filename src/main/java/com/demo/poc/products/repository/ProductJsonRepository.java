package com.demo.poc.products.repository;

import com.demo.poc.commons.json.JsonRepository;
import com.demo.poc.products.entity.ProductEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class ProductJsonRepository extends JsonRepository<ProductEntity> {

  private static final String FILE_PATH = "database/products.json";
  private static final TypeReference<List<ProductEntity>> typeReference = new TypeReference<>() {};

  public ProductJsonRepository() {
    super(FILE_PATH, typeReference);
  }
}
