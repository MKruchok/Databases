package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.UsersGroupDao;
import com.mkruchok.model.entity.UsersGroup;
import com.mkruchok.service.AbstractService;
import java.sql.SQLException;
import java.util.List;

public final class UsersGroupService implements AbstractService<UsersGroup> {

  private final UsersGroupDao dao = new UsersGroupDao();

  @Override
  public List<UsersGroup> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public UsersGroup findById(Integer id) throws SQLException {
    return dao.findById(id);
  }

  @Override
  public void create(UsersGroup entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, UsersGroup entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
  }

}
