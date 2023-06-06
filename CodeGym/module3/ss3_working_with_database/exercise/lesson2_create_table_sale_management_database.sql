create database sale_management;
use sale_management;
create table customer(
customer_id int auto_increment,
customer_name varchar(50),
customer_age int,
constraint customer_id_pk primary key (customer_id)
);
create table `order`(
order_id int auto_increment,
customer_id int,
order_date datetime,
order_total_pice float,
constraint order_id_pk primary key (order_id),
constraint customer_id_fk foreign key (customer_id) references customer(customer_id)
);
create table product(
product_id int auto_increment,
product_name varchar(50),
product_price float,
constraint product_id_pk primary key (product_id)
);
create table order_detail(
order_id int,
product_id int,
order_detail_qty varchar(50),
constraint id_pk primary key (order_id, product_id),
constraint order_id_fk foreign key (order_id) references `order`(order_id),
constraint product_id_fk foreign key (product_id) references product(product_id)
);