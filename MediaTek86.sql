-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: mediatek86
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `absence`
--

DROP TABLE IF EXISTS `absence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `absence` (
  `idabsence` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prenom` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `datedebut` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `datefin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `motif` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idabsence`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absence`
--

LOCK TABLES `absence` WRITE;
/*!40000 ALTER TABLE `absence` DISABLE KEYS */;
INSERT INTO `absence` VALUES (1,'Maxwell','Roth Phillips','15-09-2018','21-09-2018','Vacances'),(2,'Stout','Jack Merrill','24-04-2019','26-04-2019','Vacances'),(3,'Bean','Desirae Frederick','19-10-2019','23-10-2019','Motif familial'),(4,'Dodson','Mikayla Walsh','16-11-2018','28-11-2018','Vacances'),(5,'Maxwell','Roth Phillips','16-04-2018','16-05-2018','Vacances'),(6,'Kline','James Levy','24-04-2019','07-05-2019','Vacances'),(7,'Rosales','Keegan Dyer','25-10-2019','04-11-2019','Vacances'),(8,'Goff','Nero Nielsen','30-05-2022','14-06-2022','Vacances'),(9,'Hinton','Avram Howell','06-07-2019','17-07-2019','Maladie'),(10,'Wallace','Nicholas Ewing','26-09-2020','02-11-2020','Maladie'),(11,'Campbell','Shaine Gilbert','10-04-2020','28-04-2020','Vacances'),(12,'Delaney','Galena Daniels','18-04-2019','10-05-2019','Vacances'),(13,'Roy','Samantha Blevins','11-02-2022','19-03-2022','Vacances'),(14,'Maxwell','Roth Phillips','29-05-2018','13-06-2018','Vacances'),(15,'Hopper','Castor Thompson','23-10-2018','17-11-2018','Vacances'),(16,'Hill','Declan Miranda','20-11-2021','07-12-2021','Vacances'),(17,'Harvey','Elijah Montoya','13-01-2022','30-04-2022','Maladie'),(18,'Blake','Tucker Tate','07-11-2020','23-11-2020','Vacances'),(19,'Trujillo','Aline Oneil','28-10-2018','30-06-2019','Congé parental'),(20,'Maxwell','Roth Phillips','16-04-2022','11-05-2022','Vacances'),(21,'Kemp','Xenos Sparks','14-09-2020','17-09-2020','Vacances'),(22,'Christian','Cruz Hardin','20-11-2018','01-12-2018','Vacances'),(23,'Mckee','Edward Kramer','25-03-2020','08-07-2020','Maladie'),(24,'Berger','Gannon Bradford','07-08-2019','13-08-2019','Maladie'),(25,'Maxwell','Roth Phillips','11-11-2020','11-12-2020','Vacances'),(26,'Davis','Calista Pena','15-09-2018','19-12-2021','Maladie'),(27,'Mason','Irma Chen','01-06-2019','09-08-2019','Vacances'),(28,'Maxwell','Roth Phillips','17-06-2020','16-07-2020','Vacances'),(29,'Mccall','Alexandra Puckett','23-02-2020','20-04-2020','Vacances'),(30,'Perkins','Naomi Wise','30-10-2019','14-11-2019','Maladie'),(31,'Bush','Margaret Glover','13-08-2019','14-09-2019','Vacances'),(32,'Gregory','Noble Barrera','25-08-2019','14-01-2020','Congé parental'),(33,'Koch','Walter Hodges','02-05-2019','20-06-2019','Vacances'),(34,'Wagner','Karen Nieves','17-06-2019','22-06-2019','Vacances'),(35,'Hines','Oprah Campos','24-09-2018','08-10-2018','Vacances'),(36,'Munoz','Oren Rich','05-02-2021','12-02-2021','Vacances'),(37,'Roberson','Zeph Payne','06-07-2021','02-02-2022','Maladie'),(38,'Benson','Charlotte Ashley','09-04-2019','13-04-2019','Maladie'),(39,'Solis','Avye Larsen','19-10-2021','03-11-2021','Maladie'),(40,'Holloway','McKenzie Moody','18-09-2021','25-09-2021','Vacances'),(41,'Noble','Wendy Turner','16-05-2019','18-05-2019','Maladie'),(42,'Ballard','Joel Barrett','13-06-2021','17-07-2021','Vacances'),(43,'Blackburn','Jaquelyn Rodriguez','31-05-2018','13-12-2021','Vacances'),(44,'Dotson','Vivien Vega','01-09-2021','19-09-2021','Maladie'),(45,'Mcbride','Danielle Sandoval','26-03-2019','14-04-2019','Vacances'),(46,'Fisher','Patience Burns','04-01-2021','24-02-2021','Vacances'),(47,'Bates','James Haley','01-12-2018','17-12-2018','Vacances'),(48,'Wiley','Chester Jackson','03-06-2019','08-07-2019','Vacances'),(49,'Hale','Leo Cooley','12-11-2018','29-11-2020','Vacances'),(50,'Pickett','Gabriel Horn','06-03-2021','08-03-2021','Motif familial'),(51,'Mccall','Myra Moreno','25-12-2019','15-11-2019','Maladie'),(52,'Johnson','Harrison Rowland','24-05-2021','29-05-2022','Congé parental'),(53,'Neal','Allistair Dalton','25-01-2022','05-02-2022','Vacances'),(54,'Herman','Charlotte Finley','31-12-2019','04-01-2020','Vacances'),(55,'Mcmahon','April Holloway','03-04-2021','16-04-20211','Vacances'),(56,'Barker','Dexter Hancock','18-08-2020','20-08-2020','Maladie'),(57,'Juarez','Erin Hardy','06-11-2021','10-11-2021','Vacances'),(58,'West','Zena Chavez','15-03-2019','18-03-2019','Vacances'),(59,'Sloan','Dante Cline','08-01-2021','15-01-2021','Vacances'),(60,'Rogers','Gage Montgomery','02-12-2020','09-12-2020','Vacances'),(61,'Albert','Gemma Solomon','18-04-2022','01-10-2022','Congé parental'),(62,'Benton','Malcolm Farrell','24-06-2019','26-06-2019','Maladie'),(63,'Lambert','Rose Simmons','05-12-2019','14-12-2019','Vacances'),(64,'Barber','Ulric Baxter','24-05-2020','14-06-2020','Vacances'),(65,'Mckinney','Chantale Cameron','27-03-2022','24-04-2022','Maladie'),(66,'Rose','Amir Cash','13-02-2022','16-05-2022','Congé parental'),(67,'Solis','Odette Heath','27-01-2021','13-02-2021','Vacances'),(68,'Holden','Harper Bishop','09-12-2021','30-12-2021','Vacances'),(69,'Daniel','Odette Pacheco','07-06-2021','04-07-2021','Vacances'),(70,'O\'Neill','Cullen Orr','15-08-2019','29-08-2019','Vacances'),(71,'Moss','Griffith Harrell','30-06-2020','16-07-2020','Vacances'),(72,'Ruiz','Priscilla Aguilar','02-09-2021','14-09-2021','Vacances'),(73,'Baldwin','Mark Mack','24-07-2018','18-08-2018','Vacances'),(74,'Floyd','Lester Guerrero','21-02-2022','28-02-2022','Maladie'),(75,'Reyes','Len Tate','09-05-2019','11-05-2019','Motif familial'),(76,'Nixon','Jermaine Gay','16-07-2018','04-09-2018','Maladie'),(77,'Cherry','Curran Blevins','29-07-2019','09-08-2019','Vacances'),(78,'Alford','Brian Townsend','05-06-2018','11-06-2018','Vacances'),(79,'Atkinson','Dane Mckinney','21-05-2020','24-05-2020','Maladie'),(80,'Gay','Ariel Luna','26-04-2020','15-09-2020','Congé parental'),(81,'Guthrie','Imogene Frank','28-06-2020','14-07-2020','Vacances'),(82,'Payne','Idola Stafford','12-02-2021','28-02-2021','Vacances'),(83,'Jennings','Cameron Olsen','14-02-2020','01-03-2020','Vacances'),(84,'Morton','Amal Glass','26-04-2020','27-04-2020','Maladie'),(85,'Richard','Aimee Pace','06-01-2022','18-01-2022','Vacances'),(86,'Wall','Yetta Cain','12-08-2019','04-09-2019','Vacances'),(87,'Flowers','Lysandra Keller','11-05-2018','10-01-2022','Maladie'),(88,'Mcdonald','Faith Sloan','24-03-2018','04-04-2018','Vacances'),(89,'Mckee','Stewart Henry','09-07-2018','16-08-2018','Vacances'),(90,'Todd','Dylan Wagner','17-01-2021','23-02-2021','Vacances'),(91,'Elliott','Berk Little','08-06-2018','13-08-2018','Vacances'),(92,'Solis','Carl Coleman','10-10-2020','14-11-2020','Maladie'),(93,'Velasquez','Katelyn Stanton','23-05-2019','16-06-2019','Vacances'),(94,'Copeland','Alvin Bray','03-07-2020','29-07-2020','Vacances'),(95,'Parrish','Thor Barker','31-12-2021','07-01-2022','Vacances'),(96,'Herrera','Thomas Justice','06-02-2020','14-03-2020','Vacances'),(97,'Sharpe','Lucian Spencer','11-12-2021','26-12-2021','Vacances'),(98,'Hamilton','Angelica Hubbard','11-06-2021','13-06-2021','Maladie'),(99,'England','Belle Carver','11-09-2021','01-10-2021','Vacances'),(100,'Haney','Courtney Kirby','20-10-2018','10-11-2018','Vacances'),(101,'Bean','Desirae Frederick','15-05-2021','16-06-2021','Maladie'),(102,'Chat','Perché','15-06-2021','15-08-2021','Congé parental'),(103,'Maxwell','Roth Phillips','15-05-2020','17-05-2020','Maladie'),(104,'Lao','La','15-06-2020','21-06-2020','Congé parental'),(105,'azeok','azeokp','15-06-2020','17-06-2020','Maladie'),(106,'Rosales','Keegan Dyer','15-06-2020','17-06-2020','Motif familial'),(107,'azeork','oazker','15-06-2022','17-06-2022','Congé parental'),(108,'Lao','aeo','12-05-2022','15-05-2022','Maladie');
/*!40000 ALTER TABLE `absence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personnel` (
  `idpersonnel` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prenom` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tel` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mail` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `service` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idpersonnel`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personnel`
--

LOCK TABLES `personnel` WRITE;
/*!40000 ALTER TABLE `personnel` DISABLE KEYS */;
INSERT INTO `personnel` VALUES (142,'Trevino','Amena Sargent','03 47 67 71 28','interdum@google.fr','Médiation culturelle'),(147,'Bridges','Iris Ortega','02 58 57 51 91','a.arcu@mediatek86.com','Prêt'),(148,'Larsen','Nero Patterson','02 73 90 42 38','nunc.mauris.morbi@mediatek86.com','Prêt'),(149,'Serrano','Isabella Patterson','03 16 61 58 34','feugiat.metus@mediatek86.fr','Médiation culturelle'),(150,'Horn','Melvin Horton','05 55 33 88 89','nibh.donec.est@mediatek86.com','Médiation culturelle'),(151,'Mcdonald','Lael Nguyen','07 01 07 44 63','a.tortor@mediatek86.fr','Administratif'),(152,'Haynes','Arsenio Calhoun','06 23 53 81 31','gravida.non.sollicitudin@mediatek86.fr','Médiation culturelle'),(153,'Johnston','Adria Leblanc','02 57 56 30 97','quisque.varius.nam@mediatek86.com','Médiation culturelle'),(154,'Peterson','Hoyt Charles','03 34 71 21 57','etiam.laoreet@mediatek86.fr','Médiation culturelle'),(155,'Schwartz','Quynn Cardenas','04 10 80 76 34','nulla.integer@mediatek86.fr','Prêt'),(156,'Mccall','Ingrid Savage','05 86 83 27 53','iaculis@mediatek86.fr','Administratif'),(157,'Hurley','Uma Riddle','07 37 86 13 58','sit@mediatek86.fr','Médiation culturelle'),(158,'Erickson','Denton Davidson','05 58 98 97 14','ipsum.cursus@mediatek86.com','Médiation culturelle'),(159,'Sloan','Wanda Beck','03 39 36 52 10','at.pede@mediatek86.com','Administratif'),(160,'Burks','Rigel Warren','06 50 85 65 11','ultricies.ligula.nullam@mediatek86.fr','Médiation culturelle'),(161,'Hunt','Evelyn Carlson','03 44 46 36 17','mus.proin.vel@mediatek86.com','Administratif'),(162,'Madden','Candace Stephens','03 38 89 94 86','nec.imperdiet@mediatek86.fr','Administratif'),(163,'Richardson','Alice Mcclure','03 23 23 38 27','vel.turpis@mediatek86.fr','Médiation culturelle'),(164,'Rivera','Wyoming Villarreal','08 16 69 33 32','mus@mediatek86.fr','Médiation culturelle'),(165,'Hubbard','Dolan Deleon','08 66 60 91 67','morbi.quis@mediatek86.fr','Médiation culturelle'),(166,'Hubbard','Phyllis Lowe','03 79 91 73 58','donec.egestas@mediatek86.fr','Administratif'),(167,'Levy','India Hutchinson','01 48 10 87 24','ac@mediatek86.com','Prêt'),(168,'Nash','Ciaran Kennedy','09 89 37 98 61','a@mediatek86.com','Administratif'),(169,'Chapman','Tiger Leonard','04 22 76 82 24','faucibus@mediatek86.com','Médiation culturelle'),(170,'Campbell','Rhoda Leonard','01 90 53 31 78','aliquam.erat@mediatek86.com','Médiation culturelle'),(171,'Lloyd','Mark Murphy','05 01 64 72 17','elit.sed@mediatek86.com','Administratif'),(172,'Lewis','Hamish Duncan','03 93 73 08 15','nibh.aliquam.ornare@mediatek86.fr','Médiation culturelle'),(173,'Espinoza','Griffin Newton','02 48 44 48 09','adipiscing@mediatek86.fr','Médiation culturelle'),(174,'Emerson','Kelly Farrell','09 72 31 96 92','ligula.aliquam@mediatek86.com','Médiation culturelle'),(175,'Horton','Zephr Blankenship','08 54 14 56 44','ac.urna@mediatek86.fr','Administratif'),(177,'Elliott','Clare Perez','06 52 43 02 18','morbi.tristique@mediatek86.com','Médiation culturelle'),(178,'Powers','Kenyon English','05 24 15 62 16','donec.tincidunt.donec@mediatek86.fr','Administratif'),(179,'Abbott','Phelan Bass','02 79 86 06 40','mauris.ipsum@mediatek86.fr','Administratif'),(180,'Preston','Hedley Lopez','02 60 89 68 33','ultrices@mediatek86.fr','Prêt'),(181,'Cruz','May Mcgee','03 28 63 36 65','sed.diam.lorem@mediatek86.com','Médiation culturelle'),(182,'James','Mark Raymond','01 46 15 16 31','urna.et.arcu@mediatek86.com','Administratif'),(183,'Ramos','Alexa Merrill','04 56 10 45 95','felis.orci.adipiscing@mediatek86.fr','Médiation culturelle'),(184,'Rush','Henry Wiley','06 12 66 66 35','risus.quis@mediatek86.fr','Administratif'),(187,'Bridges','Iris Ortega','02 58 57 51 91','a.arcu@mediatek86.com','Prêt'),(188,'Larsen','Nero Patterson','02 73 90 42 38','nunc.mauris.morbi@mediatek86.com','Prêt'),(189,'Serrano','Isabella Patterson','03 16 61 58 34','feugiat.metus@mediatek86.fr','Médiation culturelle'),(190,'Horn','Melvin Horton','05 55 33 88 89','nibh.donec.est@mediatek86.com','Médiation culturelle'),(191,'Mcdonald','Lael Nguyen','07 01 07 44 63','a.tortor@mediatek86.fr','Administratif'),(192,'Haynes','Arsenio Calhoun','06 23 53 81 31','gravida.non.sollicitudin@mediatek86.fr','Médiation culturelle'),(193,'Johnston','Adria Leblanc','02 57 56 30 97','quisque.varius.nam@mediatek86.com','Médiation culturelle'),(194,'Peterson','Hoyt Charles','03 34 71 21 57','etiam.laoreet@mediatek86.fr','Médiation culturelle'),(195,'Schwartz','Quynn Cardenas','04 10 80 76 34','nulla.integer@mediatek86.fr','Prêt'),(196,'Mccall','Ingrid Savage','05 86 83 27 53','iaculis@mediatek86.fr','Administratif'),(197,'Hurley','Uma Riddle','07 37 86 13 58','sit@mediatek86.fr','Médiation culturelle'),(198,'Erickson','Denton Davidson','05 58 98 97 14','ipsum.cursus@mediatek86.com','Médiation culturelle'),(199,'Sloan','Wanda Beck','03 39 36 52 10','at.pede@mediatek86.com','Administratif'),(200,'Burks','Rigel Warren','06 50 85 65 11','ultricies.ligula.nullam@mediatek86.fr','Médiation culturelle'),(201,'Hunt','Evelyn Carlson','03 44 46 36 17','mus.proin.vel@mediatek86.com','Administratif'),(202,'Madden','Candace Stephens','03 38 89 94 86','nec.imperdiet@mediatek86.fr','Administratif'),(203,'Richardson','Alice Mcclure','03 23 23 38 27','vel.turpis@mediatek86.fr','Médiation culturelle'),(204,'Rivera','Wyoming Villarreal','08 16 69 33 32','mus@mediatek86.fr','Médiation culturelle'),(205,'Hubbard','Dolan Deleon','08 66 60 91 67','morbi.quis@mediatek86.fr','Médiation culturelle'),(206,'Hubbard','Phyllis Lowe','03 79 91 73 58','donec.egestas@mediatek86.fr','Administratif'),(207,'Levy','India Hutchinson','01 48 10 87 24','ac@mediatek86.com','Prêt'),(208,'Nash','Ciaran Kennedy','09 89 37 98 61','a@mediatek86.com','Administratif'),(209,'Chapman','Tiger Leonard','04 22 76 82 24','faucibus@mediatek86.com','Médiation culturelle'),(210,'Campbell','Rhoda Leonard','01 90 53 31 78','aliquam.erat@mediatek86.com','Médiation culturelle'),(211,'Lloyd','Mark Murphy','05 01 64 72 17','elit.sed@mediatek86.com','Administratif'),(212,'Lewis','Hamish Duncan','03 93 73 08 15','nibh.aliquam.ornare@mediatek86.fr','Médiation culturelle'),(213,'Espinoza','Griffin Newton','02 48 44 48 09','adipiscing@mediatek86.fr','Médiation culturelle'),(214,'Emerson','Kelly Farrell','09 72 31 96 92','ligula.aliquam@mediatek86.com','Médiation culturelle'),(215,'Horton','Zephr Blankenship','08 54 14 56 44','ac.urna@mediatek86.fr','Administratif'),(217,'Elliott','Clare Perez','06 52 43 02 18','morbi.tristique@mediatek86.com','Médiation culturelle'),(218,'Powers','Kenyon English','05 24 15 62 16','donec.tincidunt.donec@mediatek86.fr','Administratif'),(219,'Abbott','Phelan Bass','02 79 86 06 40','mauris.ipsum@mediatek86.fr','Administratif'),(220,'Preston','Hedley Lopez','02 60 89 68 33','ultrices@mediatek86.fr','Prêt'),(221,'Cruz','May Mcgee','03 28 63 36 65','sed.diam.lorem@mediatek86.com','Médiation culturelle'),(222,'James','Mark Raymond','01 46 15 16 31','urna.et.arcu@mediatek86.com','Administratif'),(223,'Ramos','Alexa Merrill','04 56 10 45 95','felis.orci.adipiscing@mediatek86.fr','Médiation culturelle'),(224,'Rush','Henry Wiley','06 12 66 66 35','risus.quis@mediatek86.fr','Administratif');
/*!40000 ALTER TABLE `personnel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsable` (
  `idresponsable` int NOT NULL,
  `login` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idresponsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01 18:05:35
