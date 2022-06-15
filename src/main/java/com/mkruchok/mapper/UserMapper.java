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
        .userName(user.getName())
        .usersGroupId(user.getUsersGroupId() == null ? null : user.getUsersGroupId().getId())
        .groupName(user.getUsersGroupId() == null ? null : user.getUsersGroupId().getName())
        .userHasHubsCounter(user.getUserHasHubs() == null ? null : user.getUserHasHubs().size())
        .permissionsCounter(user.getPermissions() == null ? null : user.getPermissions().size());
    return userDtoBuilder.build();
  }
}
