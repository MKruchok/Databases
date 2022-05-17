package com.mkruchok.controller.implementation;

import com.mkruchok.model.dao.implementation.AbstractDaoImpl;
import com.mkruchok.model.dao.implementation.PermissionDAO;
import com.mkruchok.model.entity.Permission;


public final class PermissionController extends AbstractControllerImpl<Permission> {
    private final PermissionDAO permissionDao = new PermissionDAO();

    @Override
    public AbstractDaoImpl<Permission> getDao() {
        return permissionDao;
    }
}
