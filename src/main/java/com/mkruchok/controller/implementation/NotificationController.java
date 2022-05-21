package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.NotificationDao;
import com.mkruchok.model.entity.Notification;


public final class NotificationController extends AbstractControllerImpl<Notification> {
  private final NotificationDao notificationDao = new NotificationDao();

  @Override
  public AbstractDaoImpl<Notification> getDao() {
    return notificationDao;
  }

}
