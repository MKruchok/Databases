package com.mkruchok.mapper;

import com.mkruchok.dto.UsersGroupDto;
import com.mkruchok.entity.UsersGroup;
import org.springframework.stereotype.Component;

@Component
public class UsersGroupMapper extends AbstractMapper<UsersGroup, UsersGroupDto> {

  @Override
  public UsersGroupDto mapObjectToDto(UsersGroup usersGroup) {
    if (usersGroup == null) {
      return null;
    }
    UsersGroupDto.UsersGroupBuilder groupDtoBuilder = UsersGroupDto.builder()
        .id(usersGroup.getId())
        .name(usersGroup.getName())
        .groupDescription(usersGroup.getGroupDescription())
        .groupHubId(usersGroup.getHubGroupId() == null ? null : usersGroup.getHubGroupId().getId())
        .groupHubModel(
            usersGroup.getHubGroupId() == null ? null : usersGroup.getHubGroupId().getModel())
        .usersCounter(usersGroup.getUsers() == null ? null : usersGroup.getUsers().size())
        .permissionsCounter(
            usersGroup.getPermissions() == null ? null : usersGroup.getPermissions().size());
    return groupDtoBuilder.build();
  }
}
