package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@SuppressFBWarnings
@Getter
@Setter
public final class Hub {
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

    public Hub(Integer id, String model, String status, Timestamp serviceLifeEndTime, Timestamp warrantyEndTime,
               Integer usersMax, Integer roomsMax, Integer devicesMax, Integer sirensMax, Integer onBattery) {
        this.id = id;
        this.model = model;
        this.status = status;
        this.serviceLifeEndTime = new Timestamp(serviceLifeEndTime.getTime());
        this.warrantyEndTime = new Timestamp(warrantyEndTime.getTime());
        this.usersMax = usersMax;
        this.roomsMax = roomsMax;
        this.devicesMax = devicesMax;
        this.sirensMax = sirensMax;
        this.onBattery = onBattery;
    }

    public Hub(String model, String status, Timestamp serviceLifeEndTime, Timestamp warrantyEndTime, Integer usersMax, Integer roomsMax, Integer devicesMax, Integer sirensMax, Integer onBattery) {
        this.model = model;
        this.status = status;
        this.serviceLifeEndTime = new Timestamp(serviceLifeEndTime.getTime());
        this.warrantyEndTime = new Timestamp(warrantyEndTime.getTime());
        this.usersMax = usersMax;
        this.roomsMax = roomsMax;
        this.devicesMax = devicesMax;
        this.sirensMax = sirensMax;
        this.onBattery = onBattery;
    }

    @Override
    public String toString() {
        return "\n\nHub: id: " + id + ", model: " + model + ", status: " + status + ", service_life_end_time: " + serviceLifeEndTime + ", warranty_end_time: " + warrantyEndTime + ", users_max: " + usersMax + ", rooms_max: " + roomsMax + ", devices_max: " + devicesMax + ", sirens_max: " + sirensMax + ", on_battery: " + onBattery + "]";
    }
}
