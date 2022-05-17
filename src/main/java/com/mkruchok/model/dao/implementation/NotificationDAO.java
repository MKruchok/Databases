package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.Notification;
import com.mkruchok.persistant.ConnectionManager;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SuppressFBWarnings
@SuppressWarnings("magicnumber")
public final class NotificationDAO implements AbstractDAO<Notification> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.notification";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.notification WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.notification "
            + "(`timestamp`,`notification_type`,`device_id`,`hub_id`)" +
            " VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.notification"
            + " SET timestamp=?, notification_type=?, device_id=?, hub_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.notification WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(NotificationDAO.class);

    @Override
    public List<Notification> findAll() throws SQLException {
        List<Notification> notifications = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Notification notification = new Notification(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("notification_type"),
                        resultSet.getInt("device_id"),
                        resultSet.getInt("hub_id")
                );
                notifications.add(notification);
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
        return notifications;
    }

    @Override
    public Notification findById(Integer id) throws SQLException {
        Notification notification = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                notification = new Notification(
                        resultSet.getInt("id"),
                        resultSet.getTimestamp("timestamp"),
                        resultSet.getString("notification_type"),
                        resultSet.getInt("device_id"),
                        resultSet.getInt("hub_id")
                );
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
        return notification;
    }

    @Override
    public void create(Notification notification) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setTimestamp(1, notification.getTimestamp());
            statement.setString(2, notification.getNotificationType());
            statement.setInt(3, notification.getDeviceId());
            statement.setInt(4, notification.getHubId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, Notification notification) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setTimestamp(1, notification.getTimestamp());
            statement.setString(2, notification.getNotificationType());
            statement.setInt(3, notification.getDeviceId());
            statement.setInt(4, notification.getHubId());
            statement.setInt(5, notification.getId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
    }
}
