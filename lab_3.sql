CREATE SCHEMA IF NOT EXISTS `ajax_new` DEFAULT CHARACTER SET utf8 ;
USE `ajax_new`;

DROP TABLE IF EXISTS `object_has_user`;
DROP TABLE IF EXISTS `object_has_zone`;
DROP TABLE IF EXISTS `room_has_sensor`;
DROP TABLE IF EXISTS `corridor_has_sensor`;
DROP TABLE IF EXISTS `sensor_has_notification`;
DROP TABLE IF EXISTS `room`;
DROP TABLE IF EXISTS `corridor`;
DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `sensor`;
DROP TABLE IF EXISTS `zone`;
DROP TABLE IF EXISTS `object`;
DROP TABLE IF EXISTS `user`;


CREATE TABLE IF NOT EXISTS `object` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `access_level` INT NULL DEFAULT NULL,
  `name` VARCHAR(45) NOT NULL,
  `area_m2` INT NULL DEFAULT NULL,
  `buildings` INT NULL DEFAULT NULL,
  `priority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `zone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `access_level` INT NULL DEFAULT NULL,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS `corridor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `area_m2` INT NULL DEFAULT NULL,
  `floor` INT NULL DEFAULT NULL,
  `object_id` INT NOT NULL,
  `zone_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_corridor_object1_idx` (`object_id` ASC) VISIBLE,
  INDEX `fk_corridor_zone1_idx` (`zone_id` ASC) VISIBLE,
  CONSTRAINT `fk_corridor_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `object` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_corridor_zone1`
    FOREIGN KEY (`zone_id`)
    REFERENCES `zone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sensor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(30) NOT NULL DEFAULT 'Activated',
  `type` VARCHAR(30) NOT NULL,
  `manufacturer` VARCHAR(45) NULL DEFAULT NULL,
  `days_since_installed` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `corridor_has_sensor` (
  `corridor_id` INT NOT NULL,
  `sensor_id` INT NOT NULL,
  PRIMARY KEY (`corridor_id`, `sensor_id`),
  INDEX `fk_corridor_has_sensor_sensor1_idx` (`sensor_id` ASC) VISIBLE,
  INDEX `fk_corridor_has_sensor_corridor1_idx` (`corridor_id` ASC) VISIBLE,
  CONSTRAINT `fk_corridor_has_sensor_corridor1`
    FOREIGN KEY (`corridor_id`)
    REFERENCES `corridor` (`id`),
  CONSTRAINT `fk_corridor_has_sensor_sensor1`
    FOREIGN KEY (`sensor_id`)
    REFERENCES `sensor` (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(30) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `access_level` INT NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `object_has_user` (
  `object_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`object_id`, `user_id`),
  INDEX `fk_object_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_object_has_user_object1_idx` (`object_id` ASC) VISIBLE,
  CONSTRAINT `fk_object_has_user_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `object` (`id`),
  CONSTRAINT `fk_object_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `object_has_zone` (
  `object_id` INT NOT NULL,
  `zone_id` INT NOT NULL,
  PRIMARY KEY (`object_id`, `zone_id`),
  INDEX `fk_object_has_zone_zone1_idx` (`zone_id` ASC) VISIBLE,
  INDEX `fk_object_has_zone_object1_idx` (`object_id` ASC) VISIBLE,
  CONSTRAINT `fk_object_has_zone_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `object` (`id`),
  CONSTRAINT `fk_object_has_zone_zone1`
    FOREIGN KEY (`zone_id`)
    REFERENCES `zone` (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `area_m2` INT NULL DEFAULT NULL,
  `floor` INT NULL DEFAULT NULL,
  `object_id` INT NOT NULL,
  `zone_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_room_object1_idx` (`object_id` ASC) VISIBLE,
  INDEX `fk_room_zone1_idx` (`zone_id` ASC) VISIBLE,
  CONSTRAINT `fk_room_object1`
    FOREIGN KEY (`object_id`)
    REFERENCES `object` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_room_zone1`
    FOREIGN KEY (`zone_id`)
    REFERENCES `zone` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `room_has_sensor` (
  `room_id` INT NOT NULL,
  `sensor_id` INT NOT NULL,
  PRIMARY KEY (`room_id`, `sensor_id`),
  INDEX `fk_room_has_sensor_sensor1_idx` (`sensor_id` ASC) VISIBLE,
  INDEX `fk_room_has_sensor_room1_idx` (`room_id` ASC) VISIBLE,
  CONSTRAINT `fk_room_has_sensor_room1`
    FOREIGN KEY (`room_id`)
    REFERENCES `room` (`id`),
  CONSTRAINT `fk_room_has_sensor_sensor1`
    FOREIGN KEY (`sensor_id`)
    REFERENCES `sensor` (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(45) NULL DEFAULT NULL,
  `time_happened` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sensor_has_notification` (
  `sensor_id` INT NOT NULL,
  `notification_id` INT NOT NULL,
  PRIMARY KEY (`sensor_id`, `notification_id`),
  INDEX `fk_sensor_has_notification_notification1_idx` (`notification_id` ASC) VISIBLE,
  INDEX `fk_sensor_has_notification_sensor1_idx` (`sensor_id` ASC) VISIBLE,
  CONSTRAINT `fk_sensor_has_notification_sensor1`
    FOREIGN KEY (`sensor_id`)
    REFERENCES `ajax_new`.`sensor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sensor_has_notification_notification1`
    FOREIGN KEY (`notification_id`)
    REFERENCES `ajax_new`.`notification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `object` (`access_level`, `name`, `area_m2`, `buildings`, `priority`) VALUES (5,'SoftServe',1876,4,5);
INSERT INTO `object` (`access_level`, `name`, `area_m2`, `buildings`, `priority`) VALUES (1,'Storage',50,1,1);
INSERT INTO `object` (`access_level`, `name`, `area_m2`, `buildings`, `priority`) VALUES (0,'Park',3968,0,1);
INSERT INTO `object` (`access_level`, `name`, `area_m2`, `buildings`, `priority`) VALUES (1,'Parking',500,1,2);
INSERT INTO `object` (`access_level`, `name`, `area_m2`, `buildings`, `priority`) VALUES (2,'Parus Building',2456,1,2);


INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Hudson','Katy',0,'civilian');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Zakharenko','Natalia',0,'civilian');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Konigsberg','Allen',1,'worker');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Wilde','Olivia',1,'worker');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('George','Michael',3,'security guard');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Hulk','Hogan',3,'security guard');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Rock','Hudson',3,'security guard');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Costello','Elvis',3,'security guard');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Micklewhite','Maurice',2,'ad manager');
INSERT INTO `user` (`surname`, `name`, `access_level`, `role`) VALUES ('Einstein','Albert',3,'engineer');


INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (1,10);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (1,9);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (1,8);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (1,7);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (2,3);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (2,4);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (3,4);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (4,1);
INSERT INTO `object_has_user` (`object_id`, `user_id`) VALUES (5,2);


INSERT INTO `zone` (`access_level`, `name`) VALUES (0,'Public zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (1,'Main workers zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (3,'Servers zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (4,'Top management zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (0,'Public Parking zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (0,'Park zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (3,'Security zone');
INSERT INTO `zone` (`access_level`, `name`) VALUES (1,'Paid parking zone');


INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (1,1);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (1,2);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (1,3);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (1,4);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (2,2);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (3,1);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (3,6);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (4,5);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (4,8);
INSERT INTO `object_has_zone` (`object_id`, `zone_id`) VALUES (5,1);


INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Main hall',100,1,1,1);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Business room',35,8,1,4);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Parts and service',20,-1,2,1);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Apartments 23',50,2,5,1);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Apartments 34',45,3,5,1);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Apartments 45',40,4,5,1);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Execution room 1',30,2,1,2);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Execution room 2',30,2,1,2);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Execution room 3',30,2,1,2);
INSERT INTO `room` (`name`, `area_m2`, `floor`, `object_id`, `zone_id`) VALUES ('Server room',50,2,1,3);


INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (21,1,1,1);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (25,3,1,3);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (10,3,1,3);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (30,2,2,2);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (43,4,2,2);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (34,3,5,1);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (34,6,5,1);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (54,4,5,1);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (12,5,5,1);
INSERT INTO `corridor` (`area_m2`, `floor`, `object_id`, `zone_id`) VALUES (13,8,5,1);


INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',15);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Overheat sensor','NVidia',367);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Proximity sensor','Dell',45);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('DISABLED','Proximity sensor','Dell',762);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('DISABLED','Proximity sensor','Dell',562);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',58);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Overheat sensor','NVidia',23);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Security camera','Asus',238);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Security camera','Asus',129);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Security camera','Asus',123);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Proximity sensor','Dellorian',258);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Proximity sensor','Dellorian',15);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('DISABLED','Proximity sensor','Dellorian',345);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',0);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('DISABLED','Smoke detector','Sony',165);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',34);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',35);
INSERT INTO `sensor` (`status`, `type`, `manufacturer`, `days_since_installed`) VALUES ('ACTIVE','Smoke detector','Sony',36);


INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (10,1);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (10,2);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (10,8);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (10,9);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (1,10);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (1,4);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (1,3);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (3,6);
INSERT INTO `room_has_sensor` (`room_id`, `sensor_id`) VALUES (3,5);


INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (1,11);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (2,12);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (2,13);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (4,14);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (4,15);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (7,16);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (8,17);
INSERT INTO `corridor_has_sensor` (`corridor_id`, `sensor_id`) VALUES (9,18);


INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-25 15:32:06' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-25 15:38:06' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Overheat detected',CAST('2021-09-25 21:38:06' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Overheat detected',CAST('2021-09-25 21:39:03' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-26 04:39:03' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-26 04:40:23' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-26 04:41:45' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Smoke detected',CAST('2021-09-26 04:51:45' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Smoke detected',CAST('2021-09-26 04:52:34' AS DateTime));
INSERT INTO `notification` (`message`, `time_happened`) VALUES ('Movement detected',CAST('2021-09-26 04:51:45' AS DateTime));


INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (3,1);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (3,2);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (2,3);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (7,4);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (8,5);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (10,7);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (6,8);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (6,9);
INSERT INTO `sensor_has_notification` (`sensor_id`, `notification_id`) VALUES (10,10);
