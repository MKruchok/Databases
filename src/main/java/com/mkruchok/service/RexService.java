package com.mkruchok.service;

import com.mkruchok.entity.Rex;
import com.mkruchok.repository.RexRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RexService extends AbstractService<Rex, Integer> {
  private RexRepository rexRepository;

  @Override
  protected JpaRepository<Rex, Integer> getRepository() {
    return rexRepository;
  }
}