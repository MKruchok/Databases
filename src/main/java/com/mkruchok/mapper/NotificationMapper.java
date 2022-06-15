package com.mkruchok.mapper;

import com.mkruchok.dto.NotificationDto;
import com.mkruchok.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper extends AbstractMapper<Notification, NotificationDto> {

  @Override
  public NotificationDto mapObjectToDto(Notification notification) {
    if (notification == null) {
      return null;
    }
    NotificationDto.NotificationBuilder notificationDtoBuilder = NotificationDto.builder()
        .id(notification.getId())
        .timestamp(notification.getTimestamp())
        .type(notification.getType())
        .deviceModel(
            notification.getDeviceId() == null ? null : notification.getDeviceId().getModel())
        .hubModel(notification.getHubNotificationId() == null ? null :
            notification.getHubNotificationId().getModel());
    return notificationDtoBuilder.build();
  }
}
