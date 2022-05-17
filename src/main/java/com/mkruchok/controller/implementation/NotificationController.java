package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.NotificationDAO;
import com.mkruchok.model.entity.Notification;


public final class NotificationController extends AbstractControllerImpl<Notification> {
    private final NotificationDAO notificationDao = new NotificationDAO();

    @Override
    public AbstractDaoImpl<Notification> getDao() {
        return notificationDao;
    }

}
