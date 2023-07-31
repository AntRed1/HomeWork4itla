CREATE DATABASE  IF NOT EXISTS `logins` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `logins`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: logins
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `informacion_usuarios`
--

DROP TABLE IF EXISTS `informacion_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion_usuarios` (
  `ID_User` int NOT NULL AUTO_INCREMENT,
  `Nomb_User` varchar(50) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_User`),
  UNIQUE KEY `Nomb_User` (`Nomb_User`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion_usuarios`
--

LOCK TABLES `informacion_usuarios` WRITE;
/*!40000 ALTER TABLE `informacion_usuarios` DISABLE KEYS */;
INSERT INTO `informacion_usuarios` VALUES (18,'dlisbeth','123','Deny Lisbeth','De Los Santos','123456','dlisbeth@gmail.com'),(19,'admin','123','admin1','admin1','123456','admin1@gmail.com'),(21,'arojas','123','Anthony','Rojas','123','arojas@bsc.com.do'),(22,'jreyes','123','Juan','Reyes','18415','jr@gmail.com');
/*!40000 ALTER TABLE `informacion_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Usuarios_insert_autosave` AFTER INSERT ON `informacion_usuarios` FOR EACH ROW BEGIN
  INSERT INTO usuarios (ID_User, Nomb_User, Password)
  VALUES (NEW.ID_User, NEW.Nomb_User, NEW.Password);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Informacion_Usuarios_new` AFTER INSERT ON `informacion_usuarios` FOR EACH ROW BEGIN
  INSERT INTO Logs (Nomb_User, Fecha, Usuario, Descripcion)
  VALUES (NEW.Nomb_User, NOW(), NEW.ID_User, 'Se ha Registrado un Nuevo Usuario');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Informacion_Usuarios_Update` AFTER UPDATE ON `informacion_usuarios` FOR EACH ROW BEGIN
  INSERT INTO Logs (Nomb_User, Fecha, Usuario, Descripcion)
  VALUES (NEW.Nomb_User, NOW(), NEW.ID_User, 'Se ha realizado una Actualizacion de la Informacion');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Informacion_Usuarios_Update_TB_Usuarios` AFTER UPDATE ON `informacion_usuarios` FOR EACH ROW BEGIN
  INSERT INTO usuarios (Nomb_User,Password)
  VALUES (NEW.Nomb_User, NEW.Password);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `borra_datos_usuarios` AFTER DELETE ON `informacion_usuarios` FOR EACH ROW BEGIN
    DELETE FROM usuarios WHERE ID_User = OLD.ID_User;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nomb_User` varchar(50) NOT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Usuario` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (1,'arojas','2023-07-25 08:00:44','1','Ha Iniciado Sesion'),(2,'arojas','2023-07-26 17:34:10','1','Se ha Registrado un Nuevo Usuario'),(3,'karodrigue','2023-07-26 17:57:19','1','Se ha Registrado un Nuevo Usuario'),(4,'karodrigue','2023-07-26 18:01:52','1','Se ha realizado una Eliminacion de la Informacion'),(5,'karodrigue','2023-07-26 18:03:13','1','Se ha Registrado un Nuevo Usuario'),(6,'rrojas','2023-07-26 18:07:25','1','Se ha Registrado un Nuevo Usuario'),(7,'','2023-07-26 18:17:56','1','Se ha Registrado un Nuevo Usuario'),(8,'karodrigue','2023-07-26 18:42:25','1','Se ha realizado una Eliminacion de la Informacion'),(9,'rrojas','2023-07-26 18:42:25','1','Se ha realizado una Eliminacion de la Informacion'),(10,'','2023-07-26 18:42:25','1','Se ha realizado una Eliminacion de la Informacion'),(12,'rrojas','2023-07-26 19:19:09','1','Se ha Registrado un Nuevo Usuario'),(13,'rrojas','2023-07-26 19:19:09','1','Ha Iniciado Sesion'),(14,'karodrigue','2023-07-26 19:33:29','11','Ha Iniciado Sesion'),(15,'karodrigue','2023-07-26 19:33:29','11','Se ha Registrado un Nuevo Usuario'),(16,'dlisbeth','2023-07-27 18:47:33','12','Ha Iniciado Sesion'),(17,'dlisbeth','2023-07-27 18:47:33','12','Se ha Registrado un Nuevo Usuario'),(18,'dlisbeth','2023-07-27 18:53:55','13','Ha Iniciado Sesion'),(19,'dlisbeth','2023-07-27 18:53:55','13','Se ha Registrado un Nuevo Usuario'),(20,'karodrigue','2023-07-27 19:35:10','11','Se ha realizado una Eliminacion de la Informacion'),(21,'dlisbeth','2023-07-27 19:35:10','13','Se ha realizado una Eliminacion de la Informacion'),(22,'dlisbeth','2023-07-27 19:40:03','14','Ha Iniciado Sesion'),(23,'dlisbeth','2023-07-27 19:40:03','14','Se ha Registrado un Nuevo Usuario'),(24,'admin','2023-07-28 09:07:55','15','Ha Iniciado Sesion'),(25,'admin','2023-07-28 09:07:55','15','Se ha Registrado un Nuevo Usuario'),(26,'admin2','2023-07-28 11:53:44','16','Ha Iniciado Sesion'),(27,'admin2','2023-07-28 11:53:44','16','Se ha Registrado un Nuevo Usuario'),(28,'ADMIN3','2023-07-28 13:16:21','16','Se ha realizado una Actualizacion de la Informacion'),(32,'dlisbeth','2023-07-28 14:36:11','14','Se ha realizado una Eliminacion de la Informacion'),(33,'admin','2023-07-28 14:36:11','15','Se ha realizado una Eliminacion de la Informacion'),(34,'admin2','2023-07-28 14:36:11','16','Se ha realizado una Eliminacion de la Informacion'),(35,'dlisbeth','2023-07-28 14:37:45','18','Ha Iniciado Sesion'),(36,'dlisbeth','2023-07-28 14:37:45','18','Se ha Registrado un Nuevo Usuario'),(37,'rrojas','2023-07-28 14:38:36','10','Se ha realizado una Eliminacion de la Informacion'),(38,'admin','2023-07-28 16:52:03','19','Ha Iniciado Sesion'),(39,'admin','2023-07-28 16:52:03','19','Se ha Registrado un Nuevo Usuario'),(40,'admin2','2023-07-28 17:02:54','1','Se ha realizado una Actualizacion de la Informacion'),(41,'admin2','2023-07-28 17:02:54','20','Ha Iniciado Sesion'),(43,'arojas','2023-07-28 17:47:29','1','Se ha realizado una Eliminacion de la Informacion'),(44,'arojas','2023-07-28 17:52:21','21','Ha Iniciado Sesion'),(45,'arojas','2023-07-28 17:52:21','21','Se ha Registrado un Nuevo Usuario'),(46,'jreyes','2023-07-28 18:09:20','22','Ha Iniciado Sesion'),(47,'jreyes','2023-07-28 18:09:20','22','Se ha Registrado un Nuevo Usuario');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `ID_User` int NOT NULL AUTO_INCREMENT,
  `Nomb_User` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_User`),
  UNIQUE KEY `Nomb_User` (`Nomb_User`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (18,'dlisbeth','123'),(19,'admin','123'),(20,'admin2','123'),(21,'arojas','123'),(22,'jreyes','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Usuarios_new_session` AFTER INSERT ON `usuarios` FOR EACH ROW BEGIN
  INSERT INTO Logs (Nomb_User, Fecha, Usuario, Descripcion)
  VALUES (NEW.Nomb_User, NOW(), NEW.ID_User, 'Ha Iniciado Sesion');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tr_Informacion_Usuarios_Delete` AFTER DELETE ON `usuarios` FOR EACH ROW BEGIN
  INSERT INTO Logs (Nomb_User, Fecha, Usuario, Descripcion)
  VALUES (OLD.Nomb_User, NOW(), OLD.ID_User, 'Se ha realizado una Eliminacion de la Informacion');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-31  9:34:05
