package com.mkruchok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "RexBuilder")
public class RexDto {
  private Integer id;
  private String name;
  private String range;

  private String rexHubModel;
}
