DELIMITER //
CREATE PROCEDURE select_customer()
BEGIN
	SELECT 
		c.*, 
        t.name AS type_customer_name
    FROM 
		customer c LEFT JOIN customer_type t ON c.customer_type_id = t.id
	UNION
		SELECT 
		c.*, 
        t.name AS type_customer_name
    FROM 
		customer c RIGHT JOIN customer_type t ON c.customer_type_id = t.id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_customer_by_id(IN id INT)
BEGIN
	SELECT 
		c.*, 
		t.name AS type_customer_name
	FROM 
		customer c LEFT JOIN customer_type t ON c.customer_type_id = t.id
	WHERE
		c.id = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE edit_customer(IN id INT, customer_type_id INT, name VARCHAR(50), date_of_birth VARCHAR(50), gender BIT, id_card VARCHAR(50), phone_number VARCHAR(50), email VARCHAR(50), address VARCHAR(50))
BEGIN
	UPDATE customer 
	SET 
		customer.customer_type_id = customer_type_id, 
		customer.name = name, 
		customer.date_of_birth = date_of_birth, 
		customer.gender = gender, 
		customer.id_card =id_card, 
		customer.phone_number=phone_number,
		customer.email=email,
		customer.address=address
	WHERE
		customer.id = id;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_by_id(IN id INT)
BEGIN
SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;
DELETE FROM customer WHERE customer.id=id;
SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE add_customer(IN customer_type_id INT, name VARCHAR(50), date_of_birth VARCHAR(50), gender BIT, id_card VARCHAR(50), phone_number VARCHAR(50), email VARCHAR(50), address VARCHAR(50))
BEGIN
INSERT INTO customer(customer.customer_type_id, customer.name, customer.date_of_birth, customer.gender, customer.id_card, customer.phone_number, customer.email, customer.address) 
VALUES (customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE search_customer(IN search VARCHAR(50))
BEGIN
SELECT * 
FROM (
	SELECT 
		c.*, 
        t.name AS type_customer_name
    FROM 
		customer c LEFT JOIN customer_type t ON c.customer_type_id = t.id
	UNION
		SELECT 
		c.*, 
        t.name AS type_customer_name
    FROM 
		customer c RIGHT JOIN customer_type t ON c.customer_type_id = t.id
	) AS x
WHERE x.name LIKE search OR x.address LIKE search;
END//
DELIMITER ;