package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.entity.User;

public final class UserDao extends AbstractDaoImpl<User> {
  public UserDao() {
    super(User.class);
  }
}
