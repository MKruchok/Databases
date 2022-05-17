package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.DeviceDAO;
import com.mkruchok.model.entity.Device;
import com.mkruchok.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public final class DeviceService implements AbstractService<Device> {

    private final DeviceDAO dao = new DeviceDAO();

    @Override
    public List<Device> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Device findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Device entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Device entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
