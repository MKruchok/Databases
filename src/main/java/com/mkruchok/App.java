package com.mkruchok;

import com.mkruchok.view.View;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class App {
  static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  public static void main(final String[] args) {
    System.err.close();
    System.setErr(System.out);
    try (Session ignored = HibernateUtil.getSession()) {
      LOGGER.info("Test session established. ");
      new View().show();
    } catch (Exception ex) {
      LOGGER.warn("Test session failed.");
      LOGGER.error(ex.toString());
    }
  }
}