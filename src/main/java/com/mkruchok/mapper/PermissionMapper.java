package com.mkruchok.mapper;

import com.mkruchok.dto.PermissionDto;
import com.mkruchok.entity.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper extends AbstractMapper<Permission, PermissionDto> {

  @Override
  public PermissionDto mapObjectToDto(Permission permission) {
    if (permission == null) {
      return null;
    }
    PermissionDto.PermissionBuilder permissionDtoBuilder = PermissionDto.builder()
        .id(permission.getId())
        .name(permission.getName())
        .hubModel(permission.getHubId() == null ? null : permission.getHubId().getModel())
        .userName(permission.getUserId() == null ? null : permission.getUserId().getName())
        .usersGroupName(
            permission.getUsersGroupId() == null ? null : permission.getUsersGroupId().getName())
        .deviceModel(permission.getDeviceId() == null ? null : permission.getDeviceId().getModel());
    return permissionDtoBuilder.build();
  }
}
