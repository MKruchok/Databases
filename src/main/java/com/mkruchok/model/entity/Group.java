package com.mkruchok.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Group {
  private Integer id;
  private String groupName;
  private String groupDescription;
  private Integer hubId;


  @Override
  public String toString() {
    return "\n\nGroup: id: " + id + ", name: " + groupName + ", description: " + groupDescription
        + ", hub_id: " + hubId;
  }
}
