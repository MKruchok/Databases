package com.mkruchok.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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
      length = MagicNumber.L45)
  private String type;


  @ManyToOne(cascade = CascadeType.MERGE)

  @JoinColumn(name = "device_id",
      referencedColumnName = "id")
  private Device deviceId;

  @ManyToOne(cascade = CascadeType.MERGE)

  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubNotificationId;


}
