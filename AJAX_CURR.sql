SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


DROP SCHEMA IF EXISTS `AJAX_CURR` ;
CREATE SCHEMA IF NOT EXISTS `AJAX_CURR` DEFAULT CHARACTER SET utf8 ;
USE `AJAX_CURR` ;


DROP TABLE IF EXISTS `AJAX_CURR`.`hub` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`hub` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL DEFAULT 'hub',
  `status` VARCHAR(45) NOT NULL DEFAULT 'offline',
  `service_life_end_time` DATETIME NULL DEFAULT (CURRENT_DATE + INTERVAL 10 YEAR),
  `warranty_end_time` DATETIME NULL DEFAULT (CURRENT_DATE + INTERVAL 2 YEAR),
  `users_max` INT NULL DEFAULT 50,
  `rooms_max` INT NULL DEFAULT 50,
  `devices_max` INT NULL DEFAULT 100,
  `sirens_max` INT NULL DEFAULT 10,
  `on_battery` BIT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (1,'hub_plus','online',(CURRENT_DATE + INTERVAL 15 YEAR),(CURRENT_DATE + INTERVAL 5 YEAR),99,50,150,10,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (2,'hub','offline',default,default,default,default,100,10,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (3,'hub2_2g','online',default,default,default,default,150,20,1);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (4,'hub2_4g','online',default,default,150,default,150,20,1);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (5,'hub2_4g','online',default,default,150,default,150,20,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (6,'hub2_plus','online',default,default,200,default,200,20,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (7,'hub2_2g','online',default,default,default,default,150,20,1);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (8,'hub','offline',default,default,default,default,100,10,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (9,'hub2_4g','online',default,default,150,default,150,20,0);
INSERT INTO `AJAX_CURR`.`hub` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`users_max`,`rooms_max`,`devices_max`,`sirens_max`,`on_battery`)
VALUES (10,'hub_plus','online',(CURRENT_DATE + INTERVAL 20 YEAR),(CURRENT_DATE + INTERVAL 10 YEAR),99,50,150,10,0);


DROP TABLE IF EXISTS `AJAX_CURR`.`device` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`device` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `status` VARCHAR(45) NOT NULL DEFAULT 'offline',
  `service_life_end_time` DATETIME NULL DEFAULT (CURRENT_DATE + INTERVAL 10 YEAR),
  `warranty_end_time` DATETIME NULL DEFAULT (CURRENT_DATE + INTERVAL 2 YEAR),
  `on_battery` BIT NULL DEFAULT 0,
  `hub_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_device_hub_idx` (`hub_id` ASC) VISIBLE)
ENGINE = MyISAM;

INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (1,'motion_cam','online',default,default,1,1);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (2,'motion_protect','online',default,default,1,2);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (3,'motion_protect_plus','online',(CURRENT_DATE + INTERVAL 20 YEAR),(CURRENT_DATE + INTERVAL 10 YEAR),0,2);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (4,'combi_protect','online',default,default,0,2);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (5,'motion_protect_curtain','offline',default,default,1,4);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (6,'door_protect','online',default,default,1,5);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (7,'glass_protect','online',default,default,1,6);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (8,'dual_curtain_outdoor','online',(CURRENT_DATE + INTERVAL 18 YEAR),(CURRENT_DATE + INTERVAL 10 YEAR),1,6);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (9,'glass_protect','offline',default,default,1,6);
INSERT INTO `AJAX_CURR`.`device` (`id`,`model`,`status`,`service_life_end_time`,`warranty_end_time`,`on_battery`,`hub_id`)
VALUES (10,'leaks_protect','online',default,default,1,8);


DROP TABLE IF EXISTS `AJAX_CURR`.`notification` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timestamp` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` VARCHAR(45) NOT NULL DEFAULT 'warning',
  `device_id` INT NULL,
  `hub_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notification_device1_idx` (`device_id` ASC) VISIBLE,
  INDEX `fk_notification_hub1_idx` (`hub_id` ASC) VISIBLE,
  CONSTRAINT `fk_notification_device1`
    FOREIGN KEY (`device_id`)
    REFERENCES `AJAX_CURR`.`device` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_hub1`
    FOREIGN KEY (`hub_id`)
    REFERENCES `AJAX_CURR`.`hub` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (1,'warning',NULL,8);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (2,'alert',1,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (3,'low_battery',2,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (4,'door_opened',6,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (5,'door_closed',6,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (6,'leak_detected',10,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (7,'suspicious_activity',4,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (8,'alert',4,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (9,'low_battery',8,NULL);
INSERT INTO `AJAX_CURR`.`notification` (`id`,`type`,`device_id`,`hub_id`)
VALUES (10,'low_battery',9,NULL);



DROP TABLE IF EXISTS `AJAX_CURR`.`group` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `description` VARCHAR(150) NULL DEFAULT 'Lorem ipsum',
  `hub_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_group_hub1_idx` (`hub_id` ASC) VISIBLE,
  CONSTRAINT `fk_group_hub1`
    FOREIGN KEY (`hub_id`)
    REFERENCES `AJAX_CURR`.`hub` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- groups are made by the hub user
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (1,'owners','people who own this hub, have owner privileges',1);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (2,'admins','people who have all posible permissions',1);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (3,'guards','people who can only check devices status',1);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (4,'admins',NULL,3);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (5,'guarding','check devices status',2);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (6,'home',NULL,4);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (7,'random',NULL,4);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (8,'owners','owners of this hub',7);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (9,'children','owners of this hub',7);
INSERT INTO `AJAX_CURR`.`group` (`id`,`name`,`description`,`hub_id`)
VALUES (10,'admins','all posible permissions',8);


DROP TABLE IF EXISTS `AJAX_CURR`.`user` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL DEFAULT 'somemail@lolbit.com',
  `password` VARCHAR(45) NOT NULL DEFAULT 'admin',
  `date_created` DATETIME NOT NULL DEFAULT (CURRENT_DATE),
  `name` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `group_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_user_group1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `AJAX_CURR`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`user` (`id`,`email`,`password`,`date_created`,`name`,`group_id`)
VALUES
  (1,"sit.amet.risus@aol.couk","CXY46CKU5LF","2021-10-26 12:15:35","Adrian",7),
  (2,"tristique.pellentesque.tellus@hotmail.net","FLD22VJW7LP","2022-04-8 10:50:14","Oprah",7),
  (3,"at.iaculis@google.net","RSL21QLS2YI","2022-07-9 10:05:04","John",0),
  (4,"enim.consequat@protonmail.ca","PUP58PPI6UG","2021-12-21 05:08:33","Flynn",7),
  (5,"ac.mattis@protonmail.ca","XIP05FJS3AK","2022-03-16 07:39:47","Ila",1),
  (6,"nam.consequat.dolor@protonmail.ca","ZWW48EZV4AV","2023-02-3 10:39:57","Chantale",4),
  (7,"turpis@yahoo.net","DDS68LMQ8DY","2023-02-18 07:22:40","Aurora",6),
  (8,"egestas.urna@hotmail.net","CTV39QYI4NV","2022-10-2 11:55:40","Elliott",4),
  (9,"velit.eget@protonmail.net","OJG06TKO7NN","2022-01-5 10:02:07","Wilma",5),
  (10,"consectetuer@yahoo.org","NLN85RUU2CS","2021-11-25 03:26:39","Drake",10);


DROP TABLE IF EXISTS `AJAX_CURR`.`user_has_hub` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`user_has_hub` (
  `user_id` INT NOT NULL,
  `hub_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `hub_id`),
  INDEX `fk_user_has_hub_hub1_idx` (`hub_id` ASC) VISIBLE,
  INDEX `fk_user_has_hub_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_hub_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `AJAX_CURR`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_hub_hub1`
    FOREIGN KEY (`hub_id`)
    REFERENCES `AJAX_CURR`.`hub` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`user_has_hub` (`user_id`,`hub_id`)
VALUES
  (10,3),
  (7,4),
  (8,6),
  (3,5),
  (5,10),
  (1,1),
  (8,3),
  (7,5),
  (6,3),
  (1,10);


DROP TABLE IF EXISTS `AJAX_CURR`.`permission` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`permission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`permission` (`id`,`name`,`description`)
VALUES
  (1,"root_access","Get root access"),
  (2,"create","add devices to the system"),
  (4,"read","read current status of devices"),
  (5,"update","edit properties of devices"),
  (6,"delete","remove devices from the system");


DROP TABLE IF EXISTS `AJAX_CURR`.`group_has_permission` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`group_has_permission` (
  `group_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`group_id`, `permission_id`),
  INDEX `fk_group_has_permission_permission1_idx` (`permission_id` ASC) VISIBLE,
  INDEX `fk_group_has_permission_group1_idx` (`group_id` ASC) VISIBLE,
  CONSTRAINT `fk_group_has_permission_group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `AJAX_CURR`.`group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_group_has_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `AJAX_CURR`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`group_has_permission` (`group_id`,`permission_id`)
VALUES
  (7,2),
  (2,2),
  (8,5),
  (5,2),
  (6,4),
  (7,3),
  (5,5),
  (9,2),
  (6,3),
  (8,4);

DROP TABLE IF EXISTS `AJAX_CURR`.`user_has_permission` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`user_has_permission` (
  `user_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `permission_id`),
  INDEX `fk_user_has_permission_permission1_idx` (`permission_id` ASC) VISIBLE,
  INDEX `fk_user_has_permission_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_permission_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `AJAX_CURR`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `AJAX_CURR`.`permission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`user_has_permission` (`user_id`,`permission_id`)
VALUES
  (2,1),
  (4,1),
  (7,5),
  (7,4),
  (8,1),
  (5,5),
  (9,1),
  (5,4),
  (7,2),
  (5,1);

DROP TABLE IF EXISTS `AJAX_CURR`.`rex` ;

CREATE TABLE IF NOT EXISTS `AJAX_CURR`.`rex` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `range` VARCHAR(45) NOT NULL DEFAULT 'undefined',
  `hub_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rex_hub1_idx` (`hub_id` ASC) VISIBLE,
  CONSTRAINT `fk_rex_hub1`
    FOREIGN KEY (`hub_id`)
    REFERENCES `AJAX_CURR`.`hub` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `AJAX_CURR`.`rex` (`id`,`name`,`range`,`hub_id`)
VALUES
  (1,"rex",1700,2),
  (2,"rex",1600,4),
  (3,"rex",1400,8),
  (4,"rex2",1800,2),
  (5,"rex2",1700,7),
  (6,"rex2",1600,7),
  (7,"rex",1400,6),
  (8,"rex",1800,4),
  (9,"rex",1700,8),
  (10,"rex2",1600,8);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
