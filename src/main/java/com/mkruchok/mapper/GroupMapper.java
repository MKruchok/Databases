package com.mkruchok.mapper;

import com.mkruchok.dto.GroupDto;
import com.mkruchok.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper extends AbstractMapper<Group, GroupDto> {

  @Override
  public GroupDto mapObjectToDto(Group group) {
    if (group == null) {
      return null;
    }
    GroupDto.GroupBuilder groupDtoBuilder = GroupDto.builder()
        .id(group.getId())
        .name(group.getName())
        .groupDescription(group.getGroupDescription())
        .groupHubModel(group.getHubGroupId().getModel())
        .groupHubId(group.getHubGroupId().getId())
        .usersCounter(group.getUsers().size())
        .groupHasPermissionsCounter(group.getGroupHasPermissions().size());
    return groupDtoBuilder.build();
  }
}
