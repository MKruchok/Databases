package com.mkruchok.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T, id> {
  protected abstract JpaRepository<T, id> getRepository();

  public final List<T> findAll() {
    return getRepository().findAll();
  }

  public T getById(id id) {
    return getRepository().getReferenceById(id);
  }

  public final void create(final T object) {
    getRepository().save(object);
  }

  public final T update(final T object) {
    return getRepository().save(object);
  }

  public final void delete(final id id) {
    getRepository().deleteById(id);
  }

}