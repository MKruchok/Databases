package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.User;
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
public final class UserDAO implements AbstractDAO<User> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.user";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.user WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.user "
            + "(`email`, `password`, `date_created`, `name`, `group_id`) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.user"
            + " SET email=?, password=?, date_created=?, name=?, group_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.user WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("date_created"),
                        resultSet.getString("name"),
                        resultSet.getString("group_id")
                );
                users.add(user);
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("date_created"),
                        resultSet.getString("name"),
                        resultSet.getString("group_id")
                );
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setTimestamp(3, user.getDateCreated());
            statement.setString(4, user.getName());
            statement.setString(5, user.getGroupId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setTimestamp(3, user.getDateCreated());
            statement.setString(4, user.getName());
            statement.setString(5, user.getGroupId());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            LOGGER.info(String.valueOf(statement));
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }
    }
}
