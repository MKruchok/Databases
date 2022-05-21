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
public final class Notification {
  private Integer id;
  private Timestamp timestamp;
  private String notificationType;
  private Integer deviceId;
  private Integer hubId;


  @Override
  public String toString() {
    return "\n\nNotification: id: " + id + ", timestamp: " + timestamp + ", type: "
        + notificationType + ", device_id: " + deviceId + ", hub_id: " + hubId;
  }
}
