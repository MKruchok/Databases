package com.mkruchok.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "DeviceBuilder")
public class DeviceDto {
  private Integer id;
  private String model;
  private String status;
  private Timestamp serviceLifeEndTime;
  private Timestamp warrantyEndTime;
  private Integer onBattery;

  private String hubModel;
  private Integer notificationsCounter;
  private String devicesGroupName;

}
