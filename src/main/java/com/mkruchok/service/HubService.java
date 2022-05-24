package com.mkruchok.service;

import com.mkruchok.entity.Hub;
import com.mkruchok.repository.HubRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HubService extends AbstractService<Hub, Integer> {
  private HubRepository hubRepository;

  @Override
  protected JpaRepository<Hub, Integer> getRepository() {
    return hubRepository;
  }

}