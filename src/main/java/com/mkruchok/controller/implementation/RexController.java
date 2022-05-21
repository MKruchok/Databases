package com.mkruchok.controller.implementation;

import com.mkruchok.controller.AbstractController;
import com.mkruchok.model.entity.Rex;
import com.mkruchok.service.implementation.RexService;
import java.sql.SQLException;
import java.util.List;

public final class RexController implements AbstractController<Rex> {

  private final RexService service = new RexService();

  @Override
  public List<Rex> findAll() throws SQLException {
    return service.findAll();
  }

  @Override
  public Rex findById(Integer id) throws SQLException {
    return service.findById(id);
  }

  @Override
  public void create(Rex entity) throws SQLException {
    service.create(entity);
  }

  @Override
  public void update(Integer id, Rex entity) throws SQLException {
    service.update(id, entity);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    service.delete(id);
  }
}
