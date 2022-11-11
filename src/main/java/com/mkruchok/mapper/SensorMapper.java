package com.mkruchok.mapper;

import com.mkruchok.dto.SensorDto;
import com.mkruchok.entity.Sensor;

import org.springframework.stereotype.Component;

@Component
public class SensorMapper extends AbstractMapper<Sensor, SensorDto> {

  @Override
  public SensorDto mapObjectToDto(Sensor sensor) {
    if (sensor == null) {
      return null;
    }
    SensorDto.SensorBuilder sensorDtoBuilder = SensorDto.builder()
        .id(sensor.getId())
        .name(sensor.getName())
        .value(sensor.getValue())
        .coordinates(sensor.getCoordinates())
        .timeCreated(sensor.getTimeCreated());
    return sensorDtoBuilder.build();
  }
}
