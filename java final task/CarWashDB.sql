CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `plate_numbers` varchar(8) NOT NULL,
  `owner` int(11) NOT NULL,
  `type` varchar(9) NOT NULL,
  PRIMARY KEY (`plate_numbers`),
  UNIQUE KEY `plate_numbers_UNIQUE` (`plate_numbers`),
  KEY `fk_Car_Client_idx` (`owner`),
  KEY `fk_Car_Car_Type1_idx` (`type`),
  CONSTRAINT `fk_Car_Client` FOREIGN KEY (`owner`) REFERENCES `client` (`id_client`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('AA3218BB',3,'jeep'),('AB1234AB',2,'passenger'),('AC9999',3,'minibus'),('OC0808OC',1,'passenger');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car_type`
--

DROP TABLE IF EXISTS `car_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car_type` (
  `id` varchar(9) NOT NULL,
  `price_coef` decimal(2,1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car_type`
--

LOCK TABLES `car_type` WRITE;
/*!40000 ALTER TABLE `car_type` DISABLE KEYS */;
INSERT INTO `car_type` VALUES ('jeep',1.5),('minibus',2.0),('passenger',1.0);
/*!40000 ALTER TABLE `car_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `car_count` int(1) NOT NULL DEFAULT '0',
  `service_count` int(2) NOT NULL DEFAULT '0',
  `phone_number` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `idClient_UNIQUE` (`id_client`),
  KEY `fk_Client_Discount1_idx` (`service_count`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Ivanov','male',1,1,'+30001112233'),(2,'Olya','male',2,2,'+380509265404'),(3,'Pupkin','male',2,1,'+27462957264'),(6,'asfas','female',2,2,'412411224114');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount` (
  `service_count` int(11) NOT NULL,
  `price` decimal(2,1) NOT NULL,
  PRIMARY KEY (`service_count`),
  UNIQUE KEY `service count_UNIQUE` (`service_count`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (0,1.0),(10,0.9),(20,0.7),(40,0.5);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `premium`
--

DROP TABLE IF EXISTS `premium`;
/*!50001 DROP VIEW IF EXISTS `premium`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `premium` AS SELECT 
 1 AS `id_worker`,
 1 AS `name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `report_all`
--

DROP TABLE IF EXISTS `report_all`;
/*!50001 DROP VIEW IF EXISTS `report_all`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `report_all` AS SELECT 
 1 AS `service_id`,
 1 AS `date`,
 1 AS `car_id`,
 1 AS `sum`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `date` date NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`date`,`worker_id`),
  KEY `fk_Schedule_Worker1_idx` (`worker_id`),
  CONSTRAINT `fk_Schedule_Worker1` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id_worker`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES ('2017-05-10',1),('2017-05-11',1),('2017-05-11',2),('2017-05-12',2),('2017-05-13',2),('2017-05-20',2),('2017-05-10',3),('2017-05-12',3),('2017-05-18',3),('2017-05-13',4),('2017-06-08',5),('2017-05-26',6),('2017-06-01',6),('2017-05-30',7),('2017-06-10',7),('2017-06-12',7);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `car_id` varchar(8) NOT NULL,
  `worker_id` int(11) NOT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_id_UNIQUE` (`service_id`),
  KEY `fk_Service_Car1_idx` (`car_id`),
  KEY `fk_Service_Worker1_idx` (`worker_id`),
  CONSTRAINT `fk_Service_Car1` FOREIGN KEY (`car_id`) REFERENCES `car` (`plate_numbers`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_Worker1` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id_worker`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'2017-02-17','OC0808OC',4),(2,'2016-12-12','AA3218BB',2),(3,'2016-12-11','AC9999',2),(4,'2016-12-21','AC9999',3);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_has_work`
--

DROP TABLE IF EXISTS `service_has_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_has_work` (
  `service_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`service_id`,`work_id`),
  KEY `fk_Service_has_Work_Work1_idx` (`work_id`),
  CONSTRAINT `fk_Service_has_Work_Service1` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_has_Work_Work1` FOREIGN KEY (`work_id`) REFERENCES `work` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_has_work`
--

LOCK TABLES `service_has_work` WRITE;
/*!40000 ALTER TABLE `service_has_work` DISABLE KEYS */;
INSERT INTO `service_has_work` VALUES (1,1,200.00),(1,2,300.00),(2,1,300.00),(3,1,400.00),(4,1,400.00),(4,2,600.00);
/*!40000 ALTER TABLE `service_has_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `service_report`
--

DROP TABLE IF EXISTS `service_report`;
/*!50001 DROP VIEW IF EXISTS `service_report`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `service_report` AS SELECT 
 1 AS `service_id`,
 1 AS `date`,
 1 AS `car_id`,
 1 AS `count_service_sum(service.service_id)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `price` decimal(5,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `description_UNIQUE` (`description`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'wash car',200.00),(2,'clean inside',300.00);
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `worker` (
  `id_worker` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id_worker`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (1,'Lisa'),(2,'Ivan'),(3,'Jack'),(4,'John'),(5,'Vasyl'),(6,'Anton'),(7,'Snoop Dogg');
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `working_days`
--

DROP TABLE IF EXISTS `working_days`;
/*!50001 DROP VIEW IF EXISTS `working_days`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `working_days` AS SELECT 
 1 AS `id_worker`,
 1 AS `name`,
 1 AS `count(*)`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `premium`
--

/*!50001 DROP VIEW IF EXISTS `premium`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `premium` AS select `worker`.`id_worker` AS `id_worker`,`worker`.`name` AS `name` from `worker` where `worker`.`id_worker` in (select `s1`.`worker_id` from `schedule` `s1` where ((select count(0) from `schedule` `s2` where (`s2`.`worker_id` = `s1`.`worker_id`)) > 2)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `report_all`
--

/*!50001 DROP VIEW IF EXISTS `report_all`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `report_all` AS select `service`.`service_id` AS `service_id`,`service`.`date` AS `date`,`service`.`car_id` AS `car_id`,sum(`service_has_work`.`price`) AS `sum` from (`service` join `service_has_work` on((`service`.`service_id` = `service_has_work`.`service_id`))) group by `service`.`service_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `service_report`
--

/*!50001 DROP VIEW IF EXISTS `service_report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `service_report` AS select distinct `service`.`service_id` AS `service_id`,`service`.`date` AS `date`,`service`.`car_id` AS `car_id`,`count_service_sum`(`service`.`service_id`) AS `count_service_sum(service.service_id)` from (`service` join `service_has_work`) where (`service`.`service_id` = `service_has_work`.`service_id`) order by `service`.`service_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `working_days`
--

/*!50001 DROP VIEW IF EXISTS `working_days`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `working_days` AS select `worker`.`id_worker` AS `id_worker`,`worker`.`name` AS `name`,count(0) AS `count(*)` from (`worker` join `schedule` on((`worker`.`id_worker` = `schedule`.`worker_id`))) group by `schedule`.`worker_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-26 17:43:58
