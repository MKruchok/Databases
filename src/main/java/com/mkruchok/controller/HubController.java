package com.mkruchok.controller;

import com.mkruchok.dto.HubDto;
import com.mkruchok.entity.Hub;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.HubMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.HubService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/hubs")
@AllArgsConstructor
@RestController
public class HubController extends AbstractController<Hub, HubDto, Integer> {
  private final HubService hubService;
  private final HubMapper hubMapper;

  @Override
  protected AbstractService<Hub, Integer> getService() {
    return hubService;
  }

  @Override
  protected AbstractMapper<Hub, HubDto> getMapper() {
    return hubMapper;
  }
}
