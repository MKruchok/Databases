package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Device;
import com.mkruchok.service.implementation.DeviceService;

import java.sql.SQLException;
import java.util.List;

public final class DeviceController implements AbstractController<Device> {

    private final DeviceService service = new DeviceService();

    @Override
    public List<Device> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Device findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Device entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Device entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
