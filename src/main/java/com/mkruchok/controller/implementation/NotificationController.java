package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Notification;
import com.mkruchok.service.implementation.NotificationService;

import java.sql.SQLException;
import java.util.List;

public final class NotificationController implements AbstractController<Notification> {

    private final NotificationService service = new NotificationService();

    @Override
    public List<Notification> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Notification findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Notification entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public void update(Integer id, Notification entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
