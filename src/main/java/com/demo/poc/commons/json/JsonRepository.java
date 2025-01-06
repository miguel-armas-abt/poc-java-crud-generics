package com.demo.poc.commons.json;

import com.demo.poc.commons.CrudRepository;
import com.demo.poc.commons.Entity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonRepository<T extends Entity> implements CrudRepository<T> {

  private final String filePath;
  private final TypeReference<List<T>> typeReference;

  @Override
  public List<T> findAll() {
    try {
      InputStream inputStream = JsonRepository.class.getClassLoader().getResourceAsStream(filePath);
      return new ObjectMapper().readValue(inputStream, typeReference);
    } catch (IOException ioException) {
      throw new RuntimeException("error reading json file: " + ioException.getMessage(), ioException);
    }
  }
}
