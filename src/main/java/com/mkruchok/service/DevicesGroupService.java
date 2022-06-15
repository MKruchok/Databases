package com.mkruchok.service;

import com.mkruchok.entity.DevicesGroup;
import com.mkruchok.repository.DevicesGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DevicesGroupService extends AbstractService<DevicesGroup, Integer> {
  private DevicesGroupRepository devicesGroupRepository;

  @Override
  protected JpaRepository<DevicesGroup, Integer> getRepository() {
    return devicesGroupRepository;
  }

}