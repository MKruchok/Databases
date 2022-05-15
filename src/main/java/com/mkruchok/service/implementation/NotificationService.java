package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.NotificationDAO;
import com.mkruchok.model.entity.Notification;
import com.mkruchok.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public final class NotificationService implements AbstractService<Notification> {

    private final NotificationDAO dao = new NotificationDAO();

    @Override
    public List<Notification> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Notification findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Notification entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Notification entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
