package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.UserDao;
import com.mkruchok.model.entity.User;

public final class UserController extends AbstractControllerImpl<User> {
  public final UserDao userDao = new UserDao();

  @Override
  public AbstractDaoImpl<User> getDao() {
    return userDao;
  }
}