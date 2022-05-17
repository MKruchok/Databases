package com.mkruchok.model.dao.implementation;

import com.mkruchok.model.dao.AbstractDAO;
import com.mkruchok.model.entity.Rex;
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
public final class RexDAO implements AbstractDAO<Rex> {

    private static final String GET_ALL = "SELECT * FROM ajax_curr.rex";
    private static final String GET_BY_ID = "SELECT * FROM ajax_curr.rex WHERE id=?";
    private static final String CREATE = "INSERT ajax_curr.rex "
            + "(`rex_name`,`rex_range`,`hub_id`)" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE ajax_curr.rex"
            + " SET rex_name=?, rex_range=?, hub_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM ajax_curr.rex WHERE id=?";
    static final Logger LOGGER = LoggerFactory.getLogger(RexDAO.class);

    @Override
    public List<Rex> findAll() throws SQLException {
        List<Rex> rexes = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Rex rex = new Rex(
                        resultSet.getInt("id"),
                        resultSet.getString("rex_name"),
                        resultSet.getString("rex_range"),
                        resultSet.getInt("hub_id")
                );
                rexes.add(rex);
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Ops! ", e);
        }
        return rexes;
    }

    @Override
    public Rex findById(Integer id) throws SQLException {
        Rex rex = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            LOGGER.info(String.valueOf(statement));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rex = new Rex(
                        resultSet.getInt("id"),
                        resultSet.getString("rex_name"),
                        resultSet.getString("rex_range"),
                        resultSet.getInt("hub_id")
                );
            }
            resultSet.close();
        } catch (Exception e) {
            LOGGER.error("Oops!", e);
        }
        return rex;
    }

    @Override
    public void create(Rex rex) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, rex.getRexName());
            statement.setString(2, rex.getRexRange());
            statement.setInt(3, rex.getHubId());
            statement.executeUpdate();
            LOGGER.info(String.valueOf(statement));
        } catch (Exception e) {
            LOGGER.error("Ops!", e);
        }

    }

    @Override
    public void update(Integer id, Rex rex) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, rex.getRexName());
            statement.setString(2, rex.getRexRange());
            statement.setInt(3, rex.getHubId());
            statement.setInt(4, rex.getId());
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
