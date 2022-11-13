DELIMITER //
CREATE PROCEDURE select_facility()
BEGIN
SELECT
	f.*,
    r.name as rent_type_name,
    t.name as facility_type_name
FROM
	facility f LEFT JOIN rent_type r ON f.rent_type_id = r.id
			   LEFT JOIN facility_type t ON f.facility_type_id = t.id;
END//
DELIMITER ;
-- CALL select_faccustomerility();
-- SELECT * FROM furamaresort_database.facility;
DELIMITER //
CREATE PROCEDURE add_facility(IN name VARCHAR(50), area INT, cost DOUBLE, max_people INT, rent_type_id INT, facility_type_id INT, standard_room VARCHAR(50), description_other_convenience VARCHAR(50), pool_area DOUBLE, number_of_floors INT, facility_free TEXT)
BEGIN
INSERT INTO facility(name, area, cost, max_people, rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free)
VALUES(name, area, cost, max_people, rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free);
END//
DELIMITER ;
-- CALL add_facility('abc123', '5000', '5', '1', '3', '3', 'vip', 'abc', nullif(0,0), null, 'Tắm miễn phí');
DELIMITER //
CREATE PROCEDURE get_facility_by_id(IN id INT)
BEGIN
SELECT
	f.*,
    r.name as rent_type_name,
    t.name as facility_type_name
FROM
	facility f LEFT JOIN rent_type r ON f.rent_type_id = r.id
			   LEFT JOIN facility_type t ON f.facility_type_id = t.id
WHERE f.id = id;
END//
DELIMITER ;

-- CALL get_facility_by_id(2);

DELIMITER //
CREATE PROCEDURE edit_facility(IN id INT, name VARCHAR(50), area INT, cost DOUBLE, max_people INT, rent_type_id INT, facility_type_id INT, standard_room VARCHAR(50), description_other_convenience VARCHAR(50), pool_area DOUBLE, number_of_floors INT, facility_free TEXT)
BEGIN
	UPDATE facility 
	SET 
        facility.name=name, 
        facility.area=area, 
        facility.cost=cost, 
        facility.max_people=max_people, 
        facility.rent_type_id=rent_type_id, 
        facility.facility_type_id=facility_type_id, 
        facility.standard_room=standard_room, 
        facility.description_other_convenience=description_other_convenience, 
        facility.pool_area=pool_area, 
        facility.number_of_floors=number_of_floors, 
        facility.facility_free=facility_free
	WHERE
		facility.id=id;
END//
DELIMITER ;

-- CALL edit_facility(2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', 0, 3, 'Không áp dụng');

DELIMITER //
CREATE PROCEDURE search_facility(IN search VARCHAR(50))
BEGIN
SELECT * 
FROM (
	SELECT
		f.*,
		r.name as rent_type_name,
		t.name as facility_type_name
	FROM
		facility f LEFT JOIN rent_type r ON f.rent_type_id = r.id
				   LEFT JOIN facility_type t ON f.facility_type_id = t.id
	) AS x
WHERE x.name LIKE search OR x.rent_type_name LIKE search;
END//
DELIMITER ;

-- CALL search_facility('%villa%');

DELIMITER //
CREATE PROCEDURE get_attach_facility_by_id(IN id INT)
BEGIN
	SELECT 
		* 
	FROM 
		attach_facility af
	WHERE
		af.id = id;
END//
DELIMITER ;

CALL get_attach_facility_by_id(2);

DELIMITER //
CREATE PROCEDURE delete_facility_by_id(IN id INT)
BEGIN
SET SQL_SAFE_UPDATES = 0;
SET foreign_key_checks = 0;
DELETE FROM facility WHERE facility.id=id;
SET SQL_SAFE_UPDATES = 1;
SET foreign_key_checks = 1;
END //
DELIMITER ;

-- CALL delete_facility_by_id(7);