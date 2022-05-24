package com.mkruchok.mapper;

import com.mkruchok.dto.DeviceDto;
import com.mkruchok.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper extends AbstractMapper<Device, DeviceDto> {

  @Override
  public DeviceDto mapObjectToDto(Device device) {
    if (device == null) {
      return null;
    }
    DeviceDto.DeviceBuilder deviceDtoBuilder = DeviceDto.builder()
        .id(device.getId())
        .model(device.getModel())
        .status(device.getStatus())
        .serviceLifeEndTime(device.getServiceLifeEndTime())
        .warrantyEndTime(device.getWarrantyEndTime())
        .onBattery(device.getOnBattery())
        .hubModel(device.getHubId().getModel())
        .notificationsCounter(device.getNotifications().size());

    return deviceDtoBuilder.build();
  }
}
