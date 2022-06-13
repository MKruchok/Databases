package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.DevicesGroup;
import com.mkruchok.service.implementation.DevicesGroupService;
import java.sql.SQLException;
import java.util.List;

public final class DevicesGroupController implements AbstractController<DevicesGroup> {

  private final DevicesGroupService service = new DevicesGroupService();

  @Override
  public List<DevicesGroup> findAll() throws SQLException {
    return service.findAll();
  }

  @Override
  public DevicesGroup findById(Integer id) throws SQLException {
    return service.findById(id);
  }

  @Override
  public void create(DevicesGroup entity) throws SQLException {
    service.create(entity);
  }

  @Override
  public void update(Integer id, DevicesGroup entity) throws SQLException {
    service.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    service.delete(id);
  }
}
