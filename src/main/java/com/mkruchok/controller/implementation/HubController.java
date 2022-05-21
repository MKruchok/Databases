package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.HubDao;
import com.mkruchok.model.entity.Hub;

public final class HubController extends AbstractControllerImpl<Hub> {

  private final HubDao hubDao = new HubDao();

  @Override
  public AbstractDaoImpl<Hub> getDao() {
    return hubDao;
  }
}
