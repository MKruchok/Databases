USE pharmacy_db;
-- №1: забезпечити цілісність даних.


-- POST
DROP TRIGGER IF EXISTS post_update;

DELIMITER //
CREATE TRIGGER post_update
    BEFORE UPDATE
    ON post
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT post_id FROM employee)) THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'cannot change linked entities';
    END IF;
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS post_delete;
DELIMITER //
CREATE TRIGGER post_delete
    BEFORE DELETE
    ON post
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT post_id FROM employee)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
END //
DELIMITER ;


-- EFFECT ZONE


DROP TRIGGER IF EXISTS effect_zone_update;
DELIMITER //
CREATE TRIGGER effect_zone_update
    BEFORE UPDATE
    ON effect_zone
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT zone_id FROM medicine_zone)) THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'cannot change linked entities';
    END IF;
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;
END //
DELIMITER ;
# UPDATE effect_zone SET id = 16,name = 'Jojo' WHERE id = 3;

DROP TRIGGER IF EXISTS effect_zone_delete;
DELIMITER //
CREATE TRIGGER effect_zone_delete
    BEFORE DELETE
    ON effect_zone
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT zone_id FROM medicine_zone)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
END //
DELIMITER ;

-- STREET
DROP TRIGGER IF EXISTS street_update;
DELIMITER //
CREATE TRIGGER street_update
    BEFORE UPDATE
    ON street
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT street_id FROM pharmacy)) THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'cannot change linked entities';
    END IF;
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS street_delete;
DELIMITER //
CREATE TRIGGER street_delete
    BEFORE DELETE
    ON street
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT street_id FROM pharmacy)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
END //
DELIMITER ;


-- MEDICINE LIST
DROP TRIGGER IF EXISTS medicine_update;
DELIMITER //
CREATE TRIGGER medicine_update
    BEFORE UPDATE
    ON medicine_list
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT medicine_id FROM medicine_zone)
        OR old.id IN (SELECT medicine_id FROM pharmaсy_has_medicine)) THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'cannot change linked entities';
    END IF;
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;


END //
DELIMITER ;


DROP TRIGGER IF EXISTS medicine_delete;
DELIMITER //
CREATE TRIGGER medicine_delete
    BEFORE DELETE
    ON medicine_list
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT medicine_id FROM medicine_zone)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
    IF (old.id IN (SELECT medicine_id FROM pharmaсy_has_medicine)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
END //
DELIMITER ;


-- Employee
DROP TRIGGER IF EXISTS employee_insert;

DELIMITER //
CREATE TRIGGER employee_insert
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF (new.post_id NOT IN (SELECT id FROM post)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
    IF (new.pharmacy_id NOT IN (SELECT id FROM pharmacy)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
END//
DELIMITER ;

DROP TRIGGER IF EXISTS employee_update;

DELIMITER //
CREATE TRIGGER employee_update
    BEFORE UPDATE
    ON employee
    FOR EACH ROW
BEGIN
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;
END//
DELIMITER ;


-- Pharmacy

DROP TRIGGER IF EXISTS pharmacy_insert;

DELIMITER //
CREATE TRIGGER pharmacy_insert
    BEFORE INSERT
    ON pharmacy
    FOR EACH ROW
BEGIN
    IF (new.street_id NOT IN (SELECT id FROM street)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;

END//
DELIMITER ;

DROP TRIGGER IF EXISTS pharmacy_update;
DELIMITER //
CREATE TRIGGER pharmacy_update
    BEFORE UPDATE
    ON pharmacy
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT pharmacy_id FROM employee)
            OR old.id IN (SELECT pharmacy_id FROM pharmaсy_has_medicine)) THEN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'cannot change linked entities';
    END IF;
    IF (new.id != old.id) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'id is not same';
    END IF;
END//
DELIMITER ;

DROP TRIGGER IF EXISTS pharmacy_delete;
DELIMITER //
CREATE TRIGGER pharmacy_delete
    BEFORE DELETE
    ON pharmacy
    FOR EACH ROW
BEGIN
    IF (old.id IN (SELECT pharmacy_id FROM pharmaсy_has_medicine)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'there is at least one person with such data, you cannot delete it';
    END IF;
END //
DELIMITER ;

-- Medicine ZONE

DROP TRIGGER IF EXISTS medicine_zone_insert;
DELIMITER //
CREATE TRIGGER medicine_zone_insert
    BEFORE INSERT
    ON medicine_zone
    FOR EACH ROW
BEGIN
    IF (new.medicine_id NOT IN (SELECT id FROM medicine_list)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
    IF (new.zone_id NOT IN (SELECT id FROM effect_zone)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
END
// DELIMITER ;

DROP TRIGGER IF EXISTS medicine_zone_update;
DELIMITER //
CREATE TRIGGER medicine_zone_update
    BEFORE UPDATE
    ON medicine_zone
    FOR EACH ROW
BEGIN
    IF (new.medicine_id NOT IN (SELECT id FROM medicine_list)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'no such medicine_list found';
    END IF;
    IF (new.zone_id NOT IN (SELECT id FROM effect_zone)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'no such new effect_zone found';
    END IF;

END
// DELIMITER ;
# UPDATE medicine_zone SET medicine_id = 110, zone_id = 6 WHERE medicine_id = 7 AND zone_id = 2;

-- pharmacy has medicine

DROP TRIGGER IF EXISTS pharmacy_has_medicine_insert;
DELIMITER //
CREATE TRIGGER pharmacy_has_medicine_insert
    BEFORE INSERT
    ON pharmaсy_has_medicine
    FOR EACH ROW
BEGIN
    IF (new.medicine_id NOT IN (SELECT id FROM medicine_list)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
    IF (new.pharmacy_id NOT IN (SELECT id FROM pharmacy)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'FK error. no such data found';
    END IF;
END
// DELIMITER ;

DROP TRIGGER IF EXISTS pharmacy_has_medicine_update;
DELIMITER //
CREATE TRIGGER pharmacy_has_medicine_update
    BEFORE UPDATE
    ON pharmaсy_has_medicine
    FOR EACH ROW
BEGIN
    IF (new.pharmacy_id NOT IN (SELECT id FROM pharmacy)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'no such link in the linking table';
    END IF;
    IF (new.medicine_id NOT IN (SELECT id FROM medicine_list)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'no such link in the linking table';
    END IF;
END
// DELIMITER ;

-- 2.
DROP TRIGGER IF EXISTS passport_data_format;
DELIMITER //
CREATE TRIGGER passport_data_format
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF (new.passport_data NOT RLIKE '[a-zA-Z]{2} [0-9]{6}') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'passport data does not match provided pattern!';
    END IF;
END
//
DELIMITER ;

-- 3.
DROP TRIGGER IF EXISTS name_format;
DELIMITER //
CREATE TRIGGER name_format
    BEFORE INSERT
    ON employee
    FOR EACH ROW
BEGIN
    IF (new.name NOT RLIKE 'Василь|Іван|Галина|Олександра') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'name does not match provided pattern!';
    END IF;
END
//
DELIMITER ;


-- 4.
DROP TRIGGER IF EXISTS ban_delete_on_street;
DELIMITER //
CREATE TRIGGER ban_delete_on_street
    BEFORE DELETE
    ON street
    FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'you cannot delete data on this table!';
END //
DELIMITER ;

# DELETE street from street where id = 9;
