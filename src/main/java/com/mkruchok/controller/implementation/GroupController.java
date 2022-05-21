package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Group;
import com.mkruchok.service.implementation.GroupService;
import java.sql.SQLException;
import java.util.List;

public final class GroupController implements AbstractController<Group> {

  private final GroupService service = new GroupService();

  @Override
  public List<Group> findAll() throws SQLException {
    return service.findAll();
  }

  @Override
  public Group findById(Integer id) throws SQLException {
    return service.findById(id);
  }

  @Override
  public void create(Group entity) throws SQLException {
    service.create(entity);
  }

  @Override
  public void update(Integer id, Group entity) throws SQLException {
    service.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    service.delete(id);
  }
}
