package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.User;
import com.mkruchok.service.implementation.UserService;

import java.sql.SQLException;
import java.util.List;

public final class UserController implements AbstractController<User> {

    private final UserService service = new UserService();

    @Override
    public List<User> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public User findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(User entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, User entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
