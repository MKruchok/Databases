package com.mkruchok.service;

import com.mkruchok.entity.Sensor;
import com.mkruchok.repository.SensorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SensorService extends AbstractService<Sensor, Integer> {
  private SensorRepository sensorRepository;

  @Override
  protected JpaRepository<Sensor, Integer> getRepository() {
    return sensorRepository;
  }

}