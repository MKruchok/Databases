package com.mkruchok.controller;

import com.mkruchok.dto.DevicesGroupDto;
import com.mkruchok.entity.DevicesGroup;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.DevicesGroupMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.DevicesGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/devices_group")
@AllArgsConstructor
@RestController
public class DevicesGroupController
    extends AbstractController<DevicesGroup, DevicesGroupDto, Integer> {
  private final DevicesGroupService devicesGroupService;
  private final DevicesGroupMapper devicesGroupMapper;

  @Override
  protected AbstractService<DevicesGroup, Integer> getService() {
    return devicesGroupService;
  }

  @Override
  protected AbstractMapper<DevicesGroup, DevicesGroupDto> getMapper() {
    return devicesGroupMapper;
  }
}
