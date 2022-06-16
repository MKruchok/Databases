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
  private Integer hubId;
  private Integer userId;
  private Integer groupId;
  private Integer deviceId;


}
