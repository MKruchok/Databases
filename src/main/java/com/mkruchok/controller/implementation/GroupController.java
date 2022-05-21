package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.GroupDao;
import com.mkruchok.model.entity.Group;


public final class GroupController extends AbstractControllerImpl<Group> {
  private final GroupDao groupDao = new GroupDao();

  @Override
  public AbstractDaoImpl<Group> getDao() {
    return groupDao;
  }
}
