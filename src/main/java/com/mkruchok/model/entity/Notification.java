package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@SuppressFBWarnings
@Getter
@Setter
public final class Notification {
    private Integer id;
    private Timestamp timestamp;
    private String type;
    private Integer deviceId;
    private Integer hubId;

    public Notification(Integer id, Timestamp timestamp, String type, Integer deviceId, Integer hubId) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.deviceId = deviceId;
        this.hubId = hubId;
    }

    public Notification(Timestamp timestamp, String type, Integer deviceId, Integer hubId) {
        this.timestamp = timestamp;
        this.type = type;
        this.deviceId = deviceId;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nNotification: id: " + id + ", timestamp: " + timestamp + ", type: " + type + ", device_id: " +
                deviceId + ", hub_id: " + hubId;
    }
}
