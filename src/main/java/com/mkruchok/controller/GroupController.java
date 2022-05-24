package com.mkruchok.controller;

import com.mkruchok.dto.GroupDto;
import com.mkruchok.entity.Group;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.GroupMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/groups")
@AllArgsConstructor
@RestController
public class GroupController extends AbstractController<Group, GroupDto, Integer> {
  private final GroupService groupService;
  private final GroupMapper groupMapper;

  @Override
  protected AbstractService<Group, Integer> getService() {
    return groupService;
  }

  @Override
  protected AbstractMapper<Group, GroupDto> getMapper() {
    return groupMapper;
  }
}
