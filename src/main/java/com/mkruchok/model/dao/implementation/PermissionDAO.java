package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.Permission;
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
public final class PermissionDAO implements AbstractDAO<Permission> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.permission";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.permission WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.permission "
            + "(`permission_name`,`permission_description`)" +
            " VALUES (?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.permission"
            + " SET permission_name=?, permission_description=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.permission WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(PermissionDAO.class);

    @Override
    public List<Permission> findAll() throws SQLException {
        List<Permission> permissions = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Permission permission = new Permission(
                        resultSet.getInt("id"),
                        resultSet.getString("permission_name"),
                        resultSet.getString("permission_description")
                );
                permissions.add(permission);
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
        return permissions;
    }

    @Override
    public Permission findById(Integer id) throws SQLException {
        Permission permission = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                permission = new Permission(
                        resultSet.getInt("id"),
                        resultSet.getString("permission_name"),
                        resultSet.getString("permission_description")
                );
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
        return permission;
    }

    @Override
    public void create(Permission permission) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, permission.getPermissionName());
            statement.setString(2, permission.getDescription());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, Permission permission) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, permission.getPermissionName());
            statement.setString(2, permission.getDescription());
            statement.setInt(3, permission.getId());
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
