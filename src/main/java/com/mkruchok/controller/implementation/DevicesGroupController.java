package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.DevicesGroupDao;
import com.mkruchok.model.entity.DevicesGroup;


public final class DevicesGroupController extends AbstractControllerImpl<DevicesGroup> {
  private final DevicesGroupDao devicesGroupDao = new DevicesGroupDao();

  @Override
  public AbstractDaoImpl<DevicesGroup> getDao() {
    return devicesGroupDao;
  }
}
