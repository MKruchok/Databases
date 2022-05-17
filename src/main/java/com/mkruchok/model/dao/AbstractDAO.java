package com.mkruchok.model.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface AbstractDAO<E> {

    Collection<E> findAll() throws SQLException;

    default void create(E entity) {
    }

    default E findById(Integer id) {
        return null;
    }

    default void update(Integer id, E entity) {
    }

    default void delete(Integer id) {
    }

}
