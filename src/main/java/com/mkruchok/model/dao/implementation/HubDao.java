package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.Hub;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HubDao implements AbstractDao<Hub> {

  static final Logger LOGGER = LoggerFactory.getLogger(HubDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.hub";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.hub WHERE id=?";
  private static final String CREATE = "INSERT ajax_curr.hub "
      + "(`model`,`hub_status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,"
      + "`devices_max`,`sirens_max`,`on_battery`) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE ajax_curr.hub"
      + " SET model=?, hub_status=?, service_life_end_time=?, warranty_end_time=?, users_max=?,"
      + " rooms_max=?, devices_max=?, sirens_max=?, on_battery=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.hub WHERE id=?";

  @Override
  public List<Hub> findAll() throws SQLException {
    List<Hub> hubs = new ArrayList<>();
    try (
        PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
      LOGGER.info(String.valueOf(statement));
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Hub hub = new Hub(resultSet.getInt("id"),
            resultSet.getString("model"),
            resultSet.getString("hub_status"),
            resultSet.getTimestamp("service_life_end_time"),
            resultSet.getTimestamp("warranty_end_time"),
            resultSet.getInt("users_max"),
            resultSet.getInt("rooms_max"),
            resultSet.getInt("devices_max"),
            resultSet.getInt("sirens_max"),
            resultSet.getInt("on_battery"));
        hubs.add(hub);
      }
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
    return hubs;

  }

  @Override
  public Hub findById(Integer id) throws SQLException {
    Hub hub = null;
    try (PreparedStatement statement = ConnectionManager.getConnection()
        .prepareStatement(GET_BY_ID)) {
      statement.setInt(1, id);
      LOGGER.info(String.valueOf(statement));
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        hub = new Hub(resultSet.getInt("id"),
            resultSet.getString("model"),
            resultSet.getString("hub_status"),
            resultSet.getTimestamp("service_life_end_time"),
            resultSet.getTimestamp("warranty_end_time"),
            resultSet.getInt("users_max"),
            resultSet.getInt("rooms_max"),
            resultSet.getInt("devices_max"),
            resultSet.getInt("sirens_max"),
            resultSet.getInt("on_battery"));
      }
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
    return hub;
  }

  @Override
  public void create(Hub hub) throws SQLException {
    try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, hub.getModel());
      statement.setString(2, hub.getHubStatus());
      statement.setTimestamp(3, hub.getServiceLifeEndTime());
      statement.setTimestamp(4, hub.getWarrantyEndTime());
      statement.setInt(6, hub.getRoomsMax());
      statement.setInt(5, hub.getUsersMax());
      statement.setInt(7, hub.getDevicesMax());
      statement.setInt(8, hub.getSirensMax());
      statement.setInt(9, hub.getOnBattery());
      statement.executeUpdate();
      LOGGER.info(String.valueOf(statement));
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
  }

  @Override
  public void update(Integer id, Hub hub) throws SQLException {
    try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
      statement.setString(1, hub.getModel());
      statement.setString(2, hub.getHubStatus());
      statement.setTimestamp(3, hub.getServiceLifeEndTime());
      statement.setTimestamp(4, hub.getWarrantyEndTime());
      statement.setInt(5, hub.getUsersMax());
      statement.setInt(6, hub.getRoomsMax());
      statement.setInt(7, hub.getDevicesMax());
      statement.setInt(8, hub.getSirensMax());
      statement.setInt(9, hub.getOnBattery());
      statement.setInt(10, hub.getId());
      statement.executeUpdate();
      LOGGER.info(String.valueOf(statement));
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
  }

  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
      statement.setInt(1, id);
      LOGGER.info(String.valueOf(statement));
      statement.executeUpdate();
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
  }
}
