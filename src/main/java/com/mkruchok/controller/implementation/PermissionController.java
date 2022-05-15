package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Permission;
import com.mkruchok.service.implementation.PermissionService;

import java.sql.SQLException;
import java.util.List;

public final class PermissionController implements AbstractController<Permission> {

    private final PermissionService service = new PermissionService();

    @Override
    public List<Permission> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Permission findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Permission entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Permission entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
