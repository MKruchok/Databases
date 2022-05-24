package com.mkruchok.controller;

import com.mkruchok.dto.UserDto;
import com.mkruchok.entity.User;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.UserMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@AllArgsConstructor
@RestController
public class UserController extends AbstractController<User, UserDto, Integer> {
  private final UserService userService;
  private final UserMapper userMapper;

  @Override
  protected AbstractService<User, Integer> getService() {
    return userService;
  }

  @Override
  protected AbstractMapper<User, UserDto> getMapper() {
    return userMapper;
  }
}
