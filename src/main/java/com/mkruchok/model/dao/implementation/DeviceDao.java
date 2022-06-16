package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDao;
import com.mkruchok.model.entity.Device;
import com.mkruchok.persistent.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class DeviceDao implements AbstractDao<Device> {

  static final Logger LOGGER = LoggerFactory.getLogger(DeviceDao.class);
  private static final String GET_ALL = "SELECT * FROM ajax_curr.device";
  private static final String GET_BY_ID = "SELECT * FROM ajax_curr.device WHERE id=?";
  private static final String CREATE = "INSERT ajax_curr.device "
      + "(`model`,`device_status`,`service_life_end_time`,`warranty_end_time`,"
      + "`on_battery`,`hub_id`, `devices_group_id`)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE ajax_curr.device"
      + " SET model=?, device_status=?, service_life_end_time=?, warranty_end_time=?,"
      + " on_battery=?, hub_id=?, devices_group_id=? WHERE id=?";
  private static final String DELETE = "DELETE FROM ajax_curr.device WHERE id=?";

  @Override
  public List<Device> findAll() throws SQLException {
    List<Device> devices = new ArrayList<>();
    try (
        PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
      LOGGER.info(String.valueOf(statement));
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Device device = new Device(resultSet.getInt("id"),
            resultSet.getString("model"),
            resultSet.getString("device_status"),
            resultSet.getTimestamp("service_life_end_time"),
            resultSet.getTimestamp("warranty_end_time"),
            resultSet.getInt("on_battery"),
            resultSet.getInt("hub_id"),
            resultSet.getInt("devices_group_id"));
        devices.add(device);
      }
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
    return devices;
  }

  @Override
  public Device findById(Integer id) throws SQLException {
    Device device = null;
    try (PreparedStatement statement = ConnectionManager.getConnection()
        .prepareStatement(GET_BY_ID)) {
      statement.setInt(1, id);
      LOGGER.info(String.valueOf(statement));
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        device = new Device(resultSet.getInt("id"),
            resultSet.getString("model"),
            resultSet.getString("device_status"),
            resultSet.getTimestamp("service_life_end_time"),
            resultSet.getTimestamp("warranty_end_time"),
            resultSet.getInt("on_battery"),
            resultSet.getInt("hub_id"),
            resultSet.getInt("devices_group_id"));
      }
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
    return device;
  }

  @Override
  public void create(Device device) throws SQLException {
    try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
      statement.setString(1, device.getModel());
      statement.setString(2, device.getDeviceStatus());
      statement.setTimestamp(3, device.getServiceLifeEndTime());
      statement.setTimestamp(4, device.getWarrantyEndTime());
      statement.setInt(5, device.getOnBattery());
      statement.setInt(6, device.getHubId());
      statement.setInt(6, device.getDevicesGroupId());
      statement.executeUpdate();
      LOGGER.info(String.valueOf(statement));
    } catch (SQLException e) {
      LOGGER.error(e.toString());
    }
  }

  @Override
  public void update(Integer id, Device device) throws SQLException {
    try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
      statement.setString(2, device.getDeviceStatus());
      statement.setString(1, device.getModel());
      statement.setTimestamp(3, device.getServiceLifeEndTime());
      statement.setTimestamp(4, device.getWarrantyEndTime());
      statement.setInt(5, device.getOnBattery());
      statement.setInt(6, device.getHubId());
      statement.setInt(6, device.getDevicesGroupId());
      statement.setInt(8, device.getId());
      LOGGER.info(String.valueOf(statement));
      statement.executeUpdate();
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
