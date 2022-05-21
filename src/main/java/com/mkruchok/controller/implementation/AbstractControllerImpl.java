package com.mkruchok.controller.implementation;


import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import java.util.List;

public abstract class AbstractControllerImpl<E> implements AbstractController<E> {
  public abstract AbstractDaoImpl<E> getDao();

  @Override
  public final List<E> findAll() {
    return (List<E>) getDao().findAll();
  }

  @Override
  public final E findById(final Integer id) {
    return getDao().findById(id);
  }

  @Override
  public final void create(final E object) {
    getDao().create(object);
  }

  @Override
  public final void update(final Integer id, E object) {
    getDao().update(id, object);
  }

  @Override
  public final void delete(final Integer id) {
    getDao().delete(id);
  }

}