-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ajax
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ajax
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ajax` DEFAULT CHARACTER SET utf8 ;
USE `ajax` ;

-- -----------------------------------------------------
-- Table `ajax`.`object`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`object` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `access_level` INT NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`zone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`zone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `access_level` INT NULL DEFAULT NULL,
  `object_id` INT NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_zone_object1_idx` (`object_id` ASC) VISIBLE,
  CONSTRAINT `fk_zone_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `ajax`.`object` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`corridor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`corridor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `zone_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_corridor_zone1_idx` (`zone_id` ASC) VISIBLE,
  CONSTRAINT `fk_corridor_zone1`
    FOREIGN KEY (`zone_id`)
    REFERENCES `ajax`.`zone` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `zone_id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_zone1_idx` (`zone_id` ASC) VISIBLE,
  CONSTRAINT `fk_room_zone1`
    FOREIGN KEY (`zone_id`)
    REFERENCES `ajax`.`zone` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`sensor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`sensor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(30) NULL DEFAULT 'Activated',
  `type` VARCHAR(30) NOT NULL,
  `room_id` INT NULL,
  `corridor_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sensor_room1_idx` (`room_id` ASC) VISIBLE,
  INDEX `fk_sensor_corridor1_idx` (`corridor_id` ASC) VISIBLE,
  CONSTRAINT `fk_sensor_corridor1`
    FOREIGN KEY (`corridor_id`)
    REFERENCES `ajax`.`corridor` (`id`),
  CONSTRAINT `fk_sensor_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `ajax`.`room` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(45) NULL DEFAULT NULL,
  `sensor_id` INT NOT NULL,
  INDEX `fk_notification_sensor1_idx` (`sensor_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_notification_sensor1`
    FOREIGN KEY (`sensor_id`)
    REFERENCES `ajax`.`sensor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(30) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `access_level` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ajax`.`object_has_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ajax`.`object_has_user` (
  `object_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`object_id`, `user_id`),
  INDEX `fk_object_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_object_has_user_object1_idx` (`object_id` ASC) VISIBLE,
  CONSTRAINT `fk_object_has_user_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `ajax`.`object` (`id`),
  CONSTRAINT `fk_object_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ajax`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
