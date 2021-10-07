INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (1,'Kruchok','Mark',1);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (2,'Koval','Rostyslav',NULL);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (3,'Hatak','Danylo',3);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (4,'Kovalets','Nastya',NULL);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (5,'Dom','Dom',4);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (6,'Marley','Marley',NULL);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (7,'Antony','Pit',2);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (8,'Mokey','Sniper',NULL);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (9,'Ruffalo','Mark',3);
INSERT INTO `ajax`.`user` (`id`,`surname`,`name`,`access_level`) VALUES (10,'Vasiliev','Stas',1);

INSERT INTO `ajax`.`object` (`id`,`access_level`,`name`) VALUES (1,1,'office');

INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,1);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,2);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,3);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,4);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,5);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,6);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,7);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,8);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,9);
INSERT INTO `ajax`.`object_has_user` (`object_id`,`user_id`) VALUES (1,10);

INSERT INTO `ajax`.`zone` (`id`,`access_level`,`object_id`,`name`) VALUES (1,NULL,1,'public_rooms');
INSERT INTO `ajax`.`zone` (`id`,`access_level`,`object_id`,`name`) VALUES (2,1,1,'regular_offices');
INSERT INTO `ajax`.`zone` (`id`,`access_level`,`object_id`,`name`) VALUES (3,2,1,'roof');
INSERT INTO `ajax`.`zone` (`id`,`access_level`,`object_id`,`name`) VALUES (4,3,1,'administration_only');
INSERT INTO `ajax`.`zone` (`id`,`access_level`,`object_id`,`name`) VALUES (5,4,1,'server_room');

INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (1,1);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (2,1);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (3,1);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (4,2);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (5,2);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (6,2);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (7,3);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (8,4);
INSERT INTO `ajax`.`corridor` (`id`,`zone_id`) VALUES (9,5);

INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (1,1,'hall');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (2,1,'main_entrance');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (3,1,'elevator');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (4,1,'cafe');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (5,2,'first_floor');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (6,2,'second_floor');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (7,2,'third_floor');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (8,4,'admin_office');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (9,5,'server_room');
INSERT INTO `ajax`.`room` (`id`,`zone_id`,`name`) VALUES (10,3,'roof');

INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (1,'active','motion_detector',9,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (2,'active','motion_detector',9,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (3,'inactive','camera',3,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (4,'active','gas_leak_detector',8,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (5,'active','fire_detector',NULL,9);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (6,'active','fingerprint_lock',8,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (7,'active','camera',1,NULL);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (8,'active','camera',NULL,8);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (9,'inactive','camera',NULL,9);
INSERT INTO `ajax`.`sensor` (`id`,`status`,`type`,`room_id`,`corridor_id`) VALUES (10,'active','motion_detector',NULL,9);

INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (1,'camera inactive, please reboot',3);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (2,'camera inactive, please reboot',9);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (3,'FIRE DETECTED',5);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (4,'FIRE DETECTED',5);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (5,'UNATHORIZED ACCESS',6);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (6,'UNATHORIZED ACCESS',6);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (7,'UNATHORIZED MOVEMENT',10);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (8,'UNATHORIZED MOVEMENT',1);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (9,'UNATHORIZED MOVEMENT',2);
INSERT INTO `ajax`.`notification` (`id`,`message`,`sensor_id`) VALUES (10,'GAS LEAK DETECTED',4);