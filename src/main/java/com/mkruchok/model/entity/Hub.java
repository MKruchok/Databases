package com.mkruchok.model.entity;

import java.sql.Timestamp;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Nullable
public final class Hub {
  private Integer id;
  private String model;
  private String hubStatus;
  private Timestamp serviceLifeEndTime;
  private Timestamp warrantyEndTime;
  private Integer usersMax;
  private Integer roomsMax;
  private Integer devicesMax;
  private Integer sirensMax;
  private Integer onBattery;


  @Override
  public String toString() {
    return "\n\nHub: id: " + id + ", model: " + model + ", status: " + hubStatus
        + ", service_life_end_time: " + serviceLifeEndTime + ", warranty_end_time: "
        + warrantyEndTime + ", users_max: " + usersMax + ", rooms_max: " + roomsMax
        + ", devices_max: " + devicesMax + ", sirens_max: " + sirensMax + ", on_battery: "
        + onBattery + "]";
  }
}
