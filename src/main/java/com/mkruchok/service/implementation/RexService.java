package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.RexDAO;
import com.mkruchok.model.entity.Rex;
import com.mkruchok.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public final class RexService implements AbstractService<Rex> {

    private final RexDAO dao = new RexDAO();

    @Override
    public List<Rex> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Rex findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Rex entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Rex entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
