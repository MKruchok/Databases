package com.mkruchok.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "HubBuilder")
public class HubDto {
  private Integer id;
  private String model;
  private String status;
  private Timestamp serviceLifeEndTime;
  private Timestamp warrantyEndTime;
  private Integer usersMax;
  private Integer roomsMax;
  private Integer devicesMax;
  private Integer sirensMax;
  private Integer onBattery;

  private Integer groupsCounter;
  private Integer rexesCounter;
  private Integer notificationsCounter;
  private Integer devicesCounter;
  private Integer hubHasUsersCounter;
}
