package com.mkruchok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    LOGGER.info("Test logger message.");
  }
}
