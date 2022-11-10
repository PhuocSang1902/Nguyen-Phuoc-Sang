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
CALL select_facility();
SELECT * FROM furamaresort_database.facility;
DELIMITER //
CREATE PROCEDURE add_facility(IN name VARCHAR(50), area INT, cost DOUBLE, max_people INT, rent_type_id INT, facility_type_id INT, standard_room VARCHAR(50), description_other_convenience VARCHAR(50), pool_area DOUBLE, number_of_floors INT, facility_free TEXT)
BEGIN
INSERT INTO facility(name, area, cost, max_people, rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free)
VALUES(name, area, cost, max_people, rent_type_id, facility_type_id, standard_room, description_other_convenience, pool_area, number_of_floors, facility_free);
END//
DELIMITER ;

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

CALL get_facility_by_id(2);