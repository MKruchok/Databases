package com.mkruchok.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Permission {
  private Integer id;
  private String permissionName;
  private String description;


  @Override
  public String toString() {
    return "\n\nPermission: id: " + id + ", name: " + permissionName + ", description: "
        + description;
  }
}
