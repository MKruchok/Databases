package com.mkruchok.controller;

import com.mkruchok.dto.NotificationDto;
import com.mkruchok.entity.Notification;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.NotificationMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/notification")
@AllArgsConstructor
@RestController
public class NotificationController
    extends AbstractController<Notification, NotificationDto, Integer> {
  private final NotificationService notificationService;
  private final NotificationMapper notificationMapper;

  @Override
  protected AbstractService<Notification, Integer> getService() {
    return notificationService;
  }

  @Override
  protected AbstractMapper<Notification, NotificationDto> getMapper() {
    return notificationMapper;
  }
}
