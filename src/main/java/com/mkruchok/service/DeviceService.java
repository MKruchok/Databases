package com.mkruchok.service;

import com.mkruchok.entity.Device;
import com.mkruchok.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeviceService extends AbstractService<Device, Integer> {
  private DeviceRepository deviceRepository;

  @Override
  protected JpaRepository<Device, Integer> getRepository() {
    return deviceRepository;
  }

}