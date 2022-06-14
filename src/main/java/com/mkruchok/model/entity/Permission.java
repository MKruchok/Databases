package com.mkruchok.model.entity;

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


@Table(name = "permission")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@Setter
@ToString
@Entity
public class Permission {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "permission_name",
      length = 45)
  private String name;
  @ManyToOne
  @JoinColumn(name = "hub_id",
      referencedColumnName = "id")
  private Hub hubId;
  @ManyToOne
  @JoinColumn(name = "user_id",
      referencedColumnName = "id")
  private User userId;
  @ManyToOne
  @JoinColumn(name = "group_id",
      referencedColumnName = "id")
  private UsersGroup groupId;
  @ManyToOne
  @JoinColumn(name = "device_id",
      referencedColumnName = "id")
  private Device deviceId;

}
