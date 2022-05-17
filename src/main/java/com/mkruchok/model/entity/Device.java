package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@SuppressFBWarnings
@Getter
@Setter
public final class Device {
    private Integer id;
    private String model;
    private String status;
    private Timestamp serviceLifeEndTime;
    private Timestamp warrantyEndTime;
    private Integer onBattery;
    private Integer hubId;

    public Device(Integer id, String model, String status, Timestamp serviceLifeEndTime,
                  Timestamp warrantyEndTime, Integer onBattery, Integer hubId) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.serviceLifeEndTime = serviceLifeEndTime;
        this.warrantyEndTime = warrantyEndTime;
        this.onBattery = onBattery;
        this.hubId = hubId;
    }

    public Device(String model, String status, Timestamp serviceLifeEndTime, Timestamp warrantyEndTime,
                  Integer onBattery, Integer hubId) {
        this.model = model;
        this.status = status;
        this.serviceLifeEndTime = serviceLifeEndTime;
        this.warrantyEndTime = warrantyEndTime;
        this.onBattery = onBattery;
        this.hubId = hubId;
    }


    @Override
    public String toString() {
        return "\n\nDevice: id: " + id + ", model: " + model + ", status: " + status + ", service_life_end_time: " +
                serviceLifeEndTime + ", warranty_end_time: " + warrantyEndTime + ", on_battery: "
                + onBattery + ", hub_id: " + hubId;
    }
}
