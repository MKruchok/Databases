package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.UsersGroupDao;
import com.mkruchok.model.entity.UsersGroup;


public final class UsersGroupController extends AbstractControllerImpl<UsersGroup> {
  private final UsersGroupDao usersGroupDao = new UsersGroupDao();

  @Override
  public AbstractDaoImpl<UsersGroup> getDao() {
    return usersGroupDao;
  }
}
