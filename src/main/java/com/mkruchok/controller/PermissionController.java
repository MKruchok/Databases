package com.mkruchok.controller;

import com.mkruchok.dto.PermissionDto;
import com.mkruchok.entity.Permission;
import com.mkruchok.mapper.AbstractMapper;
import com.mkruchok.mapper.PermissionMapper;
import com.mkruchok.service.AbstractService;
import com.mkruchok.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/permissions")
@AllArgsConstructor
@RestController
public class PermissionController extends AbstractController<Permission, PermissionDto, Integer> {
  private final PermissionService permissionService;
  private final PermissionMapper permissionMapper;

  @Override
  protected AbstractService<Permission, Integer> getService() {
    return permissionService;
  }

  @Override
  protected AbstractMapper<Permission, PermissionDto> getMapper() {
    return permissionMapper;
  }
}
