/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.15 : Database - vfo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vfo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `vfo`;

/*Table structure for table `drivers` */

DROP TABLE IF EXISTS `drivers`;

CREATE TABLE `drivers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Secondname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Teamcode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Headpic` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Teamname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Carno` int(11) NOT NULL,
  `Shortname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dd` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=1000045 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `drivers` */

insert  into `drivers`(`id`,`Firstname`,`Secondname`,`Email`,`Teamcode`,`Headpic`,`Teamname`,`Carno`,`Shortname`,`Password`) values (1000016,'sd','dd','1246105940@qq.com','we','we','RacePoint',23,'seb','123456'),(1000041,'Ver','Max','124124@qq.com','','','RacePoint',3,'VER','wqweq'),(1000042,'王','强','11111@qq.com','','','RacePoint',16,'Wan','123456'),(1000043,'李','四','1234@qq.com','','','RacePoint',22,'LIS','123456'),(1000044,'张','三','1234567@qq.com','','','RacePoint',12,'ZHA','123456');

/*Table structure for table `matchrecords` */

DROP TABLE IF EXISTS `matchrecords`;

CREATE TABLE `matchrecords` (
  `matchid` varchar(16) DEFAULT NULL,
  `matchdate` varchar(16) DEFAULT NULL,
  `shortname` varchar(16) DEFAULT NULL,
  `carno` varchar(16) DEFAULT NULL,
  `matchtime` varchar(16) DEFAULT NULL,
  `points` varchar(16) DEFAULT NULL,
  `tname` varchar(16) DEFAULT NULL,
  `status` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `matchrecords` */

insert  into `matchrecords`(`matchid`,`matchdate`,`shortname`,`carno`,`matchtime`,`points`,`tname`,`status`) values ('10001','20200403','seb','23','','','RacePoint',0),('10002','20200506','seb','23','01:56:24','15','RacePoint',1),('10004','20200904','seb','23','','','RacePoint',0),('10034','20200423','ZHA','12','01:43:29','10','RacePoint',1);

/*Table structure for table `teampoints` */

DROP TABLE IF EXISTS `teampoints`;

CREATE TABLE `teampoints` (
  `tname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tpoints` int(16) DEFAULT NULL,
  `tmatches` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`tname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `teampoints` */

insert  into `teampoints`(`tname`,`tpoints`,`tmatches`) values ('2DW',233,'6'),('BTG',23,'14'),('DFR',234,'12'),('EDDW',21,'1'),('EDW',123,'12'),('FFR',213,'12'),('WDWQ',322,'21'),('WED',2,'1'),('WQ',0,'2'),('WQD',23,'56');

/*Table structure for table `teams` */

DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
  `Tname` varchar(16) NOT NULL,
  `Tleader` varchar(16) DEFAULT NULL,
  `Tpoints` int(20) DEFAULT NULL,
  `Tcode` varchar(16) NOT NULL,
  `Tlogo` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Tname`),
  UNIQUE KEY `Tcode` (`Tcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `teams` */

insert  into `teams`(`Tname`,`Tleader`,`Tpoints`,`Tcode`,`Tlogo`) values ('RacePoint','RT',0,'1234d','qddqw');

/*Table structure for table `users_test` */

DROP TABLE IF EXISTS `users_test`;

CREATE TABLE `users_test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `users_test` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
