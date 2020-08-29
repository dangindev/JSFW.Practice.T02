DROP DATABASE IF EXISTS GarageManagement;
CREATE DATABASE IF NOT EXISTS GarageManagement;

USE GarageManagement;

DROP TABLE IF EXISTS car;
CREATE TABLE car
(
	license_plate	VARCHAR(20),
    repair_date		Date,
    customer_name	VARCHAR(20) NOT NULL,
    catalogs		VARCHAR(50),
    car_maker		VARCHAR(50),
    PRIMARY KEY (license_plate,repair_date)
);

DROP TABLE IF EXISTS accessory;
CREATE TABLE accessory
(
	id				INT UNSIGNED AUTO_INCREMENT,
    license_plate	VARCHAR(20) NOT NULL,
    repair_date		Date NOT NULL,
	`name`			VARCHAR(50),
    price 			INT,
    status_damaged	VARCHAR(50),
    repair_status	VARCHAR(50),
	PRIMARY KEY (id),
    FOREIGN KEY(license_plate, repair_date) REFERENCES car (license_plate, repair_date)
);