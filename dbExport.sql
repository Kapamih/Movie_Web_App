-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: webapp
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `email` varchar(36) NOT NULL,
  `password` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES ('33@gmail.com','$2a$10$Iq/3y4ffl9fZZgPwSydi9uhbYNLcyqc9zi6psHX3cysEEhvQouVzy',_binary ''),('a@gmail.com','123',_binary ''),('a2@gmail.com','$2a$10$dLmWVn0hGNH5WuGPCXJR4uSdiCs67aFTcBVKV7jKfwxFktmaLmL7a',_binary ''),('as@gmail.com','$2a$10$QqRUW6fJQ6lUsfCNpCtZy.F4Vh2xbcMmKBv/E5iORUcwB7XrCd8sC',_binary ''),('c@gmail.com','$2a$10$NzTmBzTGvVn6VXgbxDPYxe7w82a6lkdN0IvCCNXJOipa8iv5NLz3e',_binary ''),('k@gmail.com','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',_binary ''),('kmihalakakou@gmail.com','$2a$10$SzEL5I.4tOqW8baXm0Scaese3WnDZZaIbwFLfikTCPo.gCCNVGM5.',_binary ''),('l@gmail.com','$2a$10$5mmT7KC2WawbQmcNGf39auvuHvwXgULIZp9e8oDYNhdYKRUEs8uMe',_binary ''),('m@gmail.com','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',_binary ''),('p@gmail.com','$2a$10$hHDxLE.dqGz48l.sgG8XNOG02tTbbWTNAPFlVFrlBXuqQieqUaTXC',_binary '');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_movie`
--

DROP TABLE IF EXISTS `user_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_movie` (
  `email` varchar(36) NOT NULL,
  `MOVIE_ID` varchar(10) NOT NULL,
  UNIQUE KEY `USER_MOVIE_UK` (`email`,`MOVIE_ID`),
  KEY `USER_MOVIE_FK2` (`MOVIE_ID`),
  CONSTRAINT `USER_MOVIE_FK1` FOREIGN KEY (`email`) REFERENCES `app_user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_movie`
--

LOCK TABLES `user_movie` WRITE;
/*!40000 ALTER TABLE `user_movie` DISABLE KEYS */;
INSERT INTO `user_movie` VALUES ('k@gmail.com','tt0076759'),('k@gmail.com','tt0805666'),('m@gmail.com','tt0805666');
/*!40000 ALTER TABLE `user_movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 21:45:10
