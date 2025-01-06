package com.demo.poc.commons.list;

import com.demo.poc.commons.CrudRepository;
import com.demo.poc.commons.Entity;
import java.util.ArrayList;
import java.util.List;

public class ListRepository<T extends Entity> implements CrudRepository<T> {

  private final List<T> entities;

  public ListRepository(List<T> initialElements) {
    entities = new ArrayList<>(initialElements);
  }

  @Override
  public List<T> findAll() {
    return this.entities;
  }
}