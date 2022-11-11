package com.mkruchok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "SensorBuilder")
public class SensorDto {
  private Integer id;
  private String name;
  private Float value;
  private String coordinates;
  private Timestamp timeCreated;
}
