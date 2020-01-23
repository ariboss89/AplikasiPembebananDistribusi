# Host: localhost  (Version: 5.5.8)
# Date: 2020-01-23 17:03:57
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `konfirmasi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES ('andy123','Andy','ULP KAWAL','123456','123456'),('ariboss89','Ari Ramadhan','UP3 TANJUNGPINANG','123456','123456'),('superadmin','superadmin','SUPERADMIN','123456','123456');

#
# Structure for table "bebangardu"
#

DROP TABLE IF EXISTS `bebangardu`;
CREATE TABLE `bebangardu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nogardu` varchar(20) DEFAULT NULL,
  `rute` varchar(10) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jam` int(11) DEFAULT NULL,
  `menit` int(11) DEFAULT NULL,
  `r` int(11) DEFAULT NULL,
  `s` int(11) DEFAULT NULL,
  `t` int(11) DEFAULT NULL,
  `ratarata` int(11) DEFAULT NULL,
  `n` int(11) DEFAULT NULL,
  `bebankva` double(4,2) DEFAULT NULL,
  `bebanpersen` double(4,2) DEFAULT NULL,
  `rs` double(2,0) DEFAULT NULL,
  `rt` double(2,0) DEFAULT NULL,
  `st` double(2,0) DEFAULT NULL,
  `rn` double(2,0) DEFAULT NULL,
  `sn` double(2,0) DEFAULT NULL,
  `tn` double(2,0) DEFAULT NULL,
  `unbalance` double(4,2) DEFAULT NULL,
  `ket` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "bebangardu"
#

/*!40000 ALTER TABLE `bebangardu` DISABLE KEYS */;
INSERT INTO `bebangardu` VALUES (6,'123456','A','2020-01-22',12,30,90,80,70,80,80,12.46,4.15,90,70,80,80,80,90,22.22,'Perlu Penyeimbangan','UP3 TANJUNGPINANG'),(7,'123456','A','2020-01-30',18,30,80,70,70,73,80,11.42,3.81,90,80,80,80,60,90,12.50,'Ok','a');
/*!40000 ALTER TABLE `bebangardu` ENABLE KEYS */;

#
# Structure for table "datagardu"
#

DROP TABLE IF EXISTS `datagardu`;
CREATE TABLE `datagardu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `namaunit` varchar(100) DEFAULT NULL,
  `nomorgardu` varchar(50) DEFAULT NULL,
  `merk` varchar(50) DEFAULT NULL,
  `nomorseri` varchar(50) DEFAULT NULL,
  `daya` int(11) DEFAULT NULL,
  `inomseca` double DEFAULT NULL,
  `primer` int(11) DEFAULT NULL,
  `sekunder` int(11) DEFAULT NULL,
  `jumlahrute` int(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Data for table "datagardu"
#

INSERT INTO `datagardu` VALUES (1,'UP3 TANJUNGPINANG','123456','Trafindo','12345678',300,207.6,100,120,1,'2020-01-09','AW'),(2,'UP3 TANJUNGPINANG','67891','Trafindo','09809707090',12000,8304,1000,1300,1,'2020-01-21','Jl. Manise');

#
# Structure for table "unit"
#

DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "unit"
#

INSERT INTO `unit` VALUES (1,'UP3 TANJUNGPINANG');
