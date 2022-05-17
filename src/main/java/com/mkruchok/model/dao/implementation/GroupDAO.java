package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.HubGroup;
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
public final class GroupDAO implements AbstractDAO<HubGroup> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.hub_group";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.hub_group WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.hub_group "
            + "(`group_name`,`group_description`,`hub_id`)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.hub_group"
            + " SET group_name=?, group_description=?, hub_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.hub_group WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(GroupDAO.class);

    @Override
    public List<HubGroup> findAll() throws SQLException {
        List<HubGroup> groups = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HubGroup group = new HubGroup(
                        resultSet.getInt("id"),
                        resultSet.getString("group_name"),
                        resultSet.getString("group_description"),
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
    public HubGroup findById(Integer id) throws SQLException {
        HubGroup group = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                group = new HubGroup(
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
    public void create(HubGroup group) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, group.getGroupName());
            statement.setString(2, group.getGroupDescription());
            statement.setInt(3, group.getHubId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, HubGroup group) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, group.getGroupName());
            statement.setString(2, group.getGroupDescription());
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
