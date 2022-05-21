package com.mkruchok.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController<E> {

  List<E> findAll() throws SQLException;

  default E findById(Integer id) {
    return null;
  }

  default void create(E entity) {
  }

  default void update(Integer id, E entity) {
  }

  default void delete(Integer id) {
  }
}
