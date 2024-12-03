package com.demo.poc.products;

import com.demo.poc.commons.repository.csv.CsvRepository;

public class ProductCsvRepository extends CsvRepository<ProductEntity> {

    private static final String FILE_PATH = "/database/products.csv";

    public ProductCsvRepository() {
        super(FILE_PATH, ProductEntity.class);
    }
}
