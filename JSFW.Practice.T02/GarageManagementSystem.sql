-- Create Database
DROP DATABASE IF EXISTS GarageManagementSystem;
CREATE DATABASE IF NOT EXISTS GarageManagementSystem;
USE GarageManagementSystem;

-- Drop table if exists
DROP TABLE IF EXISTS Car;
DROP TABLE IF EXISTS Accessory;

-- Create table Car
CREATE TABLE IF NOT EXISTS Car (
	license_plate 	VARCHAR(50) NOT NULL ,
	repair_date 	DATETIME NOT NULL,
	customer_name 	NVARCHAR(50) NOT NULL,
	catalogs 		NVARCHAR(50) NOT NULL,
	car_maker 		NVARCHAR(50) NOT NULL,
	PRIMARY KEY (license_plate,repair_date)
);

-- Create table Accessory
CREATE TABLE IF NOT EXISTS Accessory (
    id 					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    license_plate 		VARCHAR(50) NOT NULL,
    repair_date 		DATETIME NOT NULL,
    `name` 				NVARCHAR(50) NOT NULL,
    price 				FLOAT(50) NOT NULL,
    status_damaged 		NVARCHAR(50) NOT NULL,
    repair_status 		NVARCHAR(50) NOT NULL,
    FOREIGN KEY (license_plate , repair_date) REFERENCES Car (license_plate , repair_date)
);


