package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.PermissionDAO;
import com.mkruchok.model.entity.Permission;
import com.mkruchok.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public final class PermissionService implements AbstractService<Permission> {

    private final PermissionDAO dao = new PermissionDAO();

    @Override
    public List<Permission> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Permission findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Permission entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Permission entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
