package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.UsersGroup;
import com.mkruchok.service.implementation.UsersGroupService;
import java.sql.SQLException;
import java.util.List;

public final class UsersGroupController implements AbstractController<UsersGroup> {

  private final UsersGroupService service = new UsersGroupService();

  @Override
  public List<UsersGroup> findAll() throws SQLException {
    return service.findAll();
  }

  @Override
  public UsersGroup findById(Integer id) throws SQLException {
    return service.findById(id);
  }

  @Override
  public void create(UsersGroup entity) throws SQLException {
    service.create(entity);
  }

  @Override
  public void update(Integer id, UsersGroup entity) throws SQLException {
    service.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    service.delete(id);
  }
}
