package com.mkruchok.service;

import com.mkruchok.entity.Notification;
import com.mkruchok.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService extends AbstractService<Notification, Integer> {
  private NotificationRepository notificationRepository;

  @Override
  protected JpaRepository<Notification, Integer> getRepository() {
    return notificationRepository;
  }
}