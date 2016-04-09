/***********************************************************
* Create the database named pictures, its tables
************************************************************/

DROP DATABASE IF EXISTS pictures;

CREATE DATABASE pictures;

USE pictures;

CREATE TABLE Users (
  UserID INT NOT NULL AUTO_INCREMENT,
  Email VARCHAR(50),
  FirstName VARCHAR(50),
  LastName VARCHAR(50),
  UserName VARCHAR(50),
  Address VARCHAR(50),
  AddressNumber INT,
  City VARCHAR(50),
  State VARCHAR(2),
  ZipCode INT,
  Password VARCHAR(40),
  PRIMARY KEY(UserID) 
);

CREATE TABLE Picture (
	PictureID INT NOT NULL AUTO_INCREMENT,
    Description VARCHAR(200),
    Artist varchar(100),
    Price float,
    Location varchar(500),
    Sale bool,
    Percentage INTEGER,
    primary key (PictureID)
);


CREATE TABLE PictureOrder (
  OrderID INT NOT NULL AUTO_INCREMENT,
  UserID INT NOT NULL,
  PictureID INT NOT NULL,

  PRIMARY KEY (OrderID), 
  FOREIGN KEY (UserID) REFERENCES Users (UserID),
  FOREIGN KEY (PictureID) REFERENCES Picture (PictureID)
);

insert into picture (PictureID, description, Artist, Price, Location, Sale, percentage)
values 
(1, 'Cat pictures', 'April', 35.50, "images/cat_pic.jpg", true, 10),
(2, 'New York', 'Ron', 300.50, "images/newyork.jpg", false, 0);