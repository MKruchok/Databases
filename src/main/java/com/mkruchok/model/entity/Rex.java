package com.mkruchok.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public final class Rex {
  private Integer id;
  private String rexName;
  private String rexRange;
  private Integer hubId;


  public Rex(String rexName, String rexRange, Integer hubId) {
    this.rexName = rexName;
    this.rexRange = rexRange;
    this.hubId = hubId;
  }

  @Override
  public String toString() {
    return "\n\nRex: id: " + id + ", name: " + rexName + ", range: " + rexRange + ", hub_id: "
        + hubId;
  }
}
