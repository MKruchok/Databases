package com.mkruchok.model.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public final class Device {
  private Integer id;
  private String model;
  private String deviceStatus;
  private Timestamp serviceLifeEndTime;
  private Timestamp warrantyEndTime;
  private Integer onBattery;
  private Integer hubId;
  private Integer devicesGroupId;


}
