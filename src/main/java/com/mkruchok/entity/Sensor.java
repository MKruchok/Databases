package com.mkruchok.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Table(name = "sensor")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
public class Sensor {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "name",
      length = MagicNumber.L150)
  private String name;
  @Column(name = "value",
          length = MagicNumber.L150)
  private Float value;
  @Column(name = "coordinates",
          length = MagicNumber.L150)
  private String coordinates;
  @CreationTimestamp
  @Column(name = "time_created")
  private Timestamp timeCreated;


}
