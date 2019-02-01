/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.23 : Database - zhump_blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhump_blog` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `zhump_blog`;

/*Table structure for table `resources` */

DROP TABLE IF EXISTS `resources`;

CREATE TABLE `resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `permissions_url` varchar(255) DEFAULT NULL,
  `permissions_value` varchar(64) DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `resources` */

/*Table structure for table `role_info` */

DROP TABLE IF EXISTS `role_info`;

CREATE TABLE `role_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `role_info` */

/*Table structure for table `role_resources` */

DROP TABLE IF EXISTS `role_resources`;

CREATE TABLE `role_resources` (
  `role_id` bigint(20) DEFAULT NULL,
  `resources_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `role_resources` */

/*Table structure for table `system_log` */

DROP TABLE IF EXISTS `system_log`;

CREATE TABLE `system_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `operation` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `platform` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4;

/*Data for the table `system_log` */

insert  into `system_log`(`id`,`user_name`,`operation`,`ip`,`url`,`platform`,`message`,`create_time`) values (1,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=64D823F714812517068F72F5E4C90776','IntelliJ IDEA/182.4129.33',NULL,'2018-09-04 17:22:42'),(2,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=A25F4B1576F12FF504D2B44548E3E852','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:22:43'),(3,'','username=zhump&password=123456','127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:33:00'),(4,'','username=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:33:30'),(5,'','name=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:33:54'),(6,'','name=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:36:23'),(7,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=0A7591C4B4FB1221570B6CCF518A9128','IntelliJ IDEA/182.4129.33',NULL,'2018-09-04 17:37:34'),(8,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:37:35'),(9,'','name=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:38:08'),(10,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=F2360F0933A608C0BF4790FF7A588B08','IntelliJ IDEA/182.4129.33',NULL,'2018-09-04 17:39:34'),(11,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:39:35'),(12,'zhump','name=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:39:51'),(13,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-04 17:44:13'),(14,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=F557A0B777183CDD7D039BA876D5FB09','IntelliJ IDEA/182.4129.33',NULL,'2018-09-07 10:25:05'),(15,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=72F3F8C55DCBB87632018EF75D80045B','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:25:09'),(16,'zhump','name=zhump&password=123456','127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:25:50'),(17,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=72F3F8C55DCBB87632018EF75D80045B','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:29:20'),(18,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:29:28'),(19,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:29:32'),(20,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:29:51'),(21,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=72F3F8C55DCBB87632018EF75D80045B','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:34:32'),(22,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:34:40'),(23,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=72F3F8C55DCBB87632018EF75D80045B','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:35:06'),(24,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:35:15'),(25,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:35:22'),(26,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action;jsessionid=72F3F8C55DCBB87632018EF75D80045B','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:39:26'),(27,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:39:39'),(28,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:39:51'),(29,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:40:00'),(30,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:40:44'),(31,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:40:54'),(32,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:42:11'),(33,'zhump',NULL,'127.0.0.1','/zhump_blog/user/list.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:43:55'),(34,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action;jsessionid=0F903E9AA4DBD23234F7AF13D54BD0E0','IntelliJ IDEA/182.4129.33',NULL,'2018-09-07 10:50:13'),(35,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:50:14'),(36,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:50:24'),(37,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:50:29'),(38,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:50:39'),(39,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 10:51:41'),(40,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:26:01'),(41,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:26:03'),(42,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:27:38'),(43,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:27:38'),(44,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:27:44'),(45,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:34'),(46,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:34'),(47,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:37'),(48,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:37'),(49,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:40'),(50,'',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:42'),(51,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:28:43'),(52,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action;jsessionid=9BEB7B141896C39EC50BEC4E804E85AC','IntelliJ IDEA/182.4129.33',NULL,'2018-09-07 13:29:08'),(53,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action;jsessionid=CB077E82A7BD62A2F84DB45180002ACA','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:29:10'),(54,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:29:19'),(55,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:29:28'),(56,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:30:11'),(57,'',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:34:21'),(58,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/login.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:34:30'),(59,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:34:30'),(60,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:36:15'),(61,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:45:57'),(62,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:46:29'),(63,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:48:04'),(64,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:49:48'),(65,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:50:45'),(66,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:50:47'),(67,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:50:48'),(68,'zhump',NULL,'127.0.0.1','/zhump_blog/sso/index.action','Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0',NULL,'2018-09-07 13:52:33');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `login_num` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `login_time` timestamp NULL DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `locked` int(2) DEFAULT NULL COMMENT '用户锁 0不正常 1 正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`name`,`password`,`salt`,`address`,`head_img`,`login_num`,`create_time`,`update_time`,`login_time`,`email`,`phone`,`locked`) values (1,'zhump','a1a21d278194b66fa13c2c103b9f0560','6282800d720d45d188619380a79a1057',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'18607122704',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
