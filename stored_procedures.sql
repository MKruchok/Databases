USE pharmacy_db;
-- параметризована вставка в співробітники.
DROP PROCEDURE IF EXISTS insert_into_employee;
DELIMITER //
CREATE PROCEDURE insert_into_employee(
    name VARCHAR(45),
    surname VARCHAR(45),
    middle_name VARCHAR(45),
    identity_number VARCHAR(20),
    passport_data VARCHAR(20),
    experience DECIMAL(10, 1),
    birth_date DATE,
    post_id INT,
    pharmacy_id INT
)
BEGIN
    INSERT INTO employee(name, surname, middle_name, identity_number, passport_data, experience,
                         birth_date, post_id, pharmacy_id)
    VALUES (name, surname, middle_name, identity_number, passport_data, experience, birth_date,
            post_id, pharmacy_id);
END //
DELIMITER ;

# call insert_into_employee('s','d','a','v','a','1','2022-01-01','8','9');
-- 2.
DROP PROCEDURE IF EXISTS insert_street;
DELIMITER //
CREATE PROCEDURE insert_street()
BEGIN
    DECLARE completed_name VARCHAR(10);
    DECLARE sample_name VARCHAR(10) DEFAULT ('Noname');
    DECLARE num INT DEFAULT (0);
    DECLARE i INT DEFAULT (0);
    WHILE i < 10
        DO
            SET num = FLOOR(RAND() * 10);
            WHILE (SELECT name FROM street WHERE name = CONCAT(sample_name, num)) =
                  CONCAT(sample_name, num)
                DO
                    SET num = FLOOR(RAND() * 10);
                END WHILE;
            SET completed_name = CONCAT(sample_name, num);
            INSERT INTO street(name) VALUES (completed_name);
            SET i = i + 1;
        END WHILE;
    SELECT * FROM street;
END //
DELIMITER ;

# call insert_street();
-- 2
DROP PROCEDURE IF EXISTS insert_medicine_zone;
DELIMITER //
CREATE PROCEDURE insert_medicine_zone(
    medicine_id INT,
    zone_id INT
)
BEGIN
    IF (SELECT id FROM medicine_list WHERE id = medicine_id)
        AND (SELECT id FROM effect_zone WHERE id = zone_id)
    THEN
        INSERT INTO medicine_zone(medicine_id, zone_id) VALUES (medicine_id, zone_id);
    END IF;
END //
DELIMITER ;


-- 3 курсор.

DROP PROCEDURE IF EXISTS pharmacy_create_names;
DELIMITER //
CREATE PROCEDURE pharmacy_create_names()
BEGIN
    DECLARE done BOOL DEFAULT FALSE;
    DECLARE newer_name VARCHAR(45);
    DECLARE name_cursor CURSOR
        FOR SELECT name FROM pharmacy;
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = TRUE;
    OPEN name_cursor;
    names_loop:
    LOOP
        FETCH name_cursor INTO newer_name;
        IF done THEN
            LEAVE names_loop;
        END IF;

        SET @new_table =
                'CREATE TABLE IF NOT EXISTS pharmacy_names ( id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45), PRIMARY KEY(id));';
        SELECT @new_table;
        PREPARE new_table_query FROM @new_table;
        EXECUTE new_table_query;
        INSERT INTO pharmacy_names (name) VALUES (newer_name);

    END LOOP;
    CLOSE name_cursor;
END //
DELIMITER ;

# call pharmacy_create_names();
-- 3 курсор

DROP PROCEDURE IF EXISTS employee_create_db;
DELIMITER //
CREATE PROCEDURE employee_create_db()
BEGIN
    DECLARE done BOOL DEFAULT FALSE;
    DECLARE new_name VARCHAR(45);
    DECLARE new_surname VARCHAR(45);
    DECLARE surnames CURSOR
        FOR SELECT name, surname FROM employee;
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = TRUE;
    OPEN surnames;
    names_loop:
    LOOP
        FETCH surnames INTO new_name, new_surname;
        IF done THEN
            LEAVE names_loop;
        END IF;

        SET @employee_db := CONCAT('CREATE DATABASE IF NOT EXISTS ', new_name, new_surname, ';');
        PREPARE query FROM @employee_db;
        EXECUTE query;
        SET @table_count := 1;

        WHILE @table_count < RAND() * 4
            DO
                SET @new_table =
                        CONCAT('CREATE TABLE IF NOT EXISTS ', new_name, new_surname, '.', new_name,
                               new_surname, @table_count,
                               '( id INT, name VARCHAR(45), surname VARCHAR(45));');
                SELECT @new_table;
                PREPARE new_table_query FROM @new_table;
                EXECUTE new_table_query;
                SET @table_count = @table_count + 1;
            END WHILE;

    END LOOP;
    CLOSE surnames;
END //
DELIMITER ;
