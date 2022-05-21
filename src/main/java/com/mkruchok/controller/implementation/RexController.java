package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.RexDao;
import com.mkruchok.model.entity.Rex;

public final class RexController extends AbstractControllerImpl<Rex> {
  private final RexDao rexDao = new RexDao();

  @Override
  public AbstractDaoImpl<Rex> getDao() {
    return rexDao;
  }
}
