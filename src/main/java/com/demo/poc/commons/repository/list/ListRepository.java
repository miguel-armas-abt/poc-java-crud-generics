package com.demo.poc.commons.repository.list;

import com.demo.poc.commons.repository.CrudRepository;
import com.demo.poc.commons.repository.Entity;
import java.util.ArrayList;
import java.util.List;

public class ListRepository<T extends Entity> implements CrudRepository<T> {

  private List<T> elements;

  public ListRepository(List<T> initialElements) {
    elements = new ArrayList<>(initialElements);
  }

  @Override
  public void add(T element) {
    this.elements.add(element);
  }

  @Override
  public List<T> findAll() {
    return this.elements;
  }

  @Override
  public T findById(Long id) {
    if(id == null)
      throw new IllegalArgumentException("Id must not be null");

    T selected = null;
    for (T element: this.elements) {
      if(id.equals(element.getId())) {
        selected = element;
        break;
      }
    }

    if (selected == null) {
      throw new IllegalArgumentException("Element with id '" + id + "' not found");
    }

    return selected;
  }

  @Override
  public void deleteById(Long id) {
    T searchedElement = this.findById(id);

     List<T> modifiedList = new ArrayList<>();

     for (T element: this.elements) {
       if(!id.equals(searchedElement.getId()))
         modifiedList.add(element);
     }

     this.elements = modifiedList;
  }
}