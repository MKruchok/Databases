USE pharmacy_db;

SET GLOBAL log_bin_trust_function_creators = 1;
-- Task №1 для employee шукати AVG стовпця experience.

DROP FUNCTION IF EXISTS get_avg_working_experience;
DELIMITER //
CREATE FUNCTION get_avg_working_experience()
    RETURNS DECIMAL(10, 1)
BEGIN
    RETURN (SELECT AVG(experience)
            FROM employee);
END //
DELIMITER ;

# SELECT name, experience
# FROM employee where experience > get_avg_working_experience();

-- Task №2 витягує за ключем між street та pharmacy значення поля street.name . 
DROP FUNCTION IF EXISTS get_street_name;
DELIMITER //
CREATE FUNCTION get_street_name(
    pharmacy_id INT
)
    RETURNS VARCHAR(45)
BEGIN
    RETURN (SELECT name
            FROM street
            WHERE id = (SELECT street_id FROM pharmacy WHERE id = pharmacy_id));
END //
DELIMITER ;

# select *, get_street_name(pharmacy.id) as street_name from pharmacy;
