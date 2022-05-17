package com.mkruchok.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Menu {
    static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);

    public void displayMenu() {
        LOGGER.debug("\n _________________________________________________\n" +
                "|                                                 |\n" +
                "|         Enter entity and CRUD number :          |\n" +
                "|                                                 |\n" +
                "|         Table:                  CRUD:           |\n" +
                "|_________________________________________________|\n" +
                "| 1 | user             | 1 | GET TABLE            |\n" +
                "| 2 | hub              | 2 | GET ROW BY ID        |\n" +
                "| 3 | device           | 3 | CREATE ROW           |\n" +
                "| 4 | notification     | 4 | UPDATE ROW           |\n" +
                "| 5 | group            | 5 | DELETE ROW           |\n" +
                "| 6 | permission       |   |                      |\n" +
                "| 7 | rex              |   |                      |\n" +
                "|___|__________________|___|______________________|\n" +
                "Enter numbers:"

        );
    }
}
