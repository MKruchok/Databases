package com.mkruchok.controller;

import com.mkruchok.dto.UsersGroupDto;
import com.mkruchok.entity.UsersGroup;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.UsersGroupMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.UsersGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users_group")
@AllArgsConstructor
@RestController
public class UsersGroupController extends AbstractController<UsersGroup, UsersGroupDto, Integer> {
  private final UsersGroupService usersGroupService;
  private final UsersGroupMapper usersGroupMapper;

  @Override
  protected AbstractService<UsersGroup, Integer> getService() {
    return usersGroupService;
  }

  @Override
  protected AbstractMapper<UsersGroup, UsersGroupDto> getMapper() {
    return usersGroupMapper;
  }
}
