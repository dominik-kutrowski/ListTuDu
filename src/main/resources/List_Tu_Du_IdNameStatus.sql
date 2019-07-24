-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: List_Tu_Du
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `task` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` enum('NotStarted','InProgress','Completed') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'zadanie no. 1','NotStarted'),(2,'task no. 2','NotStarted'),(3,'first real task!','NotStarted'),(4,'second real task!','NotStarted'),(5,'first task from boss!','NotStarted'),(6,'second task from boss!','NotStarted'),(7,'third task from boss!','NotStarted'),(8,'nowy boss potrzebny!','NotStarted'),(9,'pierwszy durny task!','NotStarted'),(10,'pierwszy durny task nowego szefa!!','NotStarted'),(11,'zwalniam sie!!','NotStarted'),(35,'test task no. 4','NotStarted'),(38,'test task no. 7','NotStarted'),(39,'test task no. 8','NotStarted'),(40,'NewTask albo i nie!','NotStarted'),(48,'test99','NotStarted'),(49,'test102','NotStarted'),(50,'task test 11','NotStarted'),(51,'task test 12','NotStarted'),(52,'task test 12','NotStarted'),(54,'task test 13','NotStarted'),(55,'task test 14','NotStarted'),(56,'task test In Progress','NotStarted'),(57,'task test Completed','NotStarted'),(58,'task test check1','NotStarted'),(59,'task test check2','NotStarted'),(60,'Completed','NotStarted'),(61,'completed','NotStarted'),(62,'test Completed','NotStarted'),(63,'test Completed/NotStarted','NotStarted'),(64,'test Completed/NotStarted','NotStarted'),(65,'test Completed/NotStarted1','NotStarted'),(66,'task test completed1','NotStarted'),(67,'task test in progres1','NotStarted'),(68,'task test in not started','NotStarted'),(69,'task test in progres2','NotStarted'),(70,'task test in completed2','NotStarted'),(71,'task test in completed3','NotStarted'),(72,'task test in progres3','NotStarted'),(73,'task testnot started','NotStarted'),(74,'task test Not Start','NotStarted'),(75,'test1','NotStarted'),(76,'test2','NotStarted'),(77,'tak 1 ip','NotStarted'),(78,'tak 1 ns','NotStarted'),(79,'tak 1 cp','NotStarted'),(80,'tak 2 cp','NotStarted'),(81,'tak 3 cp','NotStarted'),(82,'test1','NotStarted'),(83,'test 321','NotStarted'),(85,'task test 1','NotStarted'),(86,'task test completed 2','Completed'),(87,'test102','InProgress');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-24 23:02:42
