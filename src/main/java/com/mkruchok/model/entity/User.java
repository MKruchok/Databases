package com.mkruchok.model.entity;


import java.sql.Timestamp;
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
public final class User {
  private Integer id;
  private String email;
  private String userPassword;
  private Timestamp dateCreated;
  private String userName;
  private String usersGroupId;


}
