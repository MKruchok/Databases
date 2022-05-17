package com.mkruchok.service.implementation;

import com.mkruchok.model.dao.implementation.GroupDAO;
import com.mkruchok.model.entity.Group;
import com.mkruchok.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public final class GroupService implements AbstractService<Group> {

    private final GroupDAO dao = new GroupDAO();

    @Override
    public List<Group> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Group findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Group entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Group entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }

}
