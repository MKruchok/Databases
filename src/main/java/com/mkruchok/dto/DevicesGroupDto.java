package com.mkruchok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder(builderClassName = "DevicesGroupBuilder")
public class DevicesGroupDto {
  private Integer id;
  private String name;

  private Integer devicesCounter;
}
