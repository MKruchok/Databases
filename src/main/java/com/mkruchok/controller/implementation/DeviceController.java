package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.DeviceDao;
import com.mkruchok.model.entity.Device;

public final class DeviceController extends AbstractControllerImpl<Device> {

  private final DeviceDao deviceDao = new DeviceDao();

  @Override
  public AbstractDaoImpl<Device> getDao() {
    return deviceDao;
  }
}
