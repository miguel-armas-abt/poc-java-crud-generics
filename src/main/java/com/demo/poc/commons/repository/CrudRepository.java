package com.demo.poc.commons.repository;

import java.util.List;

public interface CrudRepository<T extends Entity> {

    void add(T element);

    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);
}
