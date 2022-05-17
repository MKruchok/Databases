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
public final class Device {
    private Integer id;
    private String model;
    private String deviceStatus;
    private Timestamp serviceLifeEndTime;
    private Timestamp warrantyEndTime;
    private Integer onBattery;
    private Integer hubId;


    public Device(String model, String deviceStatus, Timestamp serviceLifeEndTime, Timestamp warrantyEndTime, Integer onBattery, Integer hubId) {
        this.model = model;
        this.deviceStatus = deviceStatus;
        this.serviceLifeEndTime = serviceLifeEndTime;
        this.warrantyEndTime = warrantyEndTime;
        this.onBattery = onBattery;
        this.hubId = hubId;
    }

    @Override
    public String toString() {
        return "\n\nDevice: id: " + id + ", model: " + model + ", status: " + deviceStatus + ", service_life_end_time: " +
                serviceLifeEndTime + ", warranty_end_time: " + warrantyEndTime + ", on_battery: "
                + onBattery + ", hub_id: " + hubId;
    }
}
