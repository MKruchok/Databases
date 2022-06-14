package com.mkruchok.model.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


@Table(name = "notification")

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@ToString
@Entity
public class Notification {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @CreationTimestamp
  @Column(name = "timestamp")
  private Timestamp timestamp;
  @Column(name = "notification_type",
      length = 45)
  private String type;


  @ManyToOne
  @JoinColumn(name = "device_id",
      referencedColumnName = "id")
  private Device deviceId;

  @ManyToOne
  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubNotificationId;


}
