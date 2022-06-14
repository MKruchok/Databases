package com.mkruchok.model.entity;

import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Table(name = "device")

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
  @Column(name = "model",
      length = 45)
  private String model;
  @Column(name = "device_status",
      length = 45)
  private String deviceStatus;
  @CreationTimestamp
  @Column(name = "service_life_end_time")
  private Timestamp serviceLifeEndTime;
  @CreationTimestamp
  @Column(name = "warranty_end_time")
  private Timestamp warrantyEndTime;
  @Column(name = "on_battery",
      length = 1)
  private Integer onBattery;


  @ManyToOne
  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubId;

  @ManyToOne
  @JoinColumn(name = "devices_group_id",
      referencedColumnName = "id")
  private DevicesGroup devicesGroupId;

  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "deviceId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Notification> notifications;

  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "deviceId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Permission> permissions;

  public Device(String model,
      String deviceStatus,
      Timestamp serviceLifeEndTime,
      Timestamp warrantyEndTime,
      Integer onBattery,
      Hub hubId,
      DevicesGroup devicesGroupId) {
    this.model = model;
    this.deviceStatus = deviceStatus;
    this.serviceLifeEndTime = serviceLifeEndTime;
    this.warrantyEndTime = warrantyEndTime;
    this.onBattery = onBattery;
    this.hubId = hubId;
    this.devicesGroupId = devicesGroupId;
  }
}
