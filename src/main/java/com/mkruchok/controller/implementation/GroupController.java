package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.GroupDAO;
import com.mkruchok.model.entity.Group;


public final class GroupController extends AbstractControllerImpl<Group> {
    private final GroupDAO groupDao = new GroupDAO();

    @Override
    public AbstractDaoImpl<Group> getDao() {
        return groupDao;
    }
}
