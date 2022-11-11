package com.mkruchok.controller;

import com.mkruchok.dto.SensorDto;
import com.mkruchok.dto.UserDto;
import com.mkruchok.entity.Sensor;
import com.mkruchok.entity.User;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.SensorMapper;
import com.mkruchok.mapper.UserMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.SensorService;
import com.mkruchok.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/sensor")
@AllArgsConstructor
@RestController
public class SensorController extends AbstractController<Sensor, SensorDto, Integer> {
  private final SensorService sensorService;
  private final SensorMapper sensorMapper;

  @Override
  protected AbstractService<Sensor, Integer> getService() {
    return sensorService;
  }

  @Override
  protected AbstractMapper<Sensor, SensorDto> getMapper() {
    return sensorMapper;
  }
}
