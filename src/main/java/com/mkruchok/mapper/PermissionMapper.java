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
        .permissionDescription(permission.getPermissionDescription())
        .permissionHasUsersCounter(permission.getPermissionHasUsers().size())
        .permissionHasGroupsCounter(permission.getPermissionHasGroups().size());
    return permissionDtoBuilder.build();
  }
}
