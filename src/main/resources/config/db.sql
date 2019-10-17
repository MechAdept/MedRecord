CREATE DATABASE  IF NOT EXISTS `medrecord` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `medrecord`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: medrecord
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `health`
--

DROP TABLE IF EXISTS `health`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  `race` varchar(45) NOT NULL,
  `chest` int(11) NOT NULL,
  `waist` int(11) NOT NULL,
  `hips` int(11) NOT NULL,
  `nervous` varchar(45) NOT NULL,
  `constitution` varchar(45) NOT NULL,
  `musculature` varchar(45) NOT NULL,
  `leye` float DEFAULT NULL,
  `reye` float DEFAULT NULL,
  `blood` varchar(45) NOT NULL,
  `alcohol` tinyint(2) NOT NULL,
  `smoke` tinyint(2) NOT NULL,
  `drugs` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  CONSTRAINT `fk_health_patient.id` FOREIGN KEY (`patient_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health`
--

LOCK TABLES `health` WRITE;
/*!40000 ALTER TABLE `health` DISABLE KEYS */;
/*!40000 ALTER TABLE `health` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `description_UNIQUE` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_USER','Пользователь'),(2,'ROLE_ADMIN','Администратор'),(3,'ROLE_PATIENT','Пациент'),(20,'ROLE_MEDIC','Доктор'),(21,'ROLE_EXAMPLE1444444','Пример');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `ticket_id` int(11) DEFAULT NULL,
  `datetime` datetime NOT NULL,
  `available` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_schedule_doctor.id_idx` (`doctor_id`),
  KEY `fk_schedule_ticket.id_idx` (`ticket_id`),
  CONSTRAINT `fk_schedule_doctor.id` FOREIGN KEY (`doctor_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_schedule_ticket.id` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `patient` int(11) NOT NULL,
  `doctor` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  `attendance` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_patient.id_idx` (`patient`),
  KEY `fk_ticket_doctor.id_idx` (`doctor`),
  CONSTRAINT `fk_ticket_doctor.id` FOREIGN KEY (`doctor`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_ticket_patient.id` FOREIGN KEY (`patient`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `birth` date NOT NULL,
  `sex` tinyint(2) NOT NULL,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Username','$2a$11$g9Zb/tf8UaqKqsMw6X6Gieh1BidOmCVHL7RUadRIyoJ/Af9wTEexC','Дональд','Трамп',NULL,NULL,'1946-06-14',1,NULL),(6,'NewName','$2a$11$yI75hVAkWH9DMGTy2Q9Ig.BeADcIXjZELRRmORQ09ZfWHf7AeHi3.','Владимир','Зеленский','Александрович',NULL,'1978-01-25',1,NULL),(9,'12345678','$2a$11$2Xx1iFBPtdcrJNFVCZk0PubC2b8.hqgjAP87DGTg.BXGikVeB28cm','Иван','Охлобыстин','Иванович',NULL,'1966-07-22',1,NULL),(11,'11111111','$2a$11$jL1Yu.G1Y3JT3uqbfSHZXOw4RdKq4Ux4FmMFvq3CtBiJ7W2LfNnJC','Александр','Лукашенко','Григорьевич',NULL,'1954-08-30',1,NULL),(16,'87654321','$2a$11$AM2B2y5x5n.zW552LFf46uJV/0iVM9z7fMo8kheyYY3egPRmANkW.','Ангела','Меркель','Доротея',NULL,'1954-07-17',0,NULL),(18,'FirstCreateUser','$2a$11$EDETgZyKXT7moOzC5Hn/IOUq7I4Pglkk05l2Hi7XZeaDp8xH0y0qS','Хью','Лори',NULL,NULL,'1959-06-11',1,NULL),(19,'12312312','$2a$11$iiVBgRdqfdZYXJIl8MimoOebKfi.YaQXvYDWkIZC.OddzUdr.SQ0a','Вадим','Демчог','Купитман',NULL,'1963-03-13',1,NULL),(20,'asd','asd','asd','asd','asd',NULL,'1963-03-13',1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (4,1),(6,1),(9,1),(11,1),(16,1),(18,1),(19,1),(9,2),(11,2),(16,2),(18,2),(19,2),(9,3),(11,3),(16,3),(18,3),(19,3),(16,20),(18,20),(19,20),(16,21),(18,21),(19,21);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit`
--

DROP TABLE IF EXISTS `visit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visit` (
  `id` int(11) NOT NULL,
  `ticket_id` int(11) NOT NULL,
  `datetime` datetime NOT NULL,
  `complaint` text,
  `examination` text,
  `diagnosis` text,
  `treatment` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ticket_id_UNIQUE` (`ticket_id`),
  KEY `fk_visit_ticket.id_idx` (`ticket_id`),
  CONSTRAINT `fk_visit_ticket.id` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visit`
--

LOCK TABLES `visit` WRITE;
/*!40000 ALTER TABLE `visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-30 21:34:38
