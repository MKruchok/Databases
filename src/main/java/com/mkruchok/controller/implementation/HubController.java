package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.HubDAO;
import com.mkruchok.model.entity.Hub;

public final class HubController extends AbstractControllerImpl<Hub> {

    private final HubDAO hubDao = new HubDAO();

    @Override
    public AbstractDaoImpl<Hub> getDao() {
        return hubDao;
    }
}
