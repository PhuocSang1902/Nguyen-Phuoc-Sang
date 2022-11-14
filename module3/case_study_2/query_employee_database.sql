DELIMITER //
CREATE PROCEDURE get_employee_by_id(IN id INT)
BEGIN
	SELECT 
		em.*, 
		p.name AS position_name,
		e.name AS education_name,
		d.name AS division_name
	FROM 
		employee em LEFT JOIN position p ON em.position_id = p.id
					LEFT JOIN education_degree e ON em.position_id = e.id
                    LEFT JOIN division d ON em.position_id = d.id
	WHERE
		em.id = id;
END//
DELIMITER ;
-- call get_employee_by_id(2);
DELIMITER //
CREATE PROCEDURE get_employee_list()
BEGIN
	SELECT 
		em.*, 
		p.name AS position_name,
		e.name AS education_name,
		d.name AS division_name
	FROM 
		employee em LEFT JOIN position p ON em.position_id = p.id
					LEFT JOIN education_degree e ON em.education_degree_id = e.id
                    LEFT JOIN division d ON em.division_id = d.id;
END//
DELIMITER ;
call get_employee_list();

DELIMITER //
CREATE PROCEDURE delete_employee_by_id(IN id INT)
BEGIN
SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;
DELETE FROM employee WHERE employee.id=id;
SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE search_employee(IN search VARCHAR(50))
BEGIN
SELECT * 
FROM (
	SELECT 
		em.*, 
		p.name AS position_name,
		e.name AS education_name,
		d.name AS division_name
	FROM 
		employee em LEFT JOIN position p ON em.position_id = p.id
					LEFT JOIN education_degree e ON em.position_id = e.id
                    LEFT JOIN division d ON em.position_id = d.id
	) AS x
WHERE x.name LIKE search OR x.address LIKE search;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_employee(IN name VARCHAR(50), date_of_birth DATE, id_card VARCHAR(45), salary DOUBLE, phone_number VARCHAR(45), email VARCHAR(45), address VARCHAR(45), position_id INT, education_degree_id INT, division_id INT)
BEGIN
INSERT INTO employee(name, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id) 
VALUES (name, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id);
END//
DELIMITER ;
-- CALL add_employee(name, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id)

DELIMITER //
CREATE PROCEDURE edit_employee(IN id INT, name VARCHAR(50), date_of_birth DATE, id_card VARCHAR(45), salary DOUBLE, phone_number VARCHAR(45), email VARCHAR(45), address VARCHAR(45), position_id INT, education_degree_id INT, division_id INT)
BEGIN
	UPDATE employee 
	SET 
		employee.name = name, 
		employee.date_of_birth = date_of_birth, 
		employee.id_card = id_card, 
		employee.salary = salary, 
		employee.phone_number =phone_number, 
		employee.email=email,
		employee.address=address,
		employee.position_id=position_id,
		employee.education_degree_id=education_degree_id,
		employee.division_id=division_id
	WHERE
		employee.id = id;
END//
DELIMITER ;
CALL edit_employee(id, name, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, division_id);