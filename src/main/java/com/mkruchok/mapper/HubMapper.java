package com.mkruchok.mapper;

import com.mkruchok.dto.HubDto;
import com.mkruchok.entity.Hub;
import org.springframework.stereotype.Component;

@Component
public class HubMapper extends AbstractMapper<Hub, HubDto> {

  @Override
  public HubDto mapObjectToDto(Hub hub) {
    if (hub == null) {
      return null;
    }
    HubDto.HubBuilder hubDtoBuilder = HubDto.builder()
        .id(hub.getId())
        .model(hub.getModel())
        .status(hub.getStatus())
        .serviceLifeEndTime(hub.getServiceLifeEndTime())
        .warrantyEndTime(hub.getWarrantyEndTime())
        .usersMax(hub.getUsersMax())
        .roomsMax(hub.getRoomsMax())
        .devicesMax(hub.getDevicesMax())
        .sirensMax(hub.getSirensMax())
        .onBattery(hub.getOnBattery())
        .groupsCounter(hub.getGroups().size())
        .rexesCounter(hub.getRexes().size())
        .notificationsCounter(hub.getNotifications().size())
        .devicesCounter(hub.getDevices().size())
        .hubHasUsersCounter(hub.getHubHasUsers().size());
    return hubDtoBuilder.build();
  }
}
