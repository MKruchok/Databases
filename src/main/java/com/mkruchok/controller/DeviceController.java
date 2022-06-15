package com.mkruchok.controller;

import com.mkruchok.dto.DeviceDto;
import com.mkruchok.entity.Device;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.DeviceMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/device")
@AllArgsConstructor
@RestController
public class DeviceController extends AbstractController<Device, DeviceDto, Integer> {
  private final DeviceService deviceService;
  private final DeviceMapper deviceMapper;

  @Override
  protected AbstractService<Device, Integer> getService() {
    return deviceService;
  }

  @Override
  protected AbstractMapper<Device, DeviceDto> getMapper() {
    return deviceMapper;
  }
}
