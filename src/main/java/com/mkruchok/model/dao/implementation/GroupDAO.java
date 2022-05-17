package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.Group;
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
public final class GroupDAO implements AbstractDAO<Group> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.group";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.group WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.group "
            + "(`name`,`description`,`hub_id`)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.group"
            + " SET name=?, description=?, hub_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.group WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(GroupDAO.class);

    @Override
    public List<Group> findAll() throws SQLException {
        List<Group> groups = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Group group = new Group(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("hub_id")
                );
                groups.add(group);
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
        return groups;
    }

    @Override
    public Group findById(Integer id) throws SQLException {
        Group group = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group = new Group(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getInt("hub_id")
                );
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
        return group;
    }

    @Override
    public void create(Group group) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());
            statement.setInt(3, group.getHubId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, Group group) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, group.getName());
            statement.setString(2, group.getDescription());
            statement.setInt(3, group.getHubId());
            statement.setInt(4, group.getId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
    }
}
