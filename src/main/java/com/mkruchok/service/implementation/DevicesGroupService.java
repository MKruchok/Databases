package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.DevicesGroupDao;
import com.mkruchok.model.entity.DevicesGroup;
import com.mkruchok.service.AbstractService;
import java.sql.SQLException;
import java.util.List;

public final class DevicesGroupService implements AbstractService<DevicesGroup> {

  private final DevicesGroupDao dao = new DevicesGroupDao();

  @Override
  public List<DevicesGroup> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public DevicesGroup findById(Integer id) throws SQLException {
    return dao.findById(id);
  }

  @Override
  public void create(DevicesGroup entity) throws SQLException {
    dao.create(entity);
  }

  @Override
  public void update(Integer id, DevicesGroup entity) throws SQLException {
    dao.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
  }

}
