package com.mkruchok;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
  static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
  private static final SessionFactory SESSION_FACTORY;

  static {
    try {
      SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    } catch (Exception ex) {
      LOGGER.warn("SessionFactory init failed.");
      LOGGER.error(ex.toString());
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }

  public static Session getSession() {
    return SESSION_FACTORY.openSession();
  }
}
