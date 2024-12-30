package com.demo.poc.commons;

import java.util.List;

public interface CrudRepository<T extends Entity> {

    List<T> findAll();

    T findById(Long id);
}
