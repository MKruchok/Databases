package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.PermissionDao;
import com.mkruchok.model.entity.Permission;


public final class PermissionController extends AbstractControllerImpl<Permission> {
  private final PermissionDao permissionDao = new PermissionDao();

  @Override
  public AbstractDaoImpl<Permission> getDao() {
    return permissionDao;
  }
}
