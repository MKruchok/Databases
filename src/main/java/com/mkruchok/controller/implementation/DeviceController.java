package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.DeviceDAO;
import com.mkruchok.model.entity.Device;

public final class DeviceController extends AbstractControllerImpl<Device> {

    private final DeviceDAO deviceDao = new DeviceDAO();

    @Override
    public AbstractDaoImpl<Device> getDao() {
        return deviceDao;
    }
}
