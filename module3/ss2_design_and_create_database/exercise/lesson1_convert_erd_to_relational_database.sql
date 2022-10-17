CREATE DATABASE sale;
USE sale;
CREATE TABLE phone_number (
    id INT AUTO_INCREMENT,
    phone_number INT NOT NULL,
    CONSTRAINT phone_number_pk PRIMARY KEY (id)
);
CREATE TABLE supplier (
    id INT AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    adress VARCHAR(50) NOT NULL,
    phone_number INT NOT NULL,
    CONSTRAINT suplier_pk PRIMARY KEY (id),
    CONSTRAINT suplier_fk_phone_number FOREIGN KEY (phone_number)
        REFERENCES phone_number (id)
);
CREATE TABLE supply (
    id INT AUTO_INCREMENT,
    supply_name VARCHAR(50) NOT NULL,
    CONSTRAINT supply_pk PRIMARY KEY (id)
);
CREATE TABLE `order` (
    id INT AUTO_INCREMENT,
    order_date DATETIME NOT NULL,
    supplier_id INT NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id),
    CONSTRAINT order_fk_supplier FOREIGN KEY (supplier_id)
        REFERENCES supplier (id)
);
CREATE TABLE supply_order (
    supply_id INT NOT NULL,
    order_id INT NOT NULL,
    CONSTRAINT supply_order_pk PRIMARY KEY (supply_id , order_id),
    CONSTRAINT supply_order_fk_supply FOREIGN KEY (supply_id)
        REFERENCES supply (id),
    CONSTRAINT supply_order_fk_order FOREIGN KEY (order_id)
        REFERENCES `order` (id)
);
CREATE TABLE enter_coupon (
    id INT AUTO_INCREMENT,
    enter_coupon_date DATETIME NOT NULL,
    CONSTRAINT enter_coupon_pk PRIMARY KEY (id)
);
CREATE TABLE supply_enter_coupon (
    supply_id INT NOT NULL,
    enter_coupon_id INT NOT NULL,
    enter_cost FLOAT NOT NULL,
    enter_number INT NOT NULL,
    CONSTRAINT supply_enter_coupon_pk PRIMARY KEY (supply_id , enter_coupon_id),
    CONSTRAINT supply_enter_coupon_fk_supply FOREIGN KEY (supply_id)
        REFERENCES supply (id),
    CONSTRAINT supply_enter_coupon_fk_enter_coupon FOREIGN KEY (enter_coupon_id)
        REFERENCES enter_coupon (id)
);
CREATE TABLE bill (
    id INT AUTO_INCREMENT,
    bill_date DATETIME,
    CONSTRAINT bill_pk PRIMARY KEY (id)
);
CREATE TABLE bill_supply (
    bill_id INT NOT NULL,
    supply_id INT NOT NULL,
    bill_cost FLOAT NOT NULL,
    bill_number INT NOT NULL,
    CONSTRAINT bill_supply_pk PRIMARY KEY (bill_id , supply_id),
    CONSTRAINT bill_supply_fk_bill FOREIGN KEY (bill_id)
        REFERENCES bill (id),
    CONSTRAINT bill_supply_fk_supply FOREIGN KEY (supply_id)
        REFERENCES supply (id)
);
EXPLAIN SELECT * FROM bill;