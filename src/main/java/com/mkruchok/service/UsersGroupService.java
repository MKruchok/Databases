package com.mkruchok.service;

import com.mkruchok.entity.UsersGroup;
import com.mkruchok.repository.UsersGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsersGroupService extends AbstractService<UsersGroup, Integer> {
  private UsersGroupRepository usersGroupRepository;

  @Override
  protected JpaRepository<UsersGroup, Integer> getRepository() {
    return usersGroupRepository;
  }

}