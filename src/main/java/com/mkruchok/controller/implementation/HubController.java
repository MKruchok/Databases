package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Hub;
import com.mkruchok.service.implementation.HubService;

import java.sql.SQLException;
import java.util.List;

public final class HubController implements AbstractController<Hub> {

    private final HubService service = new HubService();

    @Override
    public List<Hub> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Hub findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Hub entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Hub entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
