package com.mkruchok.service;

import com.mkruchok.entity.Group;
import com.mkruchok.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GroupService extends AbstractService<Group, Integer> {
  private GroupRepository groupRepository;

  @Override
  protected JpaRepository<Group, Integer> getRepository() {
    return groupRepository;
  }

}