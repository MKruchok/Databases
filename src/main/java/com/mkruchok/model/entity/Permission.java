package com.mkruchok.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public final class Permission {
  private Integer id;
  private String permissionName;
  private Integer hub_id;
  private Integer user_id;
  private Integer group_id;
  private Integer device_id;



}
