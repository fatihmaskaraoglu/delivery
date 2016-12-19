-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: LivraisondePizza
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `AddressId` int(11) NOT NULL AUTO_INCREMENT,
  `StreetId` int(11) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  PRIMARY KEY (`AddressId`),
  KEY `FK_Address_Street` (`StreetId`),
  CONSTRAINT `FK_Address_Street` FOREIGN KEY (`StreetId`) REFERENCES `street` (`StreetId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,196,42),(2,1,190,83),(3,1,184,117),(4,2,168,214),(5,2,160,263),(6,2,152,308),(7,3,134,414),(8,3,131,436),(9,3,125,475),(10,3,116,530),(11,4,388,39),(12,4,386,66),(13,4,384,92),(14,4,381,128),(15,5,374,214),(16,5,372,241),(17,5,367,315),(18,6,359,416),(19,6,355,465),(20,6,350,531),(21,7,578,35),(22,7,579,70),(23,7,580,119),(24,8,582,222),(25,8,581,251),(26,8,581,292),(27,9,580,416),(28,9,581,451),(29,9,581,508),(30,10,771,42),(31,10,775,87),(32,10,778,127),(33,11,784,207),(34,11,786,230),(35,11,787,252),(36,11,790,299),(37,12,797,417),(38,12,803,508),(39,13,968,30),(40,13,972,57),(41,13,980,119),(42,14,995,222),(43,14,1011,321),(44,15,1024,409),(45,15,1032,470),(46,15,1035,496),(47,15,1040,533),(48,16,275,597),(49,16,231,598),(50,16,192,600),(51,16,153,601),(52,17,398,593),(53,17,452,592),(54,17,540,590),(55,18,626,589),(56,18,682,589),(57,18,756,588),(58,19,866,588),(59,19,902,587),(60,19,944,587),(61,19,983,587),(62,20,178,364),(63,20,230,365),(64,20,299,365),(65,21,421,366),(66,21,468,366),(67,21,526,365),(68,22,625,365),(69,22,662,365),(70,22,748,365),(71,23,841,366),(72,23,873,366),(73,23,918,367),(74,24,217,172),(75,24,257,172),(76,24,324,171),(77,25,423,171),(78,25,474,170),(79,25,529,170),(80,26,641,169),(81,26,689,170),(82,26,732,170),(83,27,818,170),(84,27,858,170),(85,27,948,171),(86,28,235,8),(87,28,269,8),(88,28,324,6),(89,29,434,6),(90,29,474,6),(91,29,520,7),(92,30,624,8),(93,30,667,7),(94,30,728,6),(95,31,804,6),(96,31,852,6),(97,31,921,5);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_neighbor`
--

DROP TABLE IF EXISTS `address_neighbor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_neighbor` (
  `Address_NeighborId` int(11) NOT NULL AUTO_INCREMENT,
  `AddressId1` int(11) NOT NULL,
  `AddressId2` int(11) NOT NULL,
  PRIMARY KEY (`Address_NeighborId`),
  KEY `FK_Address_Neighbor_Address` (`AddressId1`),
  KEY `FK_Address_Neighbor_Address1` (`AddressId2`),
  CONSTRAINT `FK_Address_Neighbor_Address` FOREIGN KEY (`AddressId1`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Address_Neighbor_Address1` FOREIGN KEY (`AddressId2`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_neighbor`
--

LOCK TABLES `address_neighbor` WRITE;
/*!40000 ALTER TABLE `address_neighbor` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_neighbor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `CostId` int(11) NOT NULL AUTO_INCREMENT,
  `Distance` double NOT NULL,
  `AddressId1` int(11) NOT NULL,
  `AddressId2` int(11) NOT NULL,
  PRIMARY KEY (`CostId`),
  KEY `FK_Cost_Address` (`AddressId1`),
  KEY `FK_Cost_Address1` (`AddressId2`),
  CONSTRAINT `FK_Cost_Address` FOREIGN KEY (`AddressId1`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Cost_Address1` FOREIGN KEY (`AddressId2`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES (1,67.391342,1,86),(2,41.436699,1,2),(3,34.525352,2,3),(4,98.321854,3,4),(5,96.75676,3,74),(6,85.577942,4,74),(7,49.648766,4,5),(8,45.705578,5,6),(9,107.517853,6,7),(10,91.915588,6,62),(11,87.637527,7,62),(12,22.203604,7,8),(13,39.458839,8,9),(14,55.731499,9,10),(15,122.003357,10,51),(16,39.012817,51,50),(17,39.051247,50,49),(18,44.011364,49,48),(19,123.074448,48,52),(20,131.405487,48,20),(21,116.289642,52,20),(22,66.189125,20,19),(23,49.162994,19,18),(24,113.097855,18,64),(25,110.096634,18,65),(26,101.316368,18,17),(27,122.007935,64,65),(28,114.252441,64,17),(29,109.257851,65,17),(30,69,64,63),(31,52.009613,63,62),(32,74.168724,17,16),(33,27.073973,16,15),(34,86.290169,15,14),(35,95.046486,15,76),(36,90.046486,15,77),(37,99,76,77),(38,67.007462,76,75),(39,40,75,74),(40,95.289719,76,14),(41,90.289719,77,14),(42,36.124783,13,14),(43,26.076809,13,12),(44,27.073973,12,11),(45,101.139557,88,11),(46,77.143723,89,11),(47,110.019089,89,88),(48,55.03635,88,87),(49,34,86,87),(50,40,89,90),(51,46.010868,91,90),(52,104.008926,91,92),(53,84.027283,91,21),(54,75.028488,92,21),(55,35.014282,22,21),(56,49.010204,22,23),(57,103.03508,24,23),(58,107.03772,24,79),(59,102.019608,23,79),(60,109.018539,23,80),(61,112,24,80),(62,112.00943,79,80),(63,55,79,78),(64,51.009804,77,78),(65,29.017237,24,25),(66,41,26,25),(67,126.016205,26,67),(68,118.006851,26,68),(69,124.00676,26,27),(70,104.009804,67,27),(71,97.009804,68,27),(72,99,68,67),(73,58.008621,66,67),(74,47,66,65),(75,35.014282,28,27),(76,57,28,29),(77,122.053841,54,29),(78,124.017609,55,29),(79,86.012192,55,54),(80,88.022728,53,54),(81,54.009258,53,52),(82,56,55,56),(83,74.00676,57,56),(84,110,57,58),(86,131.099945,38,57),(87,139.099945,38,58),(88,91.197586,38,37),(89,118.207565,36,37),(90,98.086472,70,37),(91,99.097107,71,37),(92,113.131737,71,36),(93,112.121101,70,36),(94,86,70,69),(95,37,68,69),(96,47.095646,36,35),(97,93.010635,70,71),(98,22.022715,34,35),(99,23.086792,34,33),(100,80.230453,33,32),(101,87.128441,33,82),(102,75.131744,33,83),(103,79.120514,32,83),(104,91.11721,32,82),(105,86,83,82),(106,43,81,82),(107,48.010414,81,80),(108,40.112343,32,31),(109,45.177429,30,31),(110,76.124786,30,94),(111,72.124786,30,95),(112,76,94,95),(113,61.008198,94,93),(114,43.011627,92,93),(115,48,96,95),(116,69.007248,96,97),(117,68.317978,39,97),(118,27.294687,39,40),(119,62.514,41,40),(120,104.088226,41,42),(121,91.46904,41,85),(122,90.623642,42,85),(123,90.005554,84,85),(124,40,84,83),(125,100.284592,42,43),(126,88.987045,44,43),(127,141.331085,44,73),(128,149.6819,43,73),(129,45.011108,72,73),(130,32,72,71),(131,61.522354,44,45),(132,26.172504,46,45),(133,37.336308,46,47),(134,117.468079,61,47),(135,39,61,60),(136,42,59,60),(137,36.013885,59,58);
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliveryman`
--

DROP TABLE IF EXISTS `deliveryman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliveryman` (
  `DeliveryManId` int(11) NOT NULL AUTO_INCREMENT,
  `Available` int(11) NOT NULL,
  PRIMARY KEY (`DeliveryManId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliveryman`
--

LOCK TABLES `deliveryman` WRITE;
/*!40000 ALTER TABLE `deliveryman` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliveryman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `AddressId` int(11) NOT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FK_Order_Address` (`AddressId`),
  CONSTRAINT `FK_Order_Address` FOREIGN KEY (`AddressId`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_deliveryman`
--

DROP TABLE IF EXISTS `order_deliveryman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_deliveryman` (
  `Order_DeliveryManId` int(11) NOT NULL AUTO_INCREMENT,
  `OrderId` int(11) NOT NULL,
  `DeliveryManId` int(11) NOT NULL,
  PRIMARY KEY (`Order_DeliveryManId`),
  KEY `FK_Order_DeliveryMan_DeliveryMan` (`DeliveryManId`),
  KEY `FK_Order_DeliveryMan_Order` (`OrderId`),
  CONSTRAINT `FK_Order_DeliveryMan_DeliveryMan` FOREIGN KEY (`DeliveryManId`) REFERENCES `deliveryman` (`DeliveryManId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Order_DeliveryMan_Order` FOREIGN KEY (`OrderId`) REFERENCES `order` (`OrderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_deliveryman`
--

LOCK TABLES `order_deliveryman` WRITE;
/*!40000 ALTER TABLE `order_deliveryman` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_deliveryman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `RestaurantId` int(11) NOT NULL AUTO_INCREMENT,
  `ListOfOrders` int(11) DEFAULT NULL,
  `AddressId` int(11) NOT NULL,
  `NumberOfAvailableDeliveryMan` int(11) NOT NULL,
  PRIMARY KEY (`RestaurantId`),
  KEY `FK_Restaurant_Address` (`AddressId`),
  CONSTRAINT `FK_Restaurant_Address` FOREIGN KEY (`AddressId`) REFERENCES `address` (`AddressId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `StreetId` int(11) NOT NULL AUTO_INCREMENT,
  `StreetName` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `x1` double NOT NULL,
  `y1` double NOT NULL,
  `x2` double NOT NULL,
  `y2` double NOT NULL,
  PRIMARY KEY (`StreetId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'none',201,9,175,176),(2,'none',175,176,142,366),(3,'none',142,366,104,605),(4,'none',391,5,377,171),(5,'none',377,171,363,365),(6,'none',363,365,345,592),(7,'none',577,7,582,177),(8,'none',582,177,580,366),(9,'none',580,366,582,588),(10,'none',768,6,782,174),(11,'none',782,174,794,365),(12,'none',794,365,808,589),(13,'none',965,6,988,177),(14,'none',988,177,1019,367),(15,'none',1019,367,1047,586),(16,'none',103,603,344,594),(17,'none',344,594,581,589),(18,'none',581,589,808,588),(19,'none',808,588,1047,586),(20,'none',143,364,362,366),(21,'none',362,366,580,365),(22,'none',580,365,794,365),(23,'none',794,365,1019,369),(24,'none',174,172,378,171),(25,'none',378,171,582,169),(26,'none',582,169,782,170),(27,'none',782,170,987,171),(28,'none',201,9,391,5),(29,'none',391,5,576,8),(30,'none',576,8,768,6),(31,'none',768,6,965,5);
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-19 18:28:46
