package com.demo.poc.commons;

import java.util.ArrayList;
import java.util.List;

public class CrudRepository<T extends Entity> {

  private List<T> elements;

  public CrudRepository(List<T> initialElements) {
    elements = new ArrayList<>(initialElements);
  }

  public void add(T element) {
    this.elements.add(element);
  }

  public List<T> findAll() {
    return this.elements;
  }

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
