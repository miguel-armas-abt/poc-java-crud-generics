package com.demo.poc.commons.repository.list;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.commons.repository.Entity;
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

  @Override
  public T findById(Long id) {
    if(id == null)
      throw new IllegalArgumentException("Id must not be null");

    for (T entity: this.findAll()) {
      if(id.equals(entity.getId()))
        return entity;
    }
    throw new IllegalArgumentException("No such element with id " + id);
  }
}