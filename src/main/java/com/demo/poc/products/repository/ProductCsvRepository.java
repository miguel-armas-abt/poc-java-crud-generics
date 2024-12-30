package com.demo.poc.products.repository;

import com.demo.poc.commons.csv.CsvRepository;
import com.demo.poc.products.entity.ProductEntity;

public class ProductCsvRepository extends CsvRepository<ProductEntity> {

    private static final String FILE_PATH = "/database/products.csv";

    public ProductCsvRepository() {
        super(FILE_PATH, ProductEntity.class);
    }
}
