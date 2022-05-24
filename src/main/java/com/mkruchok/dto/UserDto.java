package com.mkruchok.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "UserBuilder")
public class UserDto {
  private Integer id;
  private Integer groupId;
  private String email;
  private Timestamp dateCreated;
  private String name;
  private String password;

  private String groupName;
  private Integer userHasHubsCounter;
  private Integer userHasPermissionsCounter;
}
