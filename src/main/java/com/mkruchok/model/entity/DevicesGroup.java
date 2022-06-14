package com.mkruchok.model.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "devices_group")

@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@NoArgsConstructor
public class DevicesGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "group_name",
      length = 45)
  private String name;
  @OrderColumn
  @OneToMany(mappedBy = "devicesGroupId",
      fetch = FetchType.LAZY)
  @ToString.Exclude
  private Collection<Device> devices;


}
