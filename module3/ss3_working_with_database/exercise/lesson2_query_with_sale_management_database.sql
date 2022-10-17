USE sale_management;
INSERT INTO customer (customer_name, customer_age) 
VALUES ('Minh Quan', 10),
	   ('Ngoc Oanh', 20),
	   ('Hong Ha', 50);
INSERT INTO `order` (customer_id, order_date) 
VALUES (1, '2006/3/21'),
	   (2, '2006/3/23'),
	   (3, '2006/3/16');
INSERT INTO product (product_name, product_price) 
VALUES ('May Giat', 3),
       ('Tu Lanh', 5),
       ('Dieu Hoa', 7),
       ('Quat', 1),
       ('Bep Dien', 2);
INSERT INTO order_detail (order_id, product_id, order_detail_qty) 
VALUES (1,1,3),
       (1,3,7),
       (1,4,2),
       (2,1,1),
       (3,1,8),
       (2,5,4),
       (2,3,3);
SELECT 
    `order`.order_id, `order`.order_date, product.product_price
FROM
    (`order`
    JOIN (order_detail
    JOIN product ON order_detail.product_id = product.product_id) ON `order`.order_id = order_detail.order_id);
SELECT 
    c.customer_name, p.product_name
FROM
    (customer c
    JOIN (`order`
    JOIN (order_detail
    JOIN product p ON order_detail.product_id = p.product_id) ON `order`.order_id = order_detail.order_id) ON `order`.customer_id = c.customer_id);
SELECT 
    c.customer_name, p.product_name
FROM
    (customer c
    LEFT JOIN (`order`
    JOIN (order_detail
    JOIN product p ON order_detail.product_id = p.product_id) ON `order`.order_id = order_detail.order_id) ON `order`.customer_id = c.customer_id)
    WHERE p.product_name IS NULL;
SELECT 
    o.order_id,
    o.order_date,
    SUM(p.product_price * od.order_detail_qty) AS order_price
FROM
    (`order` o
    LEFT JOIN (order_detail od
    JOIN product p ON od.product_id = p.product_id) ON o.order_id = od.order_id)
    GROUP BY o.order_id;