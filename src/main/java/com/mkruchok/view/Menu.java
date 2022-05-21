package com.mkruchok.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Menu {
  static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

  public void displayMenu() {
    LOGGER.debug(" _________________________________________________");
    LOGGER.debug("|                                                 |");
    LOGGER.debug("|         Enter entity and CRUD number :          |");
    LOGGER.debug("|                                                 |");
    LOGGER.debug("|         Table:                  CRUD:           |");
    LOGGER.debug("|_________________________________________________|");
    LOGGER.debug("| 1 | user             | 1 | GET TABLE            |");
    LOGGER.debug("| 2 | hub              | 2 | GET ROW BY ID        |");
    LOGGER.debug("| 3 | device           | 3 | CREATE ROW           |");
    LOGGER.debug("| 4 | notification     | 4 | UPDATE ROW           |");
    LOGGER.debug("| 5 | group            | 5 | DELETE ROW           |");
    LOGGER.debug("| 6 | permission       |   |                      |");
    LOGGER.debug("| 7 | rex              |   |                      |");
    LOGGER.debug("|___|__________________|___|______________________|");
  }
}
