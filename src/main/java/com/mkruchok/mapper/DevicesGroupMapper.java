package com.mkruchok.mapper;

import com.mkruchok.dto.DevicesGroupDto;
import com.mkruchok.entity.DevicesGroup;
import org.springframework.stereotype.Component;

@Component
public class DevicesGroupMapper extends AbstractMapper<DevicesGroup, DevicesGroupDto> {

  @Override
  public DevicesGroupDto mapObjectToDto(DevicesGroup devicesGroup) {
    if (devicesGroup == null) {
      return null;
    }
    DevicesGroupDto.DevicesGroupBuilder devicesGroupDtoBuilder = DevicesGroupDto.builder()
        .id(devicesGroup.getId())
        .name(devicesGroup.getName())
        .devicesCounter(devicesGroup.getDevices().size());
    return devicesGroupDtoBuilder.build();
  }
}
