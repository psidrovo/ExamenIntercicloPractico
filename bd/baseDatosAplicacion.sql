CREATE DATABASE  IF NOT EXISTS `unidadeducativa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `unidadeducativa`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: unidadeducativa
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cursoId` int(11) DEFAULT NULL,
  `tema` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,1,'Math');
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `docenteId` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `docenteId_UNIQUE` (`docenteId`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,2,'1 Basica'),(2,NULL,'2 Basica');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datoactividad`
--

DROP TABLE IF EXISTS `datoactividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `datoactividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actividadId` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datoactividad`
--

LOCK TABLES `datoactividad` WRITE;
/*!40000 ALTER TABLE `datoactividad` DISABLE KEYS */;
INSERT INTO `datoactividad` VALUES (1,4,'fds','dsf'),(2,4,'ds','sd'),(3,1,'Math Duel: 2 Player Math Game ','Math Duel: 2 Player Math Game '),(4,1,'Mathway: Scan Photos','Mathway: Scan Photos'),(5,1,'Maths Dictionary Offline ','Maths Dictionary Offline '),(6,1,'Cymath ','Cymath '),(7,1,'MathPapa ','MathPapa '),(8,1,'Symbolab ','Symbolab '),(9,1,'Graphing Calculator ','Graphing Calculator '),(10,1,'Math Tests ','Math Tests '),(11,1,'Math games','Math games'),(12,1,'Mathman: Learn Math ','Mathman: Learn Math '),(13,1,'Mathematics ','Mathematics '),(14,1,'Math Tricks Workout ','Math Tricks Workout '),(15,1,'Mental Math Practice ','Mental Math Practice '),(16,1,'Math Games ','Math Games '),(17,1,'Math Solver ','Math Solver '),(18,1,'Math Workout ','Math Workout '),(19,1,'Math theory ','Math theory '),(20,1,'Math Jumps: Math Games ','Math Jumps: Math Games '),(21,1,'Simple Math ','Simple Math '),(22,1,'Math games: arithmetic','Math games: arithmetic'),(23,1,'Toon Math: Endless Run and Math Games ','Toon Math: Endless Run and Math Games '),(24,1,'Math Games ','Math Games '),(25,1,'All Maths Formulas ','All Maths Formulas '),(26,1,'Mental Math Master ','Mental Math Master '),(27,1,'Easy Math ','Easy Math '),(28,1,'Math Exercises for brain','Math Exercises for brain'),(29,1,'Math','Math'),(30,1,'Todo Math ','Todo Math '),(31,1,'Microsoft Math Solver ','Microsoft Math Solver '),(32,1,'Camera math calculator ','Camera math calculator '),(33,1,'Math Games','Math Games'),(34,1,'Math Tricks ','Math Tricks '),(35,1,'Math Scanner By Photo ','Math Scanner By Photo '),(36,1,'Math Master ','Math Master '),(37,1,'MalMath: Step by step solver ','MalMath: Step by step solver '),(38,1,'Brain Math: Puzzle Games','Brain Math: Puzzle Games'),(39,1,'Mental Math ','Mental Math '),(40,1,'Math Riddles ','Math Riddles '),(41,1,'Math Formula with Practice ','Math Formula with Practice '),(42,1,'Math games ','Math games '),(43,1,'Maths Formulas Free ','Maths Formulas Free '),(44,1,'Photomath ','Photomath '),(45,1,'All Math formula ','All Math formula '),(46,1,'Qanda: Free Math Solutions ','Qanda: Free Math Solutions '),(47,1,'Math Kids ','Math Kids '),(48,1,'Math Solver ','Math Solver '),(49,1,'Algebrator ','Algebrator '),(50,1,'Math ','Math '),(51,1,'Math Master ','Math Master '),(52,1,'Math Solver ','Math Solver ');
/*!40000 ALTER TABLE `datoactividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estudianteId` int(11) DEFAULT NULL,
  `cursoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `estudianteId_UNIQUE` (`estudianteId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,3,1),(3,4,1);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `genero` enum('MASCULINO','FEMENINO') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cedula_UNIQUE` (`cedula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'0106420763','Paul','Idrovo','Alfonso Moreno Mora','1996-05-13','MASCULINO'),(2,'0102332889','Carlos','Idrovo','Miguel Diaz','1954-05-21','MASCULINO'),(3,'0102030405','Sebastian','Idrovo','Remigio Crespo','0200-05-13','MASCULINO'),(4,'0102040501','Karla','Idrovo','Solano','1992-03-16','FEMENINO');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personaId` int(11) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `personaId_UNIQUE` (`personaId`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'rector@gmail.com','rector','RECTOR'),(2,2,'carlos@gmail.com','4631','DOCENTE');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-01 23:14:51
