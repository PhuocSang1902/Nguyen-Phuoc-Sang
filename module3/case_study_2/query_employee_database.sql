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