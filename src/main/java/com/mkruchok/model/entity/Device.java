package com.mkruchok.model.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Device {
  private Integer id;
  private String model;
  private String deviceStatus;
  private Timestamp serviceLifeEndTime;
  private Timestamp warrantyEndTime;
  private Integer onBattery;
  private Integer hubId;


  @Override
  public String toString() {
    return "\n\nDevice: id: " + id + ", model: " + model + ", status: " + deviceStatus
        + ", service_life_end_time: " + serviceLifeEndTime + ", warranty_end_time: "
        + warrantyEndTime + ", on_battery: " + onBattery + ", hub_id: " + hubId;
  }
}
