package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.HubGroup;
import com.mkruchok.service.implementation.GroupService;

import java.sql.SQLException;
import java.util.List;

public final class GroupController implements AbstractController<HubGroup> {

    private final GroupService service = new GroupService();

    @Override
    public List<HubGroup> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public HubGroup findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(HubGroup entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, HubGroup entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
