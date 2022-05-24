package com.mkruchok.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(builderClassName = "NotificationBuilder")
public class NotificationDto {
  private Integer id;
  private Timestamp timestamp;
  private String type;

  private String deviceModel;
  private String hubModel;
}
