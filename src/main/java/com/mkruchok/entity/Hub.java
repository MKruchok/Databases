package com.mkruchok.entity;


import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "model",
      length = MagicNumber.L45)
  private String model;
  @Column(name = "hub_status",
      length = MagicNumber.L45)
  private String status;
  @CreationTimestamp
  @Column(name = "service_life_end_time",
      length = MagicNumber.L45)
  private Timestamp serviceLifeEndTime;
  @CreationTimestamp
  @Column(name = "warranty_end_time",
      length = MagicNumber.L45)
  private Timestamp warrantyEndTime;
  @Column(name = "users_max",
      length = MagicNumber.L45)
  private Integer usersMax;
  @Column(name = "rooms_max",
      length = MagicNumber.L45)
  private Integer roomsMax;
  @Column(name = "devices_max",
      length = MagicNumber.L45)
  private Integer devicesMax;
  @Column(name = "sirens_max",
      length = MagicNumber.L45)
  private Integer sirensMax;
  @Column(name = "on_battery",
      length = 1)
  private Integer onBattery;
  @OrderColumn
  @OneToMany(mappedBy = "hubGroupId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Group> groups;
  @OrderColumn
  @OneToMany(mappedBy = "hubRexId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Rex> rexes;
  @OrderColumn
  @OneToMany(mappedBy = "hubNotificationId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Notification> notifications;


  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "hubId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Device> devices;


  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(mappedBy = "userHasHubs",
      cascade = CascadeType.ALL)
  @ToString.Exclude
  private Collection<User> hubHasUsers;

  public Hub(String s) {
    this.model = s;
  }
}
