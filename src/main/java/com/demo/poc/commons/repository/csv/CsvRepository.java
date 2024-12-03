package com.demo.poc.commons.repository.csv;

import static com.demo.poc.commons.repository.csv.CsvConstant.LINE_BREAK;
import static com.demo.poc.commons.repository.csv.CsvConstant.SEPARATOR;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.commons.repository.Entity;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

@RequiredArgsConstructor
public class CsvRepository<T extends Entity> implements CrudRepository<T> {

    public static final String BASE_FILE_PATH = "src/main/resources";
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

    @Override
    public void add(T element) {
        element.setId(getNextId());
        List<String> recordValues = CsvReflectionMapper.getRecordValues(entityType, element, getHeaders());

        try (
            FileWriter fileWriter = new FileWriter(BASE_FILE_PATH + filePath, true);
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.newFormat(SEPARATOR).withRecordSeparator(LINE_BREAK))) {
            printer.printRecord(recordValues);

        } catch (Exception exception) {
            throw new IllegalArgumentException("Error adding record: " + exception.getMessage(), exception);
        }
    }

    @Override
    public void deleteById(Long id) {
        List<T> entities = findAll();
        boolean wasDeleted = entities.removeIf(entity -> entity.getId().equals(id));

        if (!wasDeleted)
            throw new IllegalArgumentException("Not found element with id: " + id);

        try (
            FileWriter fileWriter = new FileWriter(BASE_FILE_PATH + filePath);
            CSVPrinter printer = new CSVPrinter(fileWriter, CSVFormat.newFormat(SEPARATOR).withRecordSeparator(LINE_BREAK).withHeader(getHeaders().toArray(new String[0])))) {

            for (T element : entities) {
                List<String> recordValues = CsvReflectionMapper.getRecordValues(entityType, element, getHeaders());
                printer.printRecord(recordValues);
            }

        } catch (Exception exception) {
            throw new IllegalArgumentException("Error adding record: " + exception.getMessage(), exception);
        }

    }

    private List<String> getHeaders() {
        return new ArrayList<>(CsvFileReader.getRecords(filePath, SEPARATOR).get(0).toMap().keySet());
    }

    private Long getNextId() {
        List<T> entities = findAll();
        return entities.stream()
            .map(T::getId)
            .filter(Objects::nonNull)
            .max(Long::compareTo)
            .orElse(0L) + 1;
    }
}
