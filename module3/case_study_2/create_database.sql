CREATE DATABASE furama_resort;
USE furama_resort;

CREATE TABLE `position` (
	id INT PRIMARY KEY,
	`name` VARCHAR(45)
);

CREATE TABLE education_degree (
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

CREATE TABLE division (
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

CREATE TABLE `role` (
	role_id INT PRIMARY KEY,
    role_name VARCHAR(225)
);

CREATE TABLE `user` (
	username VARCHAR(225) PRIMARY KEY,
    `password` VARCHAR(225)
);

CREATE TABLE user_role (
	role_id INT,
    username VARCHAR(225),
    PRIMARY KEY (role_id, username),
    FOREIGN KEY (role_id) REFERENCES `role`(role_id),
    FOREIGN KEY (username) REFERENCES `user`(username)
);

CREATE TABLE employee (
	id INT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender BIT(1) NOT NULL,
    id_card VARCHAR(45) NOT NULL,
    phone_number VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    position_id INT NOT NULL,
    education_degree_id INT NOT NULL,
    division_id INT NOT NULL,
    username VARCHAR(225),
    FOREIGN KEY (position_id) REFERENCES `position`(id),
    FOREIGN KEY (education_degree_id) REFERENCES education_degree(id),
    FOREIGN KEY (division_id) REFERENCES division(id),
    FOREIGN KEY (username) REFERENCES `user`(username)
);

CREATE TABLE customer_type (
	id INT PRIMARY KEY,
	`name` VARCHAR(45)
);

CREATE TABLE customer (
	id INT PRIMARY KEY,
    customer_type_id INT NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender BIT(1) NOT NULL,
    id_card VARCHAR(45) NOT NULL,
    phone_number VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    address VARCHAR(45),
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(id)
);

CREATE TABLE facility_type(
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

CREATE TABLE rent_type(
	id INT PRIMARY KEY,
    `name` VARCHAR(45)
);

CREATE TABLE facility(
	id INT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    area INT,
    cost DOUBLE NOT NULL,
    max_people INT,
    rent_type_id INT NOT NULL,
    facility_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    facility_free TEXT,
    FOREIGN KEY (rent_type_id) REFERENCES rent_type(id),
    FOREIGN KEY (facility_type_id) REFERENCES facility_type(id)
);

CREATE TABLE contract(
	id INT PRIMARY KEY,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    deposit DOUBLE NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    facility_id INT NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (facility_id) REFERENCES facility(id)
);

CREATE TABLE attach_facility(
	id INT PRIMARY KEY,
    `name` VARCHAR(45) NOT NULL,
    cost DOUBLE NOT NULL,
    unit VARCHAR(10) NOT NULL,
    `status` VARCHAR(45)
);

CREATE TABLE contract_detail(
	id INT PRIMARY KEY,
    contract_id INT NOT NULL,
    attach_facility_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (contract_id) REFERENCES contract(id),
    FOREIGN KEY (attach_facility_id) REFERENCES attach_facility(id)
);
