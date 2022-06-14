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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

@Table(name = "hub")

@Getter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Hub {
  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany
  @JoinTable(name = "user_has_hub",
      joinColumns = @JoinColumn(name = "hub_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  @ToString.Exclude
  Collection<Hub> hubHasUsers;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "model",
      length = 45)
  private String model;
  @Column(name = "hub_status",
      length = 45)
  private String status;
  @CreationTimestamp
  @Column(name = "service_life_end_time",
      length = 45)
  private Timestamp serviceLifeEndTime;
  @CreationTimestamp
  @Column(name = "warranty_end_time",
      length = 45)
  private Timestamp warrantyEndTime;
  @Column(name = "users_max",
      length = 45)
  private Integer usersMax;
  @Column(name = "rooms_max",
      length = 45)
  private Integer roomsMax;
  @Column(name = "devices_max",
      length = 45)
  private Integer devicesMax;
  @Column(name = "sirens_max",
      length = 45)
  private Integer sirensMax;
  @Column(name = "on_battery",
      length = 1)
  private Integer onBattery;
  @OrderColumn
  @OneToMany(mappedBy = "hubGroupId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<UsersGroup> userGroups;
  @OrderColumn
  @OneToMany(mappedBy = "hubRexId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Rex> rexes;
  @OrderColumn
  @OneToMany(mappedBy = "hubNotificationId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Notification> notifications;
  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "hubId")
  @ToString.Exclude
  private Collection<Device> devices;
  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "hubId")
  @ToString.Exclude
  private Collection<Permission> permissions;

  public Hub(String model,
      String status,
      Timestamp serviceLifeEndTime,
      Timestamp warrantyEndTime,
      Integer usersMax,
      Integer roomsMax,
      Integer devicesMax,
      Integer sirensMax,
      Integer onBattery) {
    this.model = model;
    this.status = status;
    this.serviceLifeEndTime = serviceLifeEndTime;
    this.warrantyEndTime = warrantyEndTime;
    this.usersMax = usersMax;
    this.roomsMax = roomsMax;
    this.devicesMax = devicesMax;
    this.sirensMax = sirensMax;
    this.onBattery = onBattery;
  }

}
