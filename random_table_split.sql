# create two more tables from existent one, with one to one relationship
#     where columns are randomly picked from parent table.
DROP PROCEDURE IF EXISTS table3_split;
DELIMITER //
CREATE PROCEDURE table3_split()
BEGIN
    DECLARE done BOOL DEFAULT FALSE;
    DECLARE num INT DEFAULT (0);
    DECLARE table3_names VARCHAR(10);
    DECLARE name_cursor CURSOR
        FOR SELECT COLUMN_NAME
        FROM INFORMATION_SCHEMA.COLUMNS
        WHERE TABLE_NAME = 'laptop'; #any table name, in this database table3 not exist
    DECLARE CONTINUE HANDLER
        FOR NOT FOUND SET done = TRUE;
    open name_cursor;
    names_loop:
    LOOP
        FETCH name_cursor INTO table3_names;
        IF done THEN
            LEAVE names_loop;
        END IF;
        SET @new_table4 =
                'CREATE TABLE IF NOT EXISTS table4
                ( id INT NOT NULL AUTO_INCREMENT, PRIMARY KEY(id));';
        SELECT @new_table4;
        PREPARE new_table_query FROM @new_table4;
        EXECUTE new_table_query;
        SET @new_table5 =
                'CREATE TABLE IF NOT EXISTS table5 ( id INT NOT NULL AUTO_INCREMENT,
                `table4` INT NOT NULL,
                PRIMARY KEY(id, table4),
                INDEX `fk_table4_idx` (`table4` ASC) VISIBLE,
                CONSTRAINT `fk_table4`
                FOREIGN KEY (`table4`)
                REFERENCES `Lab_2_SQL`.`table4` (`id`));';
        SELECT @new_table5;
        PREPARE new_table_query FROM @new_table5;
        EXECUTE new_table_query;
        SET num = rand();
        IF num < 0.50 THEN
            SET @insert_table4 =
                CONCAT('ALTER TABLE table4 ADD COLUMN ', table3_names, ' VARCHAR(50);');
            SELECT @insert_table4;
            PREPARE new_table_query FROM @insert_table4;
            EXECUTE new_table_query;
        END IF;
        IF num > 0.50 THEN
            SET @insert_table5 =
                    CONCAT('ALTER TABLE table5 ADD COLUMN ', table3_names, ' VARCHAR(50);');
            SELECT @insert_table5;
            PREPARE new_table_query FROM @insert_table5;
            EXECUTE new_table_query;
        END IF;
    END LOOP;
    CLOSE name_cursor;
END //
DELIMITER ;

DROP TABLE IF EXISTS table5;
DROP TABLE IF EXISTS table4;
call table3_split()
