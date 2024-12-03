package com.demo.poc.commons.repository.csv;

import com.demo.poc.commons.repository.Entity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVRecord;

public class CsvReflectionMapper {

    private static final String EMPTY = "";

    public static <T extends Entity> List<String> getRecordValues(Class<T> entityType, T element, List<String> headers) {
        try {
            List<String> recordValues = new ArrayList<>();
            for (String header : headers) {
                Field field = getFieldByName(entityType, header);
                if (field != null) {
                    field.setAccessible(true);
                    Object value = field.get(element);
                    recordValues.add(value != null ? value.toString() : EMPTY);
                } else {
                    recordValues.add(EMPTY);
                }
            }

            return recordValues;
        } catch (Exception exception) {
            throw new IllegalArgumentException("Error generating record: " + exception.getMessage(), exception);
        }
    }

    private static Field getFieldByName(Class<?> entityType, String fieldName) {
        Class<?> currentClass = entityType;
        while (currentClass != null) {
            for (Field field : currentClass.getDeclaredFields()) {
                String fieldNameInSnakeCase = camelToUpperSnake(field.getName());
                if (fieldNameInSnakeCase.equalsIgnoreCase(fieldName))
                    return field;
            }
            currentClass = currentClass.getSuperclass();
        }
        return null;
    }

    public static <T extends Entity> T assignFieldsAndGet(Class<T> entityType, CSVRecord record) {
        try {
            T entity = entityType.getDeclaredConstructor().newInstance();
            Class<?> currentClass = entityType;
            while (currentClass != null) {
                assignFields(currentClass.getDeclaredFields(), record, entity);
                currentClass = currentClass.getSuperclass();
            }
            return entity;
        } catch (Exception exception) {
            throw new IllegalArgumentException("Unable to assign field: " + exception.getMessage());
        }
    }

    private static <T extends Entity> void assignFields(Field[] fields, CSVRecord record, T element) throws IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldNameInSnakeCase = camelToUpperSnake(field.getName());
            field.set(element, parseValue(field.getType(), record.get(fieldNameInSnakeCase)));
        }
    }

    private static String camelToUpperSnake(String camelCase) {
        if (camelCase == null || camelCase.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        return camelCase
            .replaceAll("([a-z])([A-Z])", "$1_$2")
            .toUpperCase();
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type == Long.class)
            return Long.parseLong(value);

        if (type == Integer.class)
            return Integer.parseInt(value);

        if (type == Double.class)
            return Double.parseDouble(value);

        if (type == Boolean.class)
            return Boolean.parseBoolean(value);

        return value;
    }
}
