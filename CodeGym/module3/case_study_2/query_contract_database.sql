DELIMITER //
CREATE PROCEDURE select_contract()
BEGIN
	SELECT 
		*
    FROM 
		contract;
END//
DELIMITER ;

-- CALL select_contract();

DELIMITER //
CREATE PROCEDURE select_contract_detail()
BEGIN
	SELECT 
		*
    FROM 
		contract_detail;
END//
DELIMITER ;

-- CALL select_contract_detail(); 

DELIMITER //
CREATE PROCEDURE select_detail_in_contract(IN contract_id INT)
BEGIN
	SELECT 
		*
    FROM 
		contract_detail
	WHERE
		contract_detail.contract_id = contract_id;
END//
DELIMITER ;

-- CALL select_detail_in_contract(3); 

DELIMITER //
CREATE PROCEDURE get_contract_by_id(IN id INT)
BEGIN
	SELECT 
		*
    FROM 
		contract
	WHERE contract.id = id;
END//
DELIMITER ;

-- CALL get_contract_by_id(2);

DELIMITER //
CREATE PROCEDURE select_contract_with_value()
BEGIN
	SELECT 
		c.*,
        (sum(ifnull(cd.quantity,0) * ifnull(af.cost,0)) + f.cost) AS total_value
    FROM 
		contract c LEFT JOIN contract_detail cd ON c.id=cd.contract_id
				LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id
                  LEFT  JOIN facility f ON c.facility_id = f.id
	GROUP BY c.id
    ORDER BY c.id;
END//
DELIMITER ;

-- CALL select_contract_with_value();

DELIMITER //
CREATE PROCEDURE add_contract(IN start_date DATETIME, end_date DATETIME, deposit DOUBLE, employee_id  INT, customer_id  INT, facility_id INT)
BEGIN
INSERT INTO contract(start_date, end_date, deposit, employee_id, customer_id, facility_id) 
VALUES (start_date, end_date, deposit, employee_id, customer_id, facility_id);
END//
DELIMITER ;

-- CALL add_contract();

DELIMITER //
CREATE PROCEDURE add_contract_detail(IN contract_id INT, attach_facility_id INT, quantity INT)
BEGIN
INSERT INTO contract_detail(contract_id, attach_facility_id, quantity) 
VALUES (contract_id, attach_facility_id, quantity);
END//
DELIMITER ;

CALL add_contract_detail();