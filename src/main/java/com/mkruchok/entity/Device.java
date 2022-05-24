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
      length = MagicNumber.L45)
  private String model;
  @Column(name = "device_status",
      length = MagicNumber.L45)
  private String status;
  @CreationTimestamp
  @Column(name = "service_life_end_time")
  private Timestamp serviceLifeEndTime;
  @CreationTimestamp
  @Column(name = "warranty_end_time")
  private Timestamp warrantyEndTime;
  @Column(name = "on_battery",
      length = 1)
  private Integer onBattery;


  @ManyToOne(cascade = CascadeType.MERGE)

  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubId;

  @OrderColumn
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "deviceId",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Notification> notifications;
}
