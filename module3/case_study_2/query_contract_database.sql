DELIMITER //
CREATE PROCEDURE select_contract()
BEGIN
	SELECT 
		*
    FROM 
		contract;
END//
DELIMITER ;

CALL select_contract();

DELIMITER //
CREATE PROCEDURE select_contract_detail()
BEGIN
	SELECT 
		*
    FROM 
		contract_detail;
END//
DELIMITER ;

CALL select_contract_detail(); 

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

CALL select_detail_in_contract(3); 

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

CALL get_contract_by_id(2);