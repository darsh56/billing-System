/*
SQLyog Ultimate v8.55 
MySQL - 5.6.13 : Database - billing
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`billing` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `billing`;

/*Table structure for table `challninvoice` */

DROP TABLE IF EXISTS `challninvoice`;

CREATE TABLE `challninvoice` (
  `Dcno` bigint(5) NOT NULL DEFAULT '0',
  `Invoicetype` varchar(25) DEFAULT NULL,
  `Client_id` int(11) DEFAULT NULL,
  `Dcndate` varchar(15) DEFAULT NULL,
  `PO_No` varchar(20) DEFAULT NULL,
  `Partname` varchar(30) DEFAULT NULL,
  `Descr` varchar(50) DEFAULT NULL,
  `Qut` bigint(10) DEFAULT NULL,
  `Rate` float DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Exicechano` varchar(15) DEFAULT NULL,
  `Exicedate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Dcno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `challninvoice` */

insert  into `challninvoice`(`Dcno`,`Invoicetype`,`Client_id`,`Dcndate`,`PO_No`,`Partname`,`Descr`,`Qut`,`Rate`,`Amount`,`Exicechano`,`Exicedate`) values (1,'Retail',10,'30/04/2015','A10002','10','DesignTool',2,75,150,'',''),(2,'JobWork',11,'29/04/2015','A10003','9','metal',3,500,1500,'E01','28/04/2015'),(3,'Tax',12,'27/04/2015','A10001','10','DesignTool',1,90,90,'','');

/*Table structure for table `city_entry` */

DROP TABLE IF EXISTS `city_entry`;

CREATE TABLE `city_entry` (
  `City_id` int(11) NOT NULL AUTO_INCREMENT,
  `State_id` int(11) DEFAULT NULL,
  `City_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`City_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `city_entry` */

insert  into `city_entry`(`City_id`,`State_id`,`City_Name`) values (2,1,'Gandhinagar'),(3,6,'Chandigarh'),(5,7,'Panji'),(6,9,'Kashmir'),(7,10,'Kolkata'),(8,8,'NewDelhi'),(9,1,'Ahmedabad'),(27,7,'Malbar'),(29,54,'Shilong'),(32,9,'Srinagar');

/*Table structure for table `detailsforline` */

DROP TABLE IF EXISTS `detailsforline`;

CREATE TABLE `detailsforline` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `PO_No` varchar(20) DEFAULT NULL,
  `Serial_No` int(11) DEFAULT NULL,
  `Part_Name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PO_No` (`PO_No`),
  CONSTRAINT `PO_No` FOREIGN KEY (`PO_No`) REFERENCES `purchase_details` (`PO_No`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detailsforline` */

/*Table structure for table `form_client` */

DROP TABLE IF EXISTS `form_client`;

CREATE TABLE `form_client` (
  `Client_id` int(11) NOT NULL AUTO_INCREMENT,
  `Company_Name` varchar(25) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `State` varchar(25) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  `Pincode` varchar(15) DEFAULT NULL,
  `PhoneNo` varchar(15) DEFAULT NULL,
  `Fax` varchar(25) DEFAULT NULL,
  `Emailid` varchar(25) DEFAULT NULL,
  `TinNo` varchar(15) DEFAULT NULL,
  `VatNo` varchar(15) DEFAULT NULL,
  `Policy_Deal_Days` varchar(15) DEFAULT NULL,
  `STC_code` varchar(45) DEFAULT NULL,
  `STC_Date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `form_client` */

insert  into `form_client`(`Client_id`,`Company_Name`,`Address`,`State`,`City`,`Pincode`,`PhoneNo`,`Fax`,`Emailid`,`TinNo`,`VatNo`,`Policy_Deal_Days`,`STC_code`,`STC_Date`) values (10,'Atlant','1-A,ABC Plaza,ST Road,Ahmedabad','1','9','123456','1234567890','123456789011','To@gmail.com','234156234512','998765432123','5','543627189012','01/04/2015'),(11,'Venus','2-A,Satyam Arcade,Gandhinagar','1','2','382714','2345677800','214365870900','abcd@gmail.com','234156234513','998765432122','5','543627189012','02/04/2015'),(12,'Jupitor','3-B,Bhavani Mall,New Delhi','8','8','384567','1234567892','123456789013','test@gmail.com','234156234513','998765432121','5','543627189013','03/04/2015');

/*Table structure for table `jobwork` */

DROP TABLE IF EXISTS `jobwork`;

CREATE TABLE `jobwork` (
  `Jobno` varchar(10) DEFAULT NULL,
  `Dcno` bigint(5) DEFAULT NULL,
  `Compnm` varchar(50) DEFAULT NULL,
  `Invodate` varchar(15) DEFAULT NULL,
  `Beno` bigint(10) DEFAULT NULL,
  `Courchar` bigint(10) DEFAULT NULL,
  `Bedate` varchar(15) DEFAULT NULL,
  `Totamo` float DEFAULT NULL,
  `Trchno` bigint(10) DEFAULT NULL,
  `Sertax1` bigint(10) DEFAULT NULL,
  `Sertax2` float DEFAULT NULL,
  `Trchdate` varchar(15) DEFAULT NULL,
  `Educess1` bigint(10) DEFAULT NULL,
  `Educess2` float DEFAULT NULL,
  `Addduty` bigint(10) DEFAULT NULL,
  `Hieducess1` bigint(10) DEFAULT NULL,
  `Hieducess2` float DEFAULT NULL,
  `Affamount` float DEFAULT NULL,
  `Rdoff` float DEFAULT NULL,
  `Netamount` bigint(10) DEFAULT NULL,
  `Netamword` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jobwork` */

insert  into `jobwork`(`Jobno`,`Dcno`,`Compnm`,`Invodate`,`Beno`,`Courchar`,`Bedate`,`Totamo`,`Trchno`,`Sertax1`,`Sertax2`,`Trchdate`,`Educess1`,`Educess2`,`Addduty`,`Hieducess1`,`Hieducess2`,`Affamount`,`Rdoff`,`Netamount`,`Netamword`) values ('JB1',2,'Venus','13/04/2015',1,700,'26/04/2015',711,1,10,69.678,'01/05/2015',9,6.20134,700,5,3.4839,790.363,0.36,790,' Seven Hundred Ninety Rupees Only');

/*Table structure for table `logintab` */

DROP TABLE IF EXISTS `logintab`;

CREATE TABLE `logintab` (
  `id` int(11) NOT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `logintab` */

insert  into `logintab`(`id`,`Username`,`Password`) values (1,'admin','admin'),(2,'staff','staff');

/*Table structure for table `partmaster` */

DROP TABLE IF EXISTS `partmaster`;

CREATE TABLE `partmaster` (
  `Partid` int(11) NOT NULL AUTO_INCREMENT,
  `PartNo` varchar(15) DEFAULT NULL,
  `PartName` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Partid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `partmaster` */

insert  into `partmaster`(`Partid`,`PartNo`,`PartName`,`Description`) values (9,'1201','setmetal','metal'),(10,'1202','Qubo','DesignTool'),(11,'1203','Finisher','FinishingTool');

/*Table structure for table `purchase_details` */

DROP TABLE IF EXISTS `purchase_details`;

CREATE TABLE `purchase_details` (
  `PO_No` varchar(20) NOT NULL,
  `Client_id` int(11) DEFAULT NULL,
  `Date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PO_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchase_details` */

insert  into `purchase_details`(`PO_No`,`Client_id`,`Date`) values ('A10001',12,'04/04/2015'),('A10002',10,'08/04/2015'),('A10003',11,'08/04/2015');

/*Table structure for table `purchaseorderline` */

DROP TABLE IF EXISTS `purchaseorderline`;

CREATE TABLE `purchaseorderline` (
  `Polineno` int(10) NOT NULL AUTO_INCREMENT,
  `PO_No` varchar(20) DEFAULT NULL,
  `Serial_No` int(11) DEFAULT NULL,
  `Part_Name` varchar(20) DEFAULT NULL,
  `Part_desc` varchar(20) DEFAULT NULL,
  `Line_No` int(11) DEFAULT NULL,
  `DueDate` varchar(30) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Rate` int(11) DEFAULT NULL,
  `Amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`Polineno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `purchaseorderline` */

insert  into `purchaseorderline`(`Polineno`,`PO_No`,`Serial_No`,`Part_Name`,`Part_desc`,`Line_No`,`DueDate`,`Quantity`,`Rate`,`Amount`) values (12,'A10001',1,'10','DesignTool',1,'05/04/2015',1,90,90),(13,'A10002',2,'10','DesignTool',1,'09/04/2015',2,75,150),(14,'A10003',1,'9','metal',1,'06/01/2015',3,500,1500);

/*Table structure for table `retailinvoice` */

DROP TABLE IF EXISTS `retailinvoice`;

CREATE TABLE `retailinvoice` (
  `Retailno` varchar(10) NOT NULL,
  `Dcno` bigint(5) DEFAULT NULL,
  `CompanyName` varchar(20) DEFAULT NULL,
  `Invodate` varchar(15) DEFAULT NULL,
  `Beno` bigint(10) DEFAULT NULL,
  `Courchar` bigint(10) DEFAULT NULL,
  `Bedate` varchar(15) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Trchno` bigint(10) DEFAULT NULL,
  `Formtype` varchar(20) DEFAULT NULL,
  `Trchdate` varchar(15) DEFAULT NULL,
  `Cst_vat1` bigint(10) DEFAULT NULL,
  `Cst_vat2` float DEFAULT NULL,
  `Addduty` bigint(10) DEFAULT NULL,
  `Affamount` float DEFAULT NULL,
  `Rdoff` float DEFAULT NULL,
  `Netamount` bigint(10) DEFAULT NULL,
  `Netamword` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`Retailno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `retailinvoice` */

insert  into `retailinvoice`(`Retailno`,`Dcno`,`CompanyName`,`Invodate`,`Beno`,`Courchar`,`Bedate`,`Amount`,`Trchno`,`Formtype`,`Trchdate`,`Cst_vat1`,`Cst_vat2`,`Addduty`,`Affamount`,`Rdoff`,`Netamount`,`Netamword`) values ('R1',1,'Atlant','30/04/2015',1,250,'07/04/2015',260,2,'Against C Form','09/04/2015',5,11.7,5,271.7,0.3,272,' Two Hundred and Seventy Two Rupees Only');

/*Table structure for table `state_entry` */

DROP TABLE IF EXISTS `state_entry`;

CREATE TABLE `state_entry` (
  `State_id` int(11) NOT NULL AUTO_INCREMENT,
  `State_Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`State_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `state_entry` */

insert  into `state_entry`(`State_id`,`State_Name`) values (1,'Gujrat'),(2,'Maharashtra'),(6,'Punjab'),(7,'Goa'),(8,'Delhi'),(9,'Jammu'),(50,'Rajastan'),(54,'Megalaya');

/*Table structure for table `taxinvoice` */

DROP TABLE IF EXISTS `taxinvoice`;

CREATE TABLE `taxinvoice` (
  `Taxno` varchar(10) NOT NULL,
  `Dcno` bigint(5) DEFAULT NULL,
  `Compnm` varchar(50) DEFAULT NULL,
  `Invodate` varchar(15) DEFAULT NULL,
  `Beno` bigint(10) DEFAULT NULL,
  `Courchar` bigint(10) DEFAULT NULL,
  `Bedate` varchar(15) DEFAULT NULL,
  `Totamo` float DEFAULT NULL,
  `Trchno` bigint(10) DEFAULT NULL,
  `Vat1` bigint(10) DEFAULT NULL,
  `Vat2` float DEFAULT NULL,
  `Trchdate` varchar(15) DEFAULT NULL,
  `Addvat1` bigint(10) DEFAULT NULL,
  `Addvat2` float DEFAULT NULL,
  `Addduty` bigint(10) DEFAULT NULL,
  `Affamount` float DEFAULT NULL,
  `Rdoff` float DEFAULT NULL,
  `Netamount` bigint(10) DEFAULT NULL,
  `Netamword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Taxno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `taxinvoice` */

insert  into `taxinvoice`(`Taxno`,`Dcno`,`Compnm`,`Invodate`,`Beno`,`Courchar`,`Bedate`,`Totamo`,`Trchno`,`Vat1`,`Vat2`,`Trchdate`,`Addvat1`,`Addvat2`,`Addduty`,`Affamount`,`Rdoff`,`Netamount`,`Netamword`) values ('T1',3,'Jupitor','22/04/2015',1,45,'29/04/2015',57,1,6,3.42,'30/04/2015',670,381.9,450,442.32,0.32,442,' Four Hundred and Forty Two Rupees Only');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
