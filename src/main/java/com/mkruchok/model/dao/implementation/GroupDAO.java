package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.Group;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GroupDao implements AbstractDao<Group> {

  static final Logger LOGGER = LoggerFactory.getLogger(GroupDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.hub_group";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.hub_group WHERE id=?";
  private static final String CREATE =
      "INSERT ajax_curr.hub_group " + "(`group_name`,`group_description`,`hub_id`)"
          + " VALUES (?, ?, ?)";
  private static final String UPDATE =
      "UPDATE ajax_curr.hub_group" + " SET group_name=?, group_description=?, hub_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.hub_group WHERE id=?";

  @Override
  public List<Group> findAll() throws SQLException {
    List<Group> groups = new ArrayList<>();
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      Group group = new Group(resultSet.getInt("id"),
          resultSet.getString("group_name"),
          resultSet.getString("group_description"),
          resultSet.getInt("hub_id"));
      groups.add(group);
    }
    resultSet.close();
    return groups;
  }

  @Override
  public Group findById(Integer id) throws SQLException {
    Group group = null;
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID);
    statement.setInt(1, id);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      group = new Group(resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getString("description"),
          resultSet.getInt("hub_id"));
    }
    resultSet.close();
    return group;
  }

  @Override
  public void create(Group group) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE);
    statement.setString(1, group.getGroupName());
    statement.setString(2, group.getGroupDescription());
    statement.setInt(3, group.getHubId());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));

  }

  @Override
  public void update(Integer id, Group group) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE);
    statement.setString(1, group.getGroupName());
    statement.setString(2, group.getGroupDescription());
    statement.setInt(3, group.getHubId());
    statement.setInt(4, group.getId());
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
