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
  private String email;
  private String password;
  private Timestamp dateCreated;
  private String userName;
  private Integer usersGroupId;

  private String groupName;
  private Integer userHasHubsCounter;
  private Integer permissionsCounter;
}
