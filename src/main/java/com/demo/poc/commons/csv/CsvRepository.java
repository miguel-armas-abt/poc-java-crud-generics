package com.demo.poc.commons.csv;

import com.demo.poc.commons.CrudRepository;
import com.demo.poc.commons.Entity;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVRecord;

@RequiredArgsConstructor
public class CsvRepository<T extends Entity> implements CrudRepository<T> {

    private static final char SEPARATOR = ',';
    private final String filePath;
    private final Class<T> entityType;

    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        List<CSVRecord> records = CsvFileReader.getRecords(filePath, SEPARATOR);

        for (CSVRecord record : records) {
            T entity = CsvReflectionMapper.assignFieldsAndGet(entityType, record);
            entities.add(entity);
        }
        return entities;
    }
}
