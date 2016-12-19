-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: LivraisondePizza
-- Source Schemata: LivraisondePizza
-- Created: Mon Dec 19 18:26:43 2016
-- Workbench Version: 6.3.8
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema LivraisondePizza
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `LivraisondePizza` ;
CREATE SCHEMA IF NOT EXISTS `LivraisondePizza` ;

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Address
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Address` (
  `AddressId` INT NOT NULL AUTO_INCREMENT,
  `StreetId` INT NOT NULL,
  `x` DOUBLE NOT NULL,
  `y` DOUBLE NOT NULL,
  PRIMARY KEY (`AddressId`),
  CONSTRAINT `FK_Address_Street`
    FOREIGN KEY (`StreetId`)
    REFERENCES `LivraisondePizza`.`Street` (`StreetId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Address_Neighbor
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Address_Neighbor` (
  `Address_NeighborId` INT NOT NULL AUTO_INCREMENT,
  `AddressId1` INT NOT NULL,
  `AddressId2` INT NOT NULL,
  PRIMARY KEY (`Address_NeighborId`),
  CONSTRAINT `FK_Address_Neighbor_Address`
    FOREIGN KEY (`AddressId1`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Address_Neighbor_Address1`
    FOREIGN KEY (`AddressId2`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Cost
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Cost` (
  `CostId` INT NOT NULL AUTO_INCREMENT,
  `Distance` DOUBLE NOT NULL,
  `AddressId1` INT NOT NULL,
  `AddressId2` INT NOT NULL,
  PRIMARY KEY (`CostId`),
  CONSTRAINT `FK_Cost_Address`
    FOREIGN KEY (`AddressId1`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Cost_Address1`
    FOREIGN KEY (`AddressId2`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.DeliveryMan
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`DeliveryMan` (
  `DeliveryManId` INT NOT NULL AUTO_INCREMENT,
  `Available` INT NOT NULL,
  PRIMARY KEY (`DeliveryManId`));

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Order
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Order` (
  `OrderId` INT NOT NULL AUTO_INCREMENT,
  `AddressId` INT NOT NULL,
  PRIMARY KEY (`OrderId`),
  CONSTRAINT `FK_Order_Address`
    FOREIGN KEY (`AddressId`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Order_DeliveryMan
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Order_DeliveryMan` (
  `Order_DeliveryManId` INT NOT NULL AUTO_INCREMENT,
  `OrderId` INT NOT NULL,
  `DeliveryManId` INT NOT NULL,
  PRIMARY KEY (`Order_DeliveryManId`),
  CONSTRAINT `FK_Order_DeliveryMan_DeliveryMan`
    FOREIGN KEY (`DeliveryManId`)
    REFERENCES `LivraisondePizza`.`DeliveryMan` (`DeliveryManId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Order_DeliveryMan_Order`
    FOREIGN KEY (`OrderId`)
    REFERENCES `LivraisondePizza`.`Order` (`OrderId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Restaurant
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Restaurant` (
  `RestaurantId` INT NOT NULL AUTO_INCREMENT,
  `ListOfOrders` INT NULL,
  `AddressId` INT NOT NULL,
  `NumberOfAvailableDeliveryMan` INT NOT NULL,
  PRIMARY KEY (`RestaurantId`),
  CONSTRAINT `FK_Restaurant_Address`
    FOREIGN KEY (`AddressId`)
    REFERENCES `LivraisondePizza`.`Address` (`AddressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- ----------------------------------------------------------------------------
-- Table LivraisondePizza.Street
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `LivraisondePizza`.`Street` (
  `StreetId` INT NOT NULL AUTO_INCREMENT,
  `StreetName` VARCHAR(50) CHARACTER SET 'utf8mb4' NULL,
  `x1` DOUBLE NOT NULL,
  `y1` DOUBLE NOT NULL,
  `x2` DOUBLE NOT NULL,
  `y2` DOUBLE NOT NULL,
  PRIMARY KEY (`StreetId`));
SET FOREIGN_KEY_CHECKS = 1;
