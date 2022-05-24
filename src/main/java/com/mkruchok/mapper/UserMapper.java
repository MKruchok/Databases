package com.mkruchok.mapper;

import com.mkruchok.dto.UserDto;
import com.mkruchok.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

  @Override
  public UserDto mapObjectToDto(User user) {
    if (user == null) {
      return null;
    }
    UserDto.UserBuilder userDtoBuilder = UserDto.builder()
        .id(user.getId())
        .email(user.getEmail())
        .password(user.getPassword())
        .dateCreated(user.getDateCreated())
        .name(user.getName())
        .groupId(user.getGroupId() == null ? null : user.getGroupId().getId())
        .groupName(user.getGroupId() == null ? "null" : user.getGroupId().getName())
        .userHasHubsCounter(user.getUserHasHubs().size())
        .userHasPermissionsCounter(user.getUserHasPermissions().size());
    return userDtoBuilder.build();
  }
}
