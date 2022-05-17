package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.entity.User;

public final class UserDAO extends AbstractDaoImpl<User> {
    public UserDAO() {
        super(User.class);
    }
}
