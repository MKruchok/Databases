package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.DevicesGroup;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DevicesGroupDao implements AbstractDao<DevicesGroup> {

  static final Logger LOGGER = LoggerFactory.getLogger(DevicesGroupDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.devices_group";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.devices_group WHERE id=?";
  private static final String CREATE =
      "INSERT ajax_curr.devices_group " + "(`group_name`)"
          + " VALUES (?)";
  private static final String UPDATE =
      "UPDATE ajax_curr.devices_group" + " SET group_name=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.users_group WHERE id=?";

  @Override
  public List<DevicesGroup> findAll() throws SQLException {
    List<DevicesGroup> devicesGroups = new ArrayList<>();
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      DevicesGroup devicesGroup = new DevicesGroup(resultSet.getInt("id"),
          resultSet.getString("group_name"));
      devicesGroups.add(devicesGroup);
    }
    resultSet.close();
    return devicesGroups;
  }

  @Override
  public DevicesGroup findById(Integer id) throws SQLException {
    DevicesGroup group = null;
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID);
    statement.setInt(1, id);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      group = new DevicesGroup(resultSet.getInt("id"),
          resultSet.getString("group_name"));
    }
    resultSet.close();
    return group;
  }

  @Override
  public void create(DevicesGroup group) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE);
    statement.setString(1, group.getGroupName());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));

  }

  @Override
  public void update(Integer id, DevicesGroup group) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE);
    statement.setString(1, group.getGroupName());
    statement.setInt(2, group.getId());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));
  }

  @Override
  public void delete(Integer id) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE);
    statement.setInt(1, id);
    LOGGER.info(String.valueOf(statement));
    statement.executeUpdate();
  }
}
