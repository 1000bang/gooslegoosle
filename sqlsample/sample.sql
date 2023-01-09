-- MySQL dump 10.13  Distrib 8.0.31, for macos13.0 (arm64)
--
-- Host: localhost    Database: gooslegoosle
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ImageEntity`
--

DROP TABLE IF EXISTS `ImageEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ImageEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `originFileName` varchar(255) DEFAULT NULL,
  `postImageUrl` varchar(255) DEFAULT NULL,
  `storeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5peukxeynene7xh8lsllkywse` (`storeId`),
  CONSTRAINT `FK5peukxeynene7xh8lsllkywse` FOREIGN KEY (`storeId`) REFERENCES `StoreEntity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ImageEntity`
--

LOCK TABLES `ImageEntity` WRITE;
/*!40000 ALTER TABLE `ImageEntity` DISABLE KEYS */;
INSERT INTO `ImageEntity` VALUES (1,'명동교자.jpg','aa58027b-5346-46af-acc6-5cd7bc9a50e7_명동교자.jpg',1),(2,'명동교자2.jpg','aa58027b-5346-46af-acc6-5cd7bc9a50e7_명동교자2.jpg',1),(3,'명동교자3.jpg','aa58027b-5346-46af-acc6-5cd7bc9a50e7_명동교자3.jpg',1),(4,'도마1.jpg','7f822e67-6391-4cc7-9a4d-bbe03389eee2_도마1.jpg',2),(5,'도마2.jpg','7f822e67-6391-4cc7-9a4d-bbe03389eee2_도마2.jpg',2),(6,'도마3.jpg','7f822e67-6391-4cc7-9a4d-bbe03389eee2_도마3.jpg',2),(7,'멘야1.jpg','ffc0169e-2763-4e80-b7be-bfca397c62fd_멘야1.jpg',3),(8,'멘야2.jpg','ffc0169e-2763-4e80-b7be-bfca397c62fd_멘야2.jpg',3),(9,'멘야3.jpg','ffc0169e-2763-4e80-b7be-bfca397c62fd_멘야3.jpg',3),(10,'리틀넥1.jpg','d4b55b0a-246c-49a1-9a66-3068faa485fe_리틀넥1.jpg',4),(11,'리틀넥2.jpg','d4b55b0a-246c-49a1-9a66-3068faa485fe_리틀넥2.jpg',4),(12,'리틀넥3.jpg','d4b55b0a-246c-49a1-9a66-3068faa485fe_리틀넥3.jpg',4),(13,'진주2.jpg','8c1001f2-d63d-4485-8f84-40cd844b7659_진주2.jpg',5),(14,'진주3.jpg','8c1001f2-d63d-4485-8f84-40cd844b7659_진주3.jpg',5),(15,'진주main.jpg','8c1001f2-d63d-4485-8f84-40cd844b7659_진주main.jpg',5),(16,'원흥.jpg','45b57582-8b39-4ca9-90fd-6dbd055cf59f_원흥.jpg',6),(17,'원흥1.jpg','45b57582-8b39-4ca9-90fd-6dbd055cf59f_원흥1.jpg',6),(18,'원흥2.jpg','45b57582-8b39-4ca9-90fd-6dbd055cf59f_원흥2.jpg',6),(19,'농민.jpg','3b68c65a-d71d-4973-823c-8bd0de0a4b38_농민.jpg',7),(20,'농민1.jpg','3b68c65a-d71d-4973-823c-8bd0de0a4b38_농민1.jpg',7),(21,'농민2.jpg','3b68c65a-d71d-4973-823c-8bd0de0a4b38_농민2.jpg',7),(22,'고도식.jpg','ed7e5152-12da-407e-9e0a-f4b81454d279_고도식.jpg',8),(23,'고도식1.jpg','ed7e5152-12da-407e-9e0a-f4b81454d279_고도식1.jpg',8),(24,'고도식2.jpg','ed7e5152-12da-407e-9e0a-f4b81454d279_고도식2.jpg',8),(25,'요멘야.jpg','d889b997-2e49-42c1-b9c9-e089dcc4a20d_요멘야.jpg',9),(26,'요멘야1.jpg','d889b997-2e49-42c1-b9c9-e089dcc4a20d_요멘야1.jpg',9),(27,'요멘야2.jpg','d889b997-2e49-42c1-b9c9-e089dcc4a20d_요멘야2.jpg',9),(28,'깡통.jpg','6f017f73-ca2d-4392-b251-50c274e61ab0_깡통.jpg',10),(29,'깡통1.jpg','6f017f73-ca2d-4392-b251-50c274e61ab0_깡통1.jpg',10),(30,'깡통2.jpg','6f017f73-ca2d-4392-b251-50c274e61ab0_깡통2.jpg',10),(31,'어글리.jpg','a7079d79-766a-4d9c-8838-c3bf6d57a865_어글리.jpg',11),(32,'어글리1.jpg','a7079d79-766a-4d9c-8838-c3bf6d57a865_어글리1.jpg',11),(33,'어글리2.jpg','a7079d79-766a-4d9c-8838-c3bf6d57a865_어글리2.jpg',11),(34,'정돈.jpg','83970545-0d08-4fa2-9c1d-0c0174e4bc83_정돈.jpg',12),(35,'정돈1.jpg','83970545-0d08-4fa2-9c1d-0c0174e4bc83_정돈1.jpg',12),(36,'정돈2.jpg','83970545-0d08-4fa2-9c1d-0c0174e4bc83_정돈2.jpg',12),(37,'호호.jpg','810af07e-7672-4796-8c02-c78a26af1ee8_호호.jpg',13),(38,'호호1.jpg','810af07e-7672-4796-8c02-c78a26af1ee8_호호1.jpg',13),(39,'호호2.jpg','810af07e-7672-4796-8c02-c78a26af1ee8_호호2.jpg',13),(40,'오레노2.jpg','1488e622-bb0e-4b6d-b21d-3f19729e39cd_오레노2.jpg',14),(41,'오레노라멘1.jpg','1488e622-bb0e-4b6d-b21d-3f19729e39cd_오레노라멘1.jpg',14),(42,'오레노라멘main.jpg','1488e622-bb0e-4b6d-b21d-3f19729e39cd_오레노라멘main.jpg',14),(43,'다운.jpg','145305d3-df73-478f-91b0-a6687f3a6768_다운.jpg',15),(44,'다운1.jpg','145305d3-df73-478f-91b0-a6687f3a6768_다운1.jpg',15),(45,'다운2.jpg','145305d3-df73-478f-91b0-a6687f3a6768_다운2.jpg',15),(46,'보니스.jpg','f061fd68-5ec9-4999-9007-21d0650bcdf4_보니스.jpg',16),(47,'보니스1.jpg','f061fd68-5ec9-4999-9007-21d0650bcdf4_보니스1.jpg',16),(48,'보니스2.jpg','f061fd68-5ec9-4999-9007-21d0650bcdf4_보니스2.jpg',16),(49,'스미스.jpg','f7d84623-ca83-472b-957a-1c3550ef0865_스미스.jpg',17),(50,'스미스1.jpg','f7d84623-ca83-472b-957a-1c3550ef0865_스미스1.jpg',17),(51,'스미스2.jpg','f7d84623-ca83-472b-957a-1c3550ef0865_스미스2.jpg',17),(52,'이재모.jpg','bf8796d3-e00b-4f11-b1e0-4e728b7deb53_이재모.jpg',18),(53,'이재모1.jpg','bf8796d3-e00b-4f11-b1e0-4e728b7deb53_이재모1.jpg',18),(54,'이재모2.jpg','bf8796d3-e00b-4f11-b1e0-4e728b7deb53_이재모2.jpg',18),(55,'라디오.jpg','e703640d-a25a-4312-b06f-2d12910ea7b5_라디오.jpg',19),(56,'라디오1.jpg','e703640d-a25a-4312-b06f-2d12910ea7b5_라디오1.jpg',19),(57,'라디오2.jpg','e703640d-a25a-4312-b06f-2d12910ea7b5_라디오2.jpg',19),(58,'대가방.jpg','8cbe6324-e457-4038-9cdf-d7db14d2d9e4_대가방.jpg',20),(59,'대가방1.jpg','8cbe6324-e457-4038-9cdf-d7db14d2d9e4_대가방1.jpg',20),(60,'대가방2.jpg','8cbe6324-e457-4038-9cdf-d7db14d2d9e4_대가방2.jpg',20),(61,'신승.jpg','4d76fabf-8c80-4614-a3d3-02993ac747ac_신승.jpg',21),(62,'신승1.jpg','4d76fabf-8c80-4614-a3d3-02993ac747ac_신승1.jpg',21),(63,'신승2.jpg','4d76fabf-8c80-4614-a3d3-02993ac747ac_신승2.jpg',21),(64,'송화.jpg','fc64c690-56e7-4568-a715-a35051ba672f_송화.jpg',22),(65,'송화1.jpg','fc64c690-56e7-4568-a715-a35051ba672f_송화1.jpg',22),(66,'송화2.jpg','fc64c690-56e7-4568-a715-a35051ba672f_송화2.jpg',22),(67,'산동.jpg','687ea0ef-5d3a-44f6-9180-4409cd6a004d_산동.jpg',23),(68,'산동1.jpg','687ea0ef-5d3a-44f6-9180-4409cd6a004d_산동1.jpg',23),(69,'산동2.jpg','687ea0ef-5d3a-44f6-9180-4409cd6a004d_산동2.jpg',23),(70,'우육.jpg','045f5f95-93ad-4d36-a882-fde843188f41_우육.jpg',24),(71,'우육1.jpg','045f5f95-93ad-4d36-a882-fde843188f41_우육1.jpg',24),(72,'우육2.jpg','045f5f95-93ad-4d36-a882-fde843188f41_우육2.jpg',24),(73,'해목.jpg','288b90a9-7c70-4e89-b6d7-e31e00d63135_해목.jpg',25),(74,'해목1.jpg','288b90a9-7c70-4e89-b6d7-e31e00d63135_해목1.jpg',25),(75,'해목2.jpg','288b90a9-7c70-4e89-b6d7-e31e00d63135_해목2.jpg',25),(76,'잇텐고.jpg','fae4cd33-3310-48ed-a22c-5347926f41d9_잇텐고.jpg',26),(77,'잇텐고1.jpg','fae4cd33-3310-48ed-a22c-5347926f41d9_잇텐고1.jpg',26),(78,'잇텐고2.jpg','fae4cd33-3310-48ed-a22c-5347926f41d9_잇텐고2.jpg',26),(79,'스시소라.jpg','6eb98730-ba6e-4be5-9cdc-8e3a7993aeb1_스시소라.jpg',27),(80,'스시소라1.jpg','6eb98730-ba6e-4be5-9cdc-8e3a7993aeb1_스시소라1.jpg',27),(81,'스시소라2.jpg','6eb98730-ba6e-4be5-9cdc-8e3a7993aeb1_스시소라2.jpg',27),(82,'우마이도.jpg','32e671e4-d529-4fef-b85f-31feb0d7131f_우마이도.jpg',28),(83,'우마이도1.jpg','32e671e4-d529-4fef-b85f-31feb0d7131f_우마이도1.jpg',28),(84,'우마이도2.jpg','32e671e4-d529-4fef-b85f-31feb0d7131f_우마이도2.jpg',28);
/*!40000 ALTER TABLE `ImageEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MagazineEntity`
--

DROP TABLE IF EXISTS `MagazineEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MagazineEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `count` int NOT NULL DEFAULT '0',
  `createDate` datetime(6) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `title` varchar(150) NOT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpvk1e73bih8tbim8w8omgnfl7` (`userId`),
  CONSTRAINT `FKpvk1e73bih8tbim8w8omgnfl7` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MagazineEntity`
--

LOCK TABLES `MagazineEntity` WRITE;
/*!40000 ALTER TABLE `MagazineEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `MagazineEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MenuEntity`
--

DROP TABLE IF EXISTS `MenuEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MenuEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menuName` varchar(255) NOT NULL,
  `menuPrice` int NOT NULL,
  `storeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKig5wyvisjql0tthbvbiovufrr` (`storeId`),
  CONSTRAINT `FKig5wyvisjql0tthbvbiovufrr` FOREIGN KEY (`storeId`) REFERENCES `StoreEntity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MenuEntity`
--

LOCK TABLES `MenuEntity` WRITE;
/*!40000 ALTER TABLE `MenuEntity` DISABLE KEYS */;
INSERT INTO `MenuEntity` VALUES (1,'칼국수',10000,1),(2,'만두',11000,1),(3,'비빔국수',10000,1),(4,'포장만두',11000,1),(5,'콩국수',11000,1),(6,'갈비솥밥 정식',21000,2),(7,'고깃상- 갈비본살, 돼지목살',44000,2),(8,'이베리코 숯불구이 정식',20000,2),(9,'육회비빔밥 정식',14000,2),(10,'마약된장찌개',7000,2),(11,'마제소바',11000,3),(12,'도니꾸 마제소바',14000,3),(13,'카레마제소바',12000,3),(14,'부라타 토마토파스타',19000,4),(15,'토스트&잼',6000,4),(16,'하우스스테이크',29000,4),(17,'아메리칸 오믈렛',15000,4),(18,'고구마 프라이즈',9000,4),(19,'비빔국수',11000,5),(20,'닭칼국수',11000,5),(21,'육개장칼국수',11000,5),(22,'접시만두',11000,5),(23,'짜장면',7000,6),(24,'짬뽕',9000,6),(25,'볶음밥',9000,6),(26,'잡채밥',12000,6),(27,'고기튀김 중',30000,6),(28,'고기튀김 대',40000,6),(29,'국밥',9000,7),(30,'토종순대',12000,7),(31,'모둠수육',32000,7),(32,'국밥 특',11000,7),(33,'알등심 160g',17000,8),(34,'삼겹살 160g',17000,8),(35,'천겹살 180g',16000,8),(36,'청어알한우육회 100g',17000,8),(37,'까르보나라 멘타이꼬(명란파스타)',13000,9),(38,'치킨카라아게 미트소스',14000,9),(39,'포크 멘타이꼬 하카타풍',13000,9),(40,'수플레오믈렛 멘타이꼬 리조또',15000,9),(41,'칼만두',10000,10),(42,'손만둣국',12000,10),(43,'조랑떡만둣국',11000,10),(44,'김치손만둣국',13000,10),(45,'찐만두',10000,10),(46,'온반',11000,10),(47,'만두전골 중',38000,10),(48,'만두전골 대',48000,10),(49,'어글리 리코타치즈 샐러드',14900,11),(50,'어글리 프렌치 토스트',11900,11),(51,'안창&치킨 스테이크 콤보',22900,11),(52,'까르보나라',12900,11),(53,'크랩 로제 파스타',15900,11),(54,'안심 돈카츠 (220g)',15000,12),(55,'등심 돈카츠 (220g)',14000,12),(56,'등심+안심 돈카츠 (등심110g+안심150g)',19000,12),(57,'스페셜 등심 돈카츠 (230g)',17000,12),(58,'새우+안심 돈카츠 (2p+220g)',23000,12),(59,'로스가츠정식',13000,13),(60,'생선가츠정식',14000,13),(61,'히레가츠정식',15000,13),(62,'토리빠이탄 라멘',11000,14),(63,'카라빠이탄 라멘',11000,14),(64,'쇼유라멘',11000,14),(65,'시오라멘',11000,14),(66,'차슈추가',2000,14),(67,'계란추가',1000,14),(68,'아보카도버거',10800,15),(69,'갈릭버터 프라이즈',6400,15),(70,'오리지널 프라이즈',4700,15),(71,'치즈피자',10000,16),(72,'페퍼로니',12000,16),(73,'하와이안',12000,16),(74,'스파이시치킨',12000,16),(75,'The Mona of our Time',10000,16),(76,'봉골레',25000,17),(77,'이재모 치즈크러스트P',28000,18),(78,'이재모 치즈크러스트S',24000,18),(79,'이재모 새싹피자P',32000,18),(80,'이재모 새싹피자S',28000,18),(81,'클래식 패티 콥 샐러드',18000,19),(82,'비프칠리 파스타',19000,19),(83,'스파이시 크랩 크림파스타',17000,19),(84,'돼지고기탕수육',27000,20),(85,'유니짜장면',8000,20),(86,'매운짬뽕',7500,20),(87,'유니자장면',10000,21),(88,'찹쌀탕수육',30000,21),(89,'간자장면',9000,21),(90,'새우아스파라거스 딤섬',9000,22),(91,'삼색딤섬',8000,22),(92,'군만두 딤섬',8000,22),(93,'찐만두',7500,23),(94,'군만두',7500,23),(95,'일품가지',16000,23),(96,'우육면 특',13500,24),(97,'우육면',10000,24),(98,'수교',8000,24),(99,'특 히츠마부시',56000,25),(100,'히츠마부시',38000,25),(101,'어린이 장어 덮밥',10000,25),(102,'키츠네',7000,26),(103,'키요마사',8500,26),(104,'미도리카메',11000,26),(105,'토마토 쯔케모노',3500,26),(106,'런치 카운터 오마카세 ',55000,27),(107,'디너 카운터 오마카세 ',100000,27),(108,'돈코츠 라멘 오리지날',9000,28),(109,'돈코츠 라멘 매운맛',9000,28),(110,'돈코츠 라멘 시로마루',9000,28);
/*!40000 ALTER TABLE `MenuEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NoticeEntity`
--

DROP TABLE IF EXISTS `NoticeEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `NoticeEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `count` int NOT NULL DEFAULT '0',
  `createDate` datetime(6) DEFAULT NULL,
  `title` varchar(20) NOT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKasm7ki5ubmi3ehy029vq8ehd3` (`userId`),
  CONSTRAINT `FKasm7ki5ubmi3ehy029vq8ehd3` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NoticeEntity`
--

LOCK TABLES `NoticeEntity` WRITE;
/*!40000 ALTER TABLE `NoticeEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `NoticeEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PartnerEntity`
--

DROP TABLE IF EXISTS `PartnerEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PartnerEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `businessCard` varchar(255) DEFAULT NULL,
  `detailAddress` varchar(255) DEFAULT NULL,
  `mainNumber` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(14) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `storeName` varchar(255) NOT NULL,
  `upload` bit(1) DEFAULT b'0',
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92wslfp6ig8q9x3g83b3hvdx1` (`userId`),
  CONSTRAINT `FK92wslfp6ig8q9x3g83b3hvdx1` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PartnerEntity`
--

LOCK TABLES `PartnerEntity` WRITE;
/*!40000 ALTER TABLE `PartnerEntity` DISABLE KEYS */;
INSERT INTO `PartnerEntity` VALUES (1,'서울 중구 명동2가 25-2','32fcc5ef-a70a-4556-b84a-5426d50f4027_사업자.gif','명동교자','02-776-5348','010-1234-1234','approve','명동교자 본점',_binary '',14),(2,'서울 종로구 관훈동 15-1','4ce7734e-0fb8-4181-840b-07de098ecf2f_사업자.gif','1','02-733-9376','010-1234-1234','approve','도마',_binary '',15),(3,'서울 마포구 독막로6길 14','3ab9c0ba-cee6-453d-b659-837d14153944_사업자.gif','102호','02-322-3539','010-1234-1234','approve','오레노라멘',_binary '',16),(5,'서울 송파구 백제고분로45길 38','3820db1b-2ae6-4e33-bc89-3ade667485af_사업자.gif','멘야하나비','070-8959-1108','010-1234-1234','approve','멘야하나비 본점',_binary '',17),(6,'서울 강남구 도산대로51길 17','c7b6459f-b15d-44a8-ac95-ff2dd13f0f59_사업자.gif','리틀넥 청담','02-792-1476','010-1234-1234','approve','리틀넥청담',_binary '',18),(7,'서울 영등포구 국제금융로6길 33','b3a14e6f-b00e-47f8-91ff-892c856b593c_사업자.gif','진주집','02-780-6108','010-1234-1234','approve','진주집',_binary '',19),(8,'서울 중구 다동길 46','a4329090-cab5-4075-8a85-932bb4b930fd_사업자.gif','원흥 ','02-3789-3624','010-1234-1234','approve','원흥',_binary '',20),(9,'서울 강남구 선릉로86길 40-3','c4c1eba8-f41d-4a97-b46d-b3876d934dd3_사업자.gif','농민백암순대 본점','02-555-9603','010-1234-1234','approve','농민백암순대 본점',_binary '',21),(10,'서울 송파구 백제고분로45길 28','d74c4a07-3767-4253-8d3f-89dbf1cb32b5_사업자.gif','고도식','02-422-8692','010-1234-1234','approve','고도식',_binary '',22),(11,'서울 서초구 서초대로77길 7','5606241b-2574-42c6-9af9-b9be150c6ac2_사업자.gif','1층 요멘야 고에몬','02-534-8036','010-1234-1234','approve','요멘야 고에몬',_binary '',23),(12,'서울 종로구 북촌로2길 5-6','d536100e-6ec3-49d0-9592-926f570075a5_사업자.gif','깡통만두','02-794-4243','010-1234-1234','approve','깡통만두',_binary '',24),(13,'서울 강남구 강남대로98길 20','83803588-15bb-4012-adcc-eac908fb8afa_사업자.gif','어글리스토브','02-558-8459','010-1234-1234','approve','어글리스토브 신논현강남역점',_binary '',25),(14,'서울 강남구 역삼동 811-4','bd4034a3-5c39-4da2-9876-27c8a36982dd_사업자.gif','정돈','02-563-0924','010-1234-1234','approve','정돈 강남점',_binary '',26),(15,'서울 종로구 대학로9길 35','c906b098-7896-4b55-8384-3ad062ce310f_사업자.gif','호호식당','02-741-2384','010-1234-1234','approve','호호식당 대학로',_binary '',27),(16,'서울 용산구 이태원로42길 28-4','a65a2213-7ba1-4e4d-9477-4f029a255008_사업자.gif','다운타우너','070-8806-3696','010-1234-1234','approve','다운타우너',_binary '',28),(17,'서울 용산구 신흥로3길 2','5e82f327-c204-40a4-a57a-f69468f50d28_1사업자.gif','보니스피자펍','02-792-0303','010-1234-1234','approve','보니스피자펍',_binary '',29),(18,'서울 종로구 삼청로 22-7','0b2afd39-0553-43b9-b548-6a85ef629950_1사업자.gif','스미스가 좋아하는 한옥','02-722-7003','010-1234-1234','approve','스미스가좋아하는한옥',_binary '',30),(19,'부산 중구 광복중앙로 31','2b4f517b-e45f-4738-96f1-edfffc033e23_1사업자.gif','이재모피자','051-245-1478','010-1234-1234','approve','이재모피자',_binary '',31),(20,'경기 성남시 분당구 판교역로192번길 12','b4abe1b8-7feb-44c5-9f86-717593635738_1사업자.gif','민재하우스 102호','031-8061-0773','010-1234-1234','approve','라디오베이',_binary '',32),(21,'서울 종로구 청계천로 75-1','9e7f53f9-3756-440c-8345-746d261c2b5b_1사업자.gif','우육면관','070-4213-5678','010-1234-1234','approve','우육면관 청계천점',_binary '',33),(23,'서울 강남구 선릉로145길 13','90b20bbe-d390-4db7-be48-8cdcf014ac22_1사업자.gif','대가방','02-544-6336','010-1234-1234','approve','대가방 본점',_binary '',34),(24,'인천 중구 차이나타운로44번길 31-3','0228beee-fd8a-4815-b557-5037c5e77400_1사업자.gif','신승반점','032-762-9467','010-1234-1234','approve','신승반점',_binary '',35),(25,'서울 광진구 뚝섬로27길 48','a81f1d7e-f3c4-4d7c-8f68-b3b0a02c4d88_1사업자.gif','송화산시도삭면 본점','02-6052-7826','010-1234-1234','approve','송화산시도삭면 본점',_binary '',36),(26,'서울 마포구 도화길 22-10','197db168-012c-4c24-bb82-6c6e78519569_1사업자.gif','산동교자','02-711-3958','010-1234-1234','approve','산동교자',_binary '',37),(27,'부산 해운대구 구남로24번길 8','06954a81-1888-4e80-bfd7-297b7d6fc9d1_1사업자.gif','해목','051-746-3730','010-1234-1234','approve','해목',_binary '',38),(28,'서울 마포구 포은로 11','be18515a-daf7-4dff-bb9f-0d9bfc2bac19_1사업자.gif','잇텐고','02-337-7715','010-1234-1234','approve','잇텐고',_binary '',39),(29,'서울 종로구 종로 19','2b95b2b4-456e-41e8-8016-fd5804512b4f_1사업자.gif','스시소라','02-733-8400','010-1234-1234','approve','스시소라',_binary '',40),(30,'서울 광진구 동일로22길 42','2ff2bc06-ec71-4d5f-887e-1c22d670e804_1사업자.gif','우마이도','02-467-8788','010-1234-1234','approve','우마이도 건대점',_binary '',41);
/*!40000 ALTER TABLE `PartnerEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReservationEntity`
--

DROP TABLE IF EXISTS `ReservationEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReservationEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `approve` varchar(255) DEFAULT 'wait',
  `date` varchar(255) NOT NULL,
  `headCount` int NOT NULL,
  `isReviewd` bit(1) NOT NULL,
  `phoneNumber` varchar(13) NOT NULL,
  `request` longtext,
  `tid` varchar(255) DEFAULT NULL,
  `time` varchar(255) NOT NULL,
  `storeId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKogrripfy6b71vq3n2s1ire4ef` (`storeId`),
  KEY `FKjkd54gexa9agtpr1bpaqbv05u` (`userId`),
  CONSTRAINT `FKjkd54gexa9agtpr1bpaqbv05u` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`),
  CONSTRAINT `FKogrripfy6b71vq3n2s1ire4ef` FOREIGN KEY (`storeId`) REFERENCES `StoreEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReservationEntity`
--

LOCK TABLES `ReservationEntity` WRITE;
/*!40000 ALTER TABLE `ReservationEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `ReservationEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReviewEntity`
--

DROP TABLE IF EXISTS `ReviewEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReviewEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reviewContent` longtext,
  `reviewTitle` varchar(15) NOT NULL,
  `starScore` varchar(50) NOT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `storeId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm4vrp22cc8bvnincorgmpmigb` (`storeId`),
  KEY `FK9vti7ermyl37885d0bq1t1vrh` (`userId`),
  CONSTRAINT `FK9vti7ermyl37885d0bq1t1vrh` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`),
  CONSTRAINT `FKm4vrp22cc8bvnincorgmpmigb` FOREIGN KEY (`storeId`) REFERENCES `StoreEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReviewEntity`
--

LOCK TABLES `ReviewEntity` WRITE;
/*!40000 ALTER TABLE `ReviewEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `ReviewEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReviewReplyEntity`
--

DROP TABLE IF EXISTS `ReviewReplyEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ReviewReplyEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdDate` datetime(6) DEFAULT NULL,
  `replyContent` varchar(255) NOT NULL,
  `reviewId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKacc0c9al627jjlocn2ed0md29` (`reviewId`),
  KEY `FK2mcavl253ohbb6nokwgrtvc2r` (`userId`),
  CONSTRAINT `FK2mcavl253ohbb6nokwgrtvc2r` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`),
  CONSTRAINT `FKacc0c9al627jjlocn2ed0md29` FOREIGN KEY (`reviewId`) REFERENCES `ReviewEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReviewReplyEntity`
--

LOCK TABLES `ReviewReplyEntity` WRITE;
/*!40000 ALTER TABLE `ReviewReplyEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `ReviewReplyEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ServiceCenterEntity`
--

DROP TABLE IF EXISTS `ServiceCenterEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ServiceCenterEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `count` int NOT NULL DEFAULT '0',
  `createDate` datetime(6) DEFAULT NULL,
  `title` varchar(20) NOT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi8anc0f6fjahbybuqre69l10` (`userId`),
  CONSTRAINT `FKi8anc0f6fjahbybuqre69l10` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ServiceCenterEntity`
--

LOCK TABLES `ServiceCenterEntity` WRITE;
/*!40000 ALTER TABLE `ServiceCenterEntity` DISABLE KEYS */;
/*!40000 ALTER TABLE `ServiceCenterEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StoreEntity`
--

DROP TABLE IF EXISTS `StoreEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StoreEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `breakTime` varchar(255) DEFAULT NULL,
  `category` varchar(255) NOT NULL,
  `closeTime` varchar(255) NOT NULL,
  `openTime` varchar(255) NOT NULL,
  `partner_id` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK14om447hjc72mcg4yuc9vh0ai` (`partner_id`),
  KEY `FKlx0gx0c943oe396u6lwvcv1o1` (`userId`),
  CONSTRAINT `FK14om447hjc72mcg4yuc9vh0ai` FOREIGN KEY (`partner_id`) REFERENCES `PartnerEntity` (`id`),
  CONSTRAINT `FKlx0gx0c943oe396u6lwvcv1o1` FOREIGN KEY (`userId`) REFERENCES `UserEntity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StoreEntity`
--

LOCK TABLES `StoreEntity` WRITE;
/*!40000 ALTER TABLE `StoreEntity` DISABLE KEYS */;
INSERT INTO `StoreEntity` VALUES (1,'없음','KOREAN','21','10',1,14),(2,'오후 2시30 ~ 오후 5시 ','KOREAN','21','11',2,15),(3,'2시~5시30분','JAPANESE','21','11',5,17),(4,'3시~5시','WESTERN','21','11',6,18),(5,'없음','KOREAN','20','10',7,19),(6,'없음','CHINESE','20','11',8,20),(7,'없음','KOREAN','21','11',9,21),(8,'3시 ~ 5시','JAPANESE','23','12',10,22),(9,'없음','WESTERN','22','11',11,23),(10,'없음','KOREAN','21','11',12,24),(11,'없음','WESTERN','21','10',13,25),(12,'2시~5시','KOREAN','21','11',14,26),(13,'3시 ~ 5시','JAPANESE','22','11',15,27),(14,'없음','JAPANESE','21','11',3,16),(15,'없음','WESTERN','21','11',16,28),(16,'없음','WESTERN','22','12',17,29),(17,'3시 ~ 5시','WESTERN','21','11',18,30),(18,'3-5','WESTERN','21','11',19,31),(19,'3시 ~ 5시','WESTERN','22','11',20,32),(20,'없음','CHINESE','21','11',23,34),(21,'3시~ 4시반','CHINESE','21','11',24,35),(22,'3시 ~ 5시','CHINESE','23','12',25,36),(23,'없음','CHINESE','24','17',26,37),(24,'2시~5시30분','CHINESE','21','11',21,33),(25,'3시 ~ 5시','JAPANESE','22','11',27,38),(26,'2시~5시30분','JAPANESE','21','11',28,39),(27,'없음','JAPANESE','22','11',29,40),(28,'3시 ~ 5시','JAPANESE','21','11',30,41);
/*!40000 ALTER TABLE `StoreEntity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserEntity`
--

DROP TABLE IF EXISTS `UserEntity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserEntity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `createdDate` datetime(6) DEFAULT NULL,
  `detailAddress` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `extraAddress` varchar(255) DEFAULT NULL,
  `isEnable` bit(1) NOT NULL DEFAULT b'1',
  `loginType` varchar(255) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `phoneNumber` varchar(13) NOT NULL,
  `postCode` int NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `userNickname` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `warning` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bmlfh5xt4kn5ucq55kyoutlwi` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserEntity`
--

LOCK TABLES `UserEntity` WRITE;
/*!40000 ALTER TABLE `UserEntity` DISABLE KEYS */;
INSERT INTO `UserEntity` VALUES (1,'경기 성남시 분당구 판교역로 235','2023-01-09 09:51:54.191000','A동 3901호','abc@naver.com',' (삼평동)',_binary '',NULL,'$2a$10$xWHnVUXfMDeHvuji09Cy/eKtkoxJnhmT8iH0xfaQsXxPCN4WNwljC','010-9411-0807',13494,'ADMIN','홍길동','hong123',0),(12,'부산 수영구 감포로 7','2023-01-09 10:18:46.812000','108동 1902호','abc@naver.com',' (광안동)',_binary '',NULL,'$2a$10$KOE5ALpHKk3MFou..R6p4enmT4sZNl1wBqHhaNx9sjXiJYM3mp3JG','010-1234-1234',48292,'USER','김민준','minjun123',0),(13,'부산 해운대구 구남로 5','2023-01-09 10:19:18.393000','103동 12호','abc@naver.com',' (우동)',_binary '',NULL,'$2a$10$eTyizERS4IDxYsLqb7BvBOH3PAc6hlxizU6spVJogkY.6exTNTveq','010-1234-1234',48095,'USER','이서준','sujun123',0),(14,'부산 해운대구 대천로 35','2023-01-09 10:19:55.662000','112동 1204호','abc@naver.com',' (좌동, 코오롱아파트)',_binary '',NULL,'$2a$10$91ID7Lr6PvTMKANu6AISv.TprCRzHAicKhO8SNzLVhhveVU8CGcDK','010-1234-1234',48083,'HOST','박도윤','ehdbs123',0),(15,'부산 기장군 일광읍 이천길 3','2023-01-09 10:21:28.288000','주민센터','abc@naver.com','이천길',_binary '',NULL,'$2a$10$yjxo.Skbi7cewbT9ij8ndeti5vEtaSxp3/MmOoOMxM/WFluHN4Bre','010-1234-1234',46042,'HOST','홍예준','dpwns123',0),(16,'경북 안동시 풍산읍 시우실길 8-12','2023-01-09 10:22:01.977000','102호','abc@naver.com','시우시길',_binary '',NULL,'$2a$10$Cg.4V8NAxcXz5y3GLUI0bOODOheOSl.A.8Z3evStAqVyrFp.JHb3O','010-1234-1234',36621,'HOST','이시우','tldn123',0),(17,'전북 군산시 조촌4길 3','2023-01-09 10:22:27.042000','304호','abc@naver.com',' (조촌동)',_binary '',NULL,'$2a$10$NNwYnbwIAw/EdbPJMe.h9.NW20ZGV4bcM7l7fwIdTLxhMlho5c6/K','010-1234-1234',54078,'HOST','최하준','gkwns123',0),(18,'울산 울주군 두동면 주원길 10','2023-01-09 10:22:59.092000','상문블루빌 102호','abc@naver.com','주원길',_binary '',NULL,'$2a$10$mT9bieP4PFMWA5YdzqWMk.plSdpra11sqJ0ZAA1eF6StiWoMgjg2m','010-1234-1234',44915,'HOST','이주원','wndnjs123',0),(19,'경북 군위군 의흥면 연계지호길 123','2023-01-09 10:23:34.875000','쟌슨빌 202호','abc@naver.com','연계지호길',_binary '',NULL,'$2a$10$IjncCzXIeA4ztcStVbvzo.1JpzcC1JW9Y.I1rTF0J/J0e/SRLI3uK','010-1234-1234',39052,'HOST','최지호','wlgh123',0),(20,'전남 나주시 왕곡면 신가신원길 12','2023-01-09 10:24:11.217000','404호','abc@naver.com','신가신원길',_binary '',NULL,'$2a$10$vQV4nEvF1p6NRnlniKJEZ.WB.HYF1myvJOEF9X8pJGTLh1smx.TNO','010-1234-1234',58305,'HOST','강지후','wlgn123',0),(21,'경남 양산시 물금읍 화학1길 60','2023-01-09 10:24:42.694000','준우상사 앞','abc@naver.com','준우상사',_binary '',NULL,'$2a$10$H9TjylPdGAXAZK6a9yW2g.RnF7yFE6KAqI.YvANrisPyMIFsAVRM2','010-1234-1234',50603,'HOST','박준우','wnsdn123',0),(22,'서울 강동구 양재대로100길 20','2023-01-09 10:25:03.492000','준서홈타운 102호','abc@naver.com',' (둔촌동)',_binary '',NULL,'$2a$10$OPcI/XW1izfaruw7l21NFeTpozraNPBSUChIb81whISzNye/YayCq','010-1234-1234',5363,'HOST','이준서','wnstj123',0),(23,'서울 강남구 개포로 245','2023-01-09 10:25:29.243000','건우빌딩 1203호','abc@naver.com',' (개포동)',_binary '',NULL,'$2a$10$VrS3Eb2PlBhnSmlDNe7B7ujUe5Vtfqcqe6EVWVlUlpEY6tnAfrcrS','010-1234-1234',6306,'HOST','이건우','rjsdn123',0),(24,'경남 합천군 대병면 도현1길 1-23','2023-01-09 10:25:55.076000','102호','abc@naver.com','도현1길',_binary '',NULL,'$2a$10$82FdnxzChzAlDYY0Ua8lseyUHuoA3f3UT4Oyia.Q/s.21iQqF0r5.','010-1234-1234',50216,'HOST','김도현','ehgus123',0),(25,'서울 용산구 녹사평대로 132','2023-01-09 10:26:28.861000','106동 904호','abc@naver.com',' (이태원동)',_binary '',NULL,'$2a$10$KBNSi83/MV5QXDChDy3YveJRhvelY57Ndj3kPQfVfuttGbyuO9bJG','010-1234-1234',4390,'HOST','김현우','gusdn123',0),(26,'경북 영양군 일월면 지훈길 14-7','2023-01-09 10:27:04.160000','교무실','abc@naver.com','교육관',_binary '',NULL,'$2a$10$KOxIRk7r9SI9By3Ll70CheMsNNbBL.Pri.v8fkzHu8dTJXA31FBZ2','010-1234-1234',36514,'HOST','이지훈','wlgns123',0),(27,'충북 보은군 삼승면 남부로 3749-123','2023-01-09 10:27:34.883000','102동 303호','abc@naver.com',' (행복주택)',_binary '',NULL,'$2a$10$HxXFVJ5QTZROEoRIJdoJKO.WBs21/wDNvFuw0g6hZ.8o7lj2zgs5G','010-1234-1234',28923,'HOST','김우진','dnwls123',0),(28,'서울 강남구 봉은사로22길 22','2023-01-09 10:28:04.101000','b동 303호','abc@naver.com',' (역삼동, 선우펠리스)',_binary '',NULL,'$2a$10$/Ev8A0wIVO7Bbi3wps752OkVILgivVjJ0H8e9T6ykBDO.NIbpBFV6','010-1234-1234',6127,'HOST','최선우','tjsdn123',0),(29,'울산 동구 서진1길 1','2023-01-09 10:28:37.494000','방어동 도다리길','abc@naver.com',' (방어동)',_binary '',NULL,'$2a$10$CTwRK2z1Ds/VtmTB/Np7V.Aq9NuMJyaxjevScD96eJeER/sXlBv1e','010-1234-1234',44109,'HOST','이서진','tjwls123',0),(30,'서울 강남구 강남대로126길 22','2023-01-09 10:29:03.462000','유준하우스 102동 412호','abc@naver.com',' (논현동, 유준하우스)',_binary '',NULL,'$2a$10$vWKlYVbkDCNn1LTlGisXVuWtrnjcVYleYrjRWAk7T0a2MnMiEE71a','010-1234-1234',6114,'HOST','이유준','dbwns123',0),(31,'전남 영광군 법성면 연우로 3','2023-01-09 10:29:34.924000','101동 39호','abc@naver.com','연우로',_binary '',NULL,'$2a$10$HiOWEW/BD9S7FLhPIwrhMu.zqQJm7Cb0d2jbgnzr9KHOvfsM9hqve','010-1234-1234',57009,'HOST','이연우','dusdn123',0),(32,'서울 노원구 동일로192길 29','2023-01-09 10:29:56.555000','민재하우스 102호','abc@naver.com',' (공릉동)',_binary '',NULL,'$2a$10$zoo1OH6mB6xwi8dGbA5EPutXpjJjG.NEs0GLrXqY6KqGUEFiBZySa','010-1234-1234',1841,'HOST','김민재','alswo123',0),(33,'경기 고양시 덕양구 토당로26번길 12','2023-01-09 10:30:17.676000','505호','abc@naver.com',' (토당동, 현준그린빌)',_binary '',NULL,'$2a$10$kk45iwZ.oEjaVAswUl.ASu/o0D6HtM4vcG3WOG6pRASlGuIdQTKkK','010-1234-1234',10510,'HOST','이현준','guswns123',0),(34,'서울 관악구 봉천로23길 81','2023-01-09 10:30:42.026000','801호','abc@naver.com',' (봉천동, 은우빌라)',_binary '',NULL,'$2a$10$89Pf9gVRWZlKtmxBcwNcye.62qH4d5nFMF7ZWYB8pRQy2.WzbRSDK','010-1234-1234',8718,'HOST','이은우','dmsdn123',0),(35,'경기 의왕시 정우1길 8','2023-01-09 10:31:03.874000','123','abc@naver.com',' (내손동)',_binary '',NULL,'$2a$10$wQKbMy7SqrmVJs3pJIK6FuJv3jIG4r5WATv./kyyNWYQSs2TZ7H0q','010-1234-1234',16030,'HOST','이정우','wjddn123',0),(36,'대전 서구 고릿골길 86-11','2023-01-09 10:31:33.624000','고릿고길 102호','abc@naver.com',' (괴곡동)',_binary '',NULL,'$2a$10$6WvdKVV9cvO5F.UOi8DRXOdvu.Vu83h1LaQNDW4gJ4Pp7X0CI/jUa','010-1234-1234',35422,'HOST','최시윤','tldbs123',0),(37,'경기 화성시 동탄서연1길 2','2023-01-09 10:32:04.755000','행복빌라 102호','abc@naver.com',' (장지동)',_binary '',NULL,'$2a$10$HObTPn7P3T3GEHmTpoNaP.L2qkkVeuDQ5iVSiNNQqhDGCOs0c15Bu','010-1234-1234',18507,'HOST','이서연','tjdus123',0),(38,'대전 서구 고릿골길 86-11','2023-01-09 10:32:25.576000','106동 904호','abc@naver.com',' (괴곡동)',_binary '',NULL,'$2a$10$OAL0xuSmDt0JcMwVOZo8ZuNsaAuMnC15VqmHVLEHzF/fdRL0oyigO','010-1234-1234',35422,'HOST','김서윤','tjdbs123',0),(39,'제주특별자치도 제주시 가령로 1','2023-01-09 10:32:57.343000','이도이동 상문블루빌','abc@naver.com',' (이도이동)',_binary '',NULL,'$2a$10$1A9OOeTmxdj7tUImFBfr3Ok4EhWhBiv0ugNSTE2.KlkytZe.EqrYy','010-1234-1234',63214,'HOST','박지우','wldn123',0),(40,'경북 안동시 와룡면 감애구송로 255','2023-01-09 10:33:19.342000','505호','abc@naver.com','감애구송로',_binary '',NULL,'$2a$10$AeiraZzmuWDXxXdEgSM8xeZcAdNClzbpa.ad3v3F/jMsDH4KSEkDy','010-1234-1234',36610,'HOST','이서현','tjgus123',0),(41,'서울 강서구 강서로26길 32','2023-01-09 10:33:41.722000','106-904호','abc@naver.com',' (화곡동, 하은빌리지)',_binary '',NULL,'$2a$10$R22NmcvdFKgOQkqwWSgX7esJ0jW8oG2uGya0qSYxwJg/NIsmxqGwy','010-1234-1234',7730,'HOST','최하은','gkdms123',0),(42,'서울 광진구 동일로78길 40','2023-01-09 10:34:05.758000','106동 904호','abc@naver.com',' (중곡동, 하윤하이츠빌)',_binary '',NULL,'$2a$10$m3kV25aYyuqUjvtuMAciZOLwDKJx3RCX13g9ouXCzHeYTOFc0dVWq','010-1234-1234',4905,'USER','강하윤','gkdbs123',0),(43,'경남 고성군 거류면 거류로 711-7','2023-01-09 10:34:33.622000','민서빌 404호','abc@naver.com','거류로',_binary '',NULL,'$2a$10$SF.vtlp1GKy2KyoAYMj9ZeMXuR9GVpyoxbAcsHc99vpxEUAC0kJu.','010-1234-1234',52925,'USER','박민서','alstj123',0),(44,'광주 광산구 진곡산단3번로 41-36','2023-01-09 10:34:58.124000','지유빌딩 102','abc@naver.com',' (진곡동)',_binary '',NULL,'$2a$10$Pk47ZLWd0r/dRiKvYbL.hehvX7V8V.dnFiugWQuWUDWBTTZLyKW7W','010-1234-1234',62464,'USER','나지유','wldb123',0),(45,'경기 구리시 건원대로99번길 123','2023-01-09 10:35:24.309000','이윤서 앞','abc@naver.com',' (인창동)',_binary '',NULL,'$2a$10$qzqegEvCjou8fFBHnLhZ4u3thGkfuLnXWacjpmsiqk6uTcsOi13Bq','010-1234-1234',11918,'USER','이윤서','dbstj123',0),(46,'서울 광진구 아차산로 479','2023-01-09 10:35:45.407000','601호','abc@naver.com',' (구의동)',_binary '',NULL,'$2a$10$T24waPd1F.incCp3oTFBEu4XLE7xPZf5/xnWFMA78qbqb1oTmQFJW','010-1234-1234',5034,'USER','박지민','wlals',0),(47,'충남 당진시 채원들길 49-1','2023-01-09 10:36:21.621000','하인빌 104호','abc@naver.com',' (행정동)',_binary '',NULL,'$2a$10$Vcpas88e1r0GhvHtU0zW2uewve2hlGxEKVl//fhEhw.f05RJO9XQ2','010-1234-1234',31801,'USER','홍채원','codnjs123',0),(48,'전남 고흥군 고흥읍 고흥로 1908','2023-01-09 10:36:46.089000','301호','abc@naver.com',' (수아빌라)',_binary '',NULL,'$2a$10$2w903oWv/yYTZ9H0ZOBpmenVTUUopfG715x9JZcu35acKDGPqy5SS','010-1234-1234',59537,'USER','홍수아','tndk123',0),(49,'전북 익산시 금마면 지아골길 37','2023-01-09 10:37:12.381000','미륵산장','abc@naver.com','지아골길',_binary '',NULL,'$2a$10$gM3rOD/VShxYJwNY5fdUM.uKdJIMUP51qtR55rvMKbHF4k1Vimyqi','010-1234-1234',54573,'USER','이지아','wldk123',0),(50,'서울 관악구 남부순환로164길 9','2023-01-09 10:37:30.424000','301호','abc@naver.com',' (신림동)',_binary '',NULL,'$2a$10$DqwYL3HtO6AEpwWC1Tr9zOtIucOMn3zQA.Ud63/NjRvEll4UGrGdK','010-1234-1234',8773,'USER','이지윤','wldbs123',0),(51,'서울 서대문구 증가로30길 79','2023-01-09 10:37:52.373000','가온빌 204호','abc@naver.com',' (북가좌동, 은서가온빌)',_binary '',NULL,'$2a$10$DbMDlDdA33w6uGbBP3bGiu54WlSQpaepZaVnDbJ70Gl.UftnMepQi','010-1234-1234',3676,'USER','박은서','dmstj123',0),(52,'전북 익산시 함라면 다은1길 3-3','2023-01-09 10:38:19.358000','303호','abc@naver.com','다은길',_binary '',NULL,'$2a$10$sjTSRzSBKhL7Ap0RleqEruGeYGbGaQWUe8PD7U8RoA1KK.dAUpN4K','010-1234-1234',54503,'USER','이다은','ekdms123',0),(53,'서울 강남구 봉은사로82길 9-9','2023-01-09 10:38:42.297000','106-904호','abc@naver.com',' (삼성동)',_binary '',NULL,'$2a$10$EtCk9FYPA6kq/lXN4Pm6B.HFUUQtiDhnlJovKZYlOZ4yzqtFXd78C','010-1234-1234',6163,'USER','이예은','dpdms123',0),(54,'서울 관악구 신림로36길 24-12','2023-01-09 10:39:01.773000','501호','abc@naver.com',' (신림동)',_binary '',NULL,'$2a$10$fWd5xuqxTQd95yYJo89x8.IgIN/pe847lBZynSE4GK50nldiEmLCu','010-1234-1234',8828,'USER','김수빈','tnqls123',0),(55,'경남 밀양시 산내면 하양지안길 3','2023-01-09 10:39:22.208000','201호','abc@naver.com','하양지안길',_binary '',NULL,'$2a$10$Wp9URq8dWqYM.6VXhUSeauQWLufx1VFujZlTGspJCvKbIPA7f53fq','010-1234-1234',50415,'USER','이지안','wldks123',0),(56,'전북 전주시 완산구 삼천천변3길 30','2023-01-09 10:39:44.672000','소율어린이집','abc@naver.com',' (삼천동1가)',_binary '',NULL,'$2a$10$N7Zm2Dwk2Z.UXSis6IP3u.v504CXZVUqmMzmy./FkLRiQcZXo9jy6','010-1234-1234',55086,'USER','신소율','thdbf123',0),(57,'서울 강서구 등촌로51가길 67','2023-01-09 10:40:12.855000','예린빌 501호','abc@naver.com',' (등촌동)',_binary '',NULL,'$2a$10$2WZxrsJYUAghZMcTMWAwbOT0JEkTtbmbmdd3QdieTEtp45oy5svHO','010-1234-1234',7668,'USER','홍예린','dpfls123',0),(58,'서울 강남구 논현로26길 42-8','2023-01-09 10:40:41.656000','아트빌 301호','abc@naver.com',' (도곡동, 예원 아트빌)',_binary '',NULL,'$2a$10$7JlF.5TiaLG5FLaFW0EBaepTC3dRsrgteHLK3E7Ml9Qb2x.3uUV82','010-1234-1234',6300,'USER','김예원','dpdnjs123',0),(59,'경기 김포시 대곶면 율생중앙로206번길 17','2023-01-09 10:41:06.325000','하린테크','abc@naver.com','율생중앙로',_binary '',NULL,'$2a$10$RBQdYG4NJZe.2gbjSDTQkupD6CrUW.100hJnLNw8OrCWmB0YnSWgW','010-1234-1234',10027,'USER','이하린','gkfls123',0),(60,'경기 광주시 남한산성면 남한산성로 5-3','2023-01-09 10:41:28.137000','103호','abc@naver.com','남한산성로',_binary '',NULL,'$2a$10$SYyWtE/tONFiMkUfgoAhTOGhU4BGg13D1srf31h1AHnRHx4HMcb7W','010-1234-1234',12704,'USER','이지원','wldnjs123',0),(61,'서울 영등포구 국회대로53길 9','2023-01-09 10:41:50.791000','c동 303호','abc@naver.com',' (영등포동8가, 소윤빌리지)',_binary '',NULL,'$2a$10$KCcScwzms2WbdW5vUGLdAeQZjcq1msno.Ly2VAu65l3v6QTey78pe','010-1234-1234',7229,'USER','김소윤','thdbs123',0);
/*!40000 ALTER TABLE `UserEntity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-09 12:54:05
