package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.RexDAO;
import com.mkruchok.model.entity.Rex;

public final class RexController extends AbstractControllerImpl<Rex> {
    private final RexDAO rexDao = new RexDAO();

    @Override
    public AbstractDaoImpl<Rex> getDao() {
        return rexDao;
    }
}
