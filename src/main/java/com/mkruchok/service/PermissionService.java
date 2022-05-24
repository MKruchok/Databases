package com.mkruchok.service;

import com.mkruchok.entity.Permission;
import com.mkruchok.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PermissionService extends AbstractService<Permission, Integer> {
  private PermissionRepository permissionRepository;

  @Override
  protected JpaRepository<Permission, Integer> getRepository() {
    return permissionRepository;
  }
}