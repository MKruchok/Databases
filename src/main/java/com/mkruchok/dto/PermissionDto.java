package com.mkruchok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "PermissionBuilder")
public class PermissionDto {
  private Integer id;
  private String name;
  private String permissionDescription;

  private Integer permissionHasUsersCounter;
  private Integer permissionHasGroupsCounter;
}
