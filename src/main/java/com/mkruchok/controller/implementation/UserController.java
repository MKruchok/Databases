package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.UserDAO;
import com.mkruchok.model.entity.User;

public final class UserController extends AbstractControllerImpl<User> {
    public final UserDAO userDao = new UserDAO();

    @Override
    public AbstractDaoImpl<User> getDao() {
        return userDao;
    }
}