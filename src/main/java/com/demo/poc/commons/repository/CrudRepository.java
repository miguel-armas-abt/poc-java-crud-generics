package com.demo.poc.commons.repository;

import java.util.List;

public interface CrudRepository<T extends Entity> {

    List<T> findAll();

    T findById(Long id);
}
