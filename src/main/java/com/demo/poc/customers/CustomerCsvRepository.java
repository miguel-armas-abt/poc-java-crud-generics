package com.demo.poc.customers;

import com.demo.poc.commons.repository.csv.CsvRepository;

public class CustomerCsvRepository extends CsvRepository<CustomerEntity> {

    private static final String FILE_PATH = "/database/customers.csv";

    public CustomerCsvRepository() {
        super(FILE_PATH, CustomerEntity.class);
    }
}
