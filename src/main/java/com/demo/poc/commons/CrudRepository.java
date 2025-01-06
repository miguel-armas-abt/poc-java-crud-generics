package com.demo.poc.commons;

import java.util.List;

public interface CrudRepository<T extends Entity> {

    List<T> findAll();

    default T findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Id must not be null");

        for (T entity: this.findAll()) {
            if(id.equals(entity.getId()))
                return entity;
        }
        throw new IllegalArgumentException("No such element with id " + id);
    }
}