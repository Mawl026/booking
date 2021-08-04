CREATE DATABASE  IF NOT EXISTS `booking` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `booking`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: booking
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `booking_date` datetime NOT NULL,
  `booking_days` int DEFAULT NULL,
  `booking_comment` varchar(100) DEFAULT NULL,
  `booking_status` tinyint(1) DEFAULT NULL,
  `fk_user_id` int DEFAULT NULL,
  `fk_item_id` int DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_Booking_Student_idx` (`fk_user_id`),
  KEY `fk_Booking_item1_idx` (`fk_item_id`),
  CONSTRAINT `fk_Booking_item1` FOREIGN KEY (`fk_item_id`) REFERENCES `item` (`item_id`),
  CONSTRAINT `fk_Booking_Student` FOREIGN KEY (`fk_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) DEFAULT NULL,
  `item_description` varchar(45) DEFAULT NULL,
  `item_type` varchar(45) DEFAULT NULL,
  `fk_room_number` int DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `fk_item_room1` (`fk_room_number`),
  CONSTRAINT `fk_item_room1` FOREIGN KEY (`fk_room_number`) REFERENCES `room` (`room_number`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Oculus Quest 2','VR-Headset 1','VR-Headset',212),(2,'Oculus Quest 2','VR-Headset 2','VR-Headset',212),(3,'Oculus Quest 2','VR-Headset 3','VR-Headset',212),(4,'Oculus Quest 2','VR-Headset 4','VR-Headset',212),(5,'Oculus Quest 2','VR-Headset 5','VR-Headset',212),(6,'Oculus Quest 2','VR-Headset 6','VR-Headset',212),(7,'Oculus Rift S','VR-Headset 7','VR-Headset',212),(8,'Oculus Rift S','VR-Headset 8','VR-Headset',212),(9,'Arbejdsstation PC','PC 1','Datamat',212),(10,'HP','Hewlett-Packard Printer','Plakatprinter',212),(11,'Creatlity CR-10 S5','3D-Printer 1','3D Printer',210),(12,'Creatlity CR-10 S5','3D-Printer 2','3D Printer',210),(13,'Creatlity CR-10 S5','3D-Printer 3','3D Printer',210),(14,'Creatlity CR-10 S5','3D-Printer 4','3D Printer',210),(15,'Creatlity CR-10 S5','3D-Printer 5','3D Printer',210),(16,'Creatlity CR-10 S5','3D-Printer 6','3D Printer',210),(17,'Creatlity CR-10 S5','3D-Printer 7','3D Printer',210),(18,'Creatlity CR-10 S5','3D-Printer 8','3D Printer',210),(19,'Canon EOS 90D','Kamera 1','Digitalkamera',212),(20,'Canon EOS 90D','Kamera 2','Digitalkamera',212),(21,'Canon EOS 90D','Kamera 3','Digitalkamera',212),(22,'Panasonic 4K','Kamera 4','Digitalkamera',212),(23,'Fotostudio','Studie 1','Fotostudie',212);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_number` int NOT NULL,
  `room_description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`room_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (210,'Makerlab'),(212,'Medialab');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_mail` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_phone` int NOT NULL,
  `user_credit` int NOT NULL DEFAULT '50',
  `user_role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`user_mail`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'student@school.dk','student',112,50,'student'),(2,'teacher@school.dk','teacher',911,50,'teacher'),(3,'admin@school.dk','admin',10101010,50,'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-04 17:28:35
