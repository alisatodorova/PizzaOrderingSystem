USE restaurant;

SHOW tables;

CREATE TABLE `customer` (
  `customer_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `telephone_number` varchar(50) NOT NULL,
  `street_address` varchar(255) NOT NULL,
  `postal_code` smallint unsigned NOT NULL,
  `pizzas_ordered` int unsigned NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`)
);
SELECT * FROM customer;

CREATE TABLE `order` (
  `order_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` smallint unsigned NOT NULL,
  `total_price` double NOT NULL,
  `discount_code` varchar(45),
  `status` varchar(45) NOT NULL,
  `estimated_delivery_time` datetime NOT NULL,
  `delivery_placed_time` datetime NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_customer_id` (`customer_id`),
 CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) 
);

SELECT * FROM `order`;

CREATE TABLE `pizza` (
  `pizza_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `pizza_name` varchar(45),
  `pizza_price` double NOT NULL,
  PRIMARY KEY (`pizza_id`)
);

INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (1, "Margherita", 6.75);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (2, "Bianca", 6.50);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (3, "Funghi", 6.75);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (4, "Caprese", 7);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (5, "Quatro Formaggio", 7);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (6, "Pepperoni", 7.50);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (7, "Hawaii", 7.50);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (8, "Prosciutto", 7.50);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (9, "Tuna", 8);
INSERT INTO pizza (pizza_id,pizza_name,pizza_price) VALUES (10, "BBQ Chicken", 8.50);
SELECT * FROM pizza;

CREATE TABLE `dessert` (
  `dessert_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `dessert_name` varchar(45),
  `dessert_price` double,
  PRIMARY KEY (`dessert_id`)
);

INSERT INTO dessert (dessert_id,dessert_name,dessert_price) VALUES (1, "Brownie", 3);
INSERT INTO dessert (dessert_id,dessert_name,dessert_price) VALUES (2, "Vanilla Ice Cream", 3);
SELECT * FROM dessert;

CREATE TABLE `drink` (
  `drink_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `drink_name` varchar(45),
  `drink_price` double,
  PRIMARY KEY (`drink_id`)
);
 
INSERT INTO drink (drink_id,drink_name,drink_price) VALUES (1, "Water", 2.50);
INSERT INTO drink (drink_id,drink_name,drink_price) VALUES (2, "Lemonade", 2.50);
INSERT INTO drink (drink_id,drink_name,drink_price) VALUES (3, "Coca Cola", 2.50);
INSERT INTO drink (drink_id,drink_name,drink_price) VALUES (4, "Fanta", 2.50);
SELECT * FROM drink;

CREATE TABLE `orderline` (
  `orderline_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` smallint unsigned NOT NULL,
  `order_id` smallint unsigned NOT NULL,
  `pizza_id` smallint unsigned NOT NULL,
  `drink_id` smallint unsigned,
  `dessert_id` smallint unsigned,
  `pizza_amount` smallint unsigned NOT NULL,
  `drink_amount` smallint unsigned,
  `dessert_amount` smallint unsigned,
  PRIMARY KEY (`orderline_id`),
   KEY `fk_customer_id` (`customer_id`),
  KEY `fk_order_id` (`order_id`),
   KEY `fk_pizza_id` (`pizza_id`),
    KEY `fk_drink_id` (`drink_id`),
     KEY `fk_dessert_id` (`dessert_id`),
CONSTRAINT `fk_orderline_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
 CONSTRAINT `fk_orderline_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
 CONSTRAINT `fk_orderline_pizza` FOREIGN KEY (`pizza_id`) REFERENCES `pizza` (`pizza_id`),
 CONSTRAINT `fk_orderline_drink` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`drink_id`),
  CONSTRAINT `fk_orderline_dessert` FOREIGN KEY (`dessert_id`) REFERENCES `dessert` (`dessert_id`)
);

SELECT * FROM orderline;

CREATE TABLE `delivery_employee` (
  `delivery_employee_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `postal_code` smallint unsigned NOT NULL,
  `isAvailable` boolean NOT NULL,
  `employee_name` varchar(255),
  PRIMARY KEY (`delivery_employee_id`)
);
SELECT * FROM delivery_employee;

CREATE TABLE `delivery` (
  `delivery_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `delivery_employee_id` smallint unsigned NOT NULL,
  `order_id` smallint unsigned NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`delivery_id`),
  KEY `fk_delivery_employee` (`delivery_employee_id`),
  KEY `fk_order_id` (`order_id`),
 CONSTRAINT `fk_delivery_employee` FOREIGN KEY (`delivery_employee_id`) REFERENCES `delivery_employee` (`delivery_employee_id`),
 CONSTRAINT `fk_delivery_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) 
);
SELECT * FROM delivery;