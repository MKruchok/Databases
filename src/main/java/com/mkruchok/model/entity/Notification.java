package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@SuppressFBWarnings
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

    public Notification(Timestamp timestamp, String notificationType, Integer deviceId, Integer hubId) {
        this.timestamp = timestamp;
        this.notificationType = notificationType;
        this.deviceId = deviceId;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nNotification: id: " + id + ", timestamp: " + timestamp + ", type: " + notificationType + ", device_id: " +
                deviceId + ", hub_id: " + hubId;
    }
}
