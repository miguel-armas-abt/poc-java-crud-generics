package com.demo.poc.commons.repository.csv;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.commons.repository.Entity;
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

    @Override
    public T findById(Long id) {
        List<T> allEntities = findAll();
        for (T entity: allEntities) {
            if(entity.getId().equals(id))
                return entity;
        }
        throw new IllegalArgumentException("No such element");
    }
}
