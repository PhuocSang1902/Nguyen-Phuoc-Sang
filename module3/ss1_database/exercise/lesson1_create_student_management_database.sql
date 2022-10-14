create database management_student;
use management_student;
create table class(
class_id int primary key,
class_name varchar(50)
);
create table teacher(
teacher_id int primary key,
teacher_name varchar(50),
teacher_age int,
teacher_country varchar(50),
primary key (teacher_id)
);
insert into class value (1, 'C0722G1');
insert into class (class_id, class_name)
value (2, 'C0622G1');
select * from class;
insert into teacher value(1, 'Phuong', 27, 'viet nam');
insert into teacher (teacher_id, teacher_name, teacher_age) value (2,'Sang', 27);
select * from teacher;
update teacher set teacher_country = 'viet nam' where teacher_id = 2;
alter table class add teacher_id int;
update class set teacher_id = 1 where class_id = 1;
update class set teacher_id = 2 where class_id = 2;
alter table class add foreign key (teacher_id) references teacher(teacher_id);