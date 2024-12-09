package com.demo.poc.commons.repository.csv;

import com.demo.poc.commons.repository.Entity;
import java.lang.reflect.Field;
import org.apache.commons.csv.CSVRecord;

public class CsvReflectionMapper {

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
