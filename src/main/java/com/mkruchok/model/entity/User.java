package com.mkruchok.model.entity;


import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class User {
  private Integer id;
  private String email;
  private String userPassword;
  private Timestamp dateCreated;
  private String userName;
  private String groupId;


  @Override
  public String toString() {
    return "\n\nUser: id: " + id + ", email: " + email + ", password: " + userPassword
        + ", date created: " + dateCreated;
  }
}
