package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.User;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UserDao implements AbstractDao<User> {

  static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.user";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.user WHERE id=?";
  private static final String CREATE = "INSERT ajax_curr.user "
      + "(`email`, `user_password`, `date_created`, `user_name`, `users_group_id`)"
      + " VALUES (?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE ajax_curr.user"
      + " SET email=?, user_password=?, date_created=?, user_name=?, users_group_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.user WHERE id=?";

  @Override
  public List<User> findAll() throws SQLException {
    List<User> users = new ArrayList<>();
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      User user = new User(resultSet.getInt("id"),
          resultSet.getString("email"),
          resultSet.getString("user_password"),
          resultSet.getTimestamp("date_created"),
          resultSet.getString("user_name"),
          resultSet.getString("users_group_id"));
      users.add(user);
    }
    resultSet.close();
    return users;
  }

  @Override
  public User findById(Integer id) throws SQLException {
    User user = null;
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID);
    statement.setInt(1, id);
    LOGGER.info(String.valueOf(statement));
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
      user = new User(resultSet.getInt("id"),
          resultSet.getString("email"),
          resultSet.getString("user_password"),
          resultSet.getTimestamp("date_created"),
          resultSet.getString("user_name"),
          resultSet.getString("users_group_id"));
    }
    resultSet.close();
    return user;
  }

  @Override
  public void create(User user) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE);
    statement.setString(1, user.getEmail());
    statement.setString(2, user.getUserPassword());
    statement.setTimestamp(3, user.getDateCreated());
    statement.setString(4, user.getUserName());
    statement.setString(5, user.getUsersGroupId());
    statement.executeUpdate();
    LOGGER.info(String.valueOf(statement));

  }

  @Override
  public void update(Integer id, User user) throws SQLException {
    PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE);
    statement.setString(1, user.getEmail());
    statement.setTimestamp(3, user.getDateCreated());
    statement.setString(2, user.getUserPassword());
    statement.setString(4, user.getUserName());
    statement.setString(5, user.getUsersGroupId());
    statement.setInt(6, user.getId());
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
