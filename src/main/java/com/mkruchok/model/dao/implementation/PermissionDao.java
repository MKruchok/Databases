package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.Permission;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PermissionDao implements AbstractDao<Permission> {

  static final Logger LOGGER = LoggerFactory.getLogger(PermissionDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.permission";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.permission WHERE id=?";
  private static final String CREATE =
      "INSERT ajax_curr.permission " + "(`permission_name`,`hub_id`,`user_id`,`group_id`,`device_id`)"
          + " VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE =
      "UPDATE ajax_curr.permission" + " SET permission_name=?, hub_id=?, user_id=?, group_id=?, device_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.permission WHERE id=?";

  @Override
  public List<Permission> findAll() throws SQLException {
    List<Permission> permissions = new ArrayList<>();
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      Permission permission = new Permission(resultSet.getInt("id"),
          resultSet.getString("permission_name"),
          resultSet.getInt("hub_id"),
          resultSet.getInt("user_id"),
          resultSet.getInt("group_id"),
          resultSet.getInt("device_id"));
      permissions.add(permission);
    }
    resultSet.close();
    return permissions;
  }

  @Override
  public Permission findById(Integer id) throws SQLException {
    Permission permission = null;
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID);
    statement.setInt(1, id);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      permission = new Permission(resultSet.getInt("id"),
          resultSet.getString("permission_name"),
          resultSet.getInt("hub_id"),
          resultSet.getInt("user_id"),
          resultSet.getInt("group_id"),
          resultSet.getInt("device_id"));
    }
    resultSet.close();
    return permission;
  }

  @Override
  public void create(Permission permission) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE);
    statement.setString(1, permission.getPermissionName());
    statement.setInt(2, permission.getHub_id());
    statement.setInt(3, permission.getUser_id());
    statement.setInt(4, permission.getGroup_id());
    statement.setInt(5, permission.getDevice_id());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));

  }

  @Override
  public void update(Integer id, Permission permission) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE);
    statement.setString(1, permission.getPermissionName());
    statement.setInt(2, permission.getHub_id());
    statement.setInt(4, permission.getGroup_id());
    statement.setInt(3, permission.getUser_id());
    statement.setInt(5, permission.getDevice_id());
    statement.setInt(3, permission.getId());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));
  }

  @Override
  public void delete(Integer id) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE);
    LOGGER.info(String.valueOf(statement));
    statement.setInt(1, id);
    statement.executeUpdate();
  }
}
