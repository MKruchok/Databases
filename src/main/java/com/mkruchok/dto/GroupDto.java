package com.mkruchok.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder(builderClassName = "GroupBuilder")
public class GroupDto {
  private Integer id;
  private String name;
  private String groupDescription;
  private Integer groupHubId;

  private String groupHubModel;
  private Integer usersCounter;
  private Integer groupHasPermissionsCounter;
}
