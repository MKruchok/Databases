package com.mkruchok.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Collection;

@Table(name = "device")
@SuppressFBWarnings
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "model", length = 45)
    private String model;
    @Column(name = "device_status", length = 45)
    private String status;
    @CreationTimestamp
    @Column(name = "service_life_end_time")
    private Timestamp serviceLifeEndTime;
    @CreationTimestamp
    @Column(name = "warranty_end_time")
    private Timestamp warrantyEndTime;
    @Column(name = "on_battery", length = 1)
    private Integer onBattery;


    @ManyToOne
    @JoinColumn(name = "hub_id", referencedColumnName = "id")
    private Hub hubId;

    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "deviceId", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Notification> notifications;

    public Device(String model, String status, Timestamp serviceLifeEndTime,
                  Timestamp warrantyEndTime, Integer onBattery, Hub hubId) {
        this.model = model;
        this.status = status;
        this.serviceLifeEndTime = serviceLifeEndTime;
        this.warrantyEndTime = warrantyEndTime;
        this.onBattery = onBattery;
        this.hubId = hubId;
    }
}
