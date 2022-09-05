CREATE DATABASE  IF NOT EXISTS `crear` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `crear`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: crear
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `apellido` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `direccion` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fecha` date NOT NULL,
  `porcentaje` int NOT NULL,
  `representante` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `foto` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `foto_firma` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id_persona`,`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (6,'1234567890','asdasd','123123321','asdsada','2022-08-07',21,'dadsadsa','\\Fichas Crear\\img\\sin_imagen.png','\\Fichas Crear\\firma\\'),(7,'asdsad','asdsad','asdsadasd','sadasd','2022-08-13',21,'asdsad','\\Fichas Crear\\img\\sin_imagen.png','\\Fichas Crear\\img\\sin_firma.png'),(8,'asdsad','asdsad','asdsadasd','sadasd','2022-08-13',21,'asdsad','\\Fichas Crear\\img\\sin_imagen.png','\\Fichas Crear\\img\\sin_firma.png'),(10,'asdsad22','asdad','76688888','urdesa','2022-08-06',21,'asdsad','\\Users\\sopor\\OneDrive\\Documentos\\NetBeansProjects\\F_Crear\\F_Crear\\src\\img\\sin_imagen.png','C:\\\\Users\\\\sopor\\\\OneDrive\\\\Imágenes\\\\Foto2.png'),(12,'0023546545','ANABEL','09846512','TRINIPUERTO','2003-08-21',25,'CARMEN MORENO',NULL,NULL),(13,'0987579874','ANDREA','0894232000','EL ORO','2022-08-28',30,'MARCOS RIVERA','\\Users\\sopor\\OneDrive\\Documentos\\NetBeansProjects\\F_Crear\\F_Crear\\src\\img\\sin_imagen.png','C:\\\\Users\\\\sopor\\\\Downloads\\\\quimi-removebg-preview (1).png'),(14,'E2D','DX','EVD','D','2022-08-13',52,'CEDSX',NULL,NULL),(15,'092002152','CINDY','9090909090','PORTETE','2022-08-12',20,'MARIANO CEPEDA','\\Fichas Crear\\img\\sin_imagen.png','\\Fichas Crear\\img\\sin_firma.png'),(16,'6532089565','JUAN','5555555555','PORTETE','2022-08-27',60,'MIGUEL',NULL,NULL),(17,'0852222222','MARIA','7777777777','AV. 25 DE JULIO','2022-08-28',20,'HUGO',NULL,NULL),(18,'0888888888','HUGO','0555555555','VENEZUELA','2022-08-28',40,'GABRIELA',NULL,NULL),(19,'0895555555','MARIANA','0989999999','PORTETE','2022-08-21',23,'ROBERTO',NULL,NULL),(20,'0454444444','juan','0888888888','angel','2022-08-13',20,'monica','C:\\\\Users\\\\USER\\\\Downloads\\\\JV.jpeg','C:\\\\Users\\\\USER\\\\Downloads\\\\musica.png'),(24,'0777777777','JUAN','0999999999','PORTETE','2022-08-14',40,'JAVIER','C:\\\\Users\\\\USER\\\\Downloads\\\\jk.jpg','C:\\\\Users\\\\USER\\\\Downloads\\\\jin.jpg'),(26,'1234567898','VICTORIA VILLA','0514132429','URDESA','2020-09-03',34,'LUIS MERA','C:\\\\Fichas Crear\\\\fotos\\\\Tobbi.jpg',''),(27,'5666666666','ytyryt','','','2022-09-01',6,'','',''),(28,'7777777777','MARIA JOSE VERA PEREZ','1234567899','CEIBOS NORTE','2022-09-02',76,'LEONEL MESSI','\\Users\\sopor\\OneDrive\\Documentos\\NetBeansProjects\\F_Crear\\F_Crear\\src\\img\\sin_imagen.png','C:\\\\Users\\\\sopor\\\\OneDrive\\\\Imágenes\\\\java.png');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-05  1:04:58
