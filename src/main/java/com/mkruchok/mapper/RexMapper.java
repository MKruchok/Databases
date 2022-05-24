package com.mkruchok.mapper;

import com.mkruchok.dto.RexDto;
import com.mkruchok.entity.Rex;
import org.springframework.stereotype.Component;

@Component
public class RexMapper extends AbstractMapper<Rex, RexDto> {

  @Override
  public RexDto mapObjectToDto(Rex rex) {
    if (rex == null) {
      return null;
    }
    RexDto.RexBuilder rexDtoBuilder = RexDto.builder()
        .id(rex.getId())
        .name(rex.getName())
        .range(rex.getRange())
        .hubRexModel(rex.getHubRexId().getModel());
    return rexDtoBuilder.build();
  }
}
