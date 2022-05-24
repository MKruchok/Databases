package com.mkruchok.controller;

import com.mkruchok.dto.RexDto;
import com.mkruchok.entity.Rex;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.RexMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.RexService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/rexes")
@AllArgsConstructor
@RestController
public class RexController extends AbstractController<Rex, RexDto, Integer> {
  private final RexService rexService;
  private final RexMapper rexMapper;

  @Override
  protected AbstractService<Rex, Integer> getService() {
    return rexService;
  }

  @Override
  protected AbstractMapper<Rex, RexDto> getMapper() {
    return rexMapper;
  }
}
