package com.mkruchok.persistent;

import java.sql.Connection;
import java.sql.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class ConnectionManager {
  static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManager.class);
  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String DATABASE_URL =
      "jdbc:mysql://localhost:3306/ajax_curr?useUnicode=true&serverTimezone=UTC";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "admin";
  private static Connection databaseConnection;

  public ConnectionManager() {
  }

  public static Connection getConnection() {
    try {
      Class.forName(JDBC_DRIVER);
      if (databaseConnection == null || databaseConnection.isClosed()) {
        try {
          databaseConnection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
          LOGGER.error("Ops!", e);
        }
      }
    } catch (Exception e) {
      LOGGER.error("Ops!", e);
    }
    return databaseConnection;
  }

}
