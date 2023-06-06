CREATE DATABASE user;
USE user;

create table users (
 id  int(3) AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');
select * from users where users.country = 'Viet Nam';
select * from users ORDER BY `name`;

DELIMITER $$

CREATE PROCEDURE get_user_id (IN id INT)
BEGIN
	SELECT `name`, email, country
    FROM `users`
    WHERE users.id = id;
END$$

DELIMITER ;
call get_user_id(2);
DELIMITER $$
CREATE PROCEDURE insert_user (IN use_name varchar(50), use_email varchar(50), use_country varchar(50))
begin
INSERT into users(`name`, email, country) values (use_name, use_email, use_country);
end$$
DELIMITER ;
call insert_user('tan', 'tan@gmail.com', 'USA');
