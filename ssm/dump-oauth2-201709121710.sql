-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: oauth2
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_id` int(11) NOT NULL COMMENT 'ÂèëÈÄÅ‰∫∫ID',
  `from_name` varchar(20) NOT NULL COMMENT 'ÂèëÈÄÅ‰∫∫ÂßìÂêç',
  `to_id` int(11) NOT NULL COMMENT 'Êé•Êî∂‰∫∫ID',
  `to_name` varchar(20) NOT NULL COMMENT 'Êé•Êî∂‰∫∫ÂßìÂêç',
  `msg_content` varchar(200) NOT NULL COMMENT 'Ê∂àÊÅØÂÜÖÂÆπ',
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'ÂèëÈÄÅÊó∂Èó¥',
  `msg_type` int(1) NOT NULL COMMENT 'Ê∂àÊÅØÁ±ªÂûã',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_access_token`
--

DROP TABLE IF EXISTS `oauth_access_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_access_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `client_id` varchar(255) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(255) DEFAULT NULL,
  KEY `token_id_index` (`token_id`),
  KEY `authentication_id_index` (`authentication_id`),
  KEY `user_name_index` (`user_name`),
  KEY `client_id_index` (`client_id`),
  KEY `refresh_token_index` (`refresh_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_access_token`
--

LOCK TABLES `oauth_access_token` WRITE;
/*!40000 ALTER TABLE `oauth_access_token` DISABLE KEYS */;
INSERT INTO `oauth_access_token` VALUES ('2017-09-06 09:29:21','526cd96024a7dfd264be252581d65356','¨\Ì\0sr\0Corg.springframework.security.oauth2.common.DefaultOAuth2AccessToken≤û6$˙\Œ\0L\0additionalInformationt\0Ljava/util/Map;L\0\nexpirationt\0Ljava/util/Date;L\0refreshTokent\0?Lorg/springframework/security/oauth2/common/OAuth2RefreshToken;L\0scopet\0Ljava/util/Set;L\0	tokenTypet\0Ljava/lang/String;L\0valueq\0~\0xpsr\0java.util.Collections$EmptyMapY6ÖZ\‹\Á\–\0\0xpsr\0java.util.DatehjÅKYt\0\0xpw\0\0^XãJπxsr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\ﬂGcù\–…∑\0L\0\nexpirationq\0~\0xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\·\ncT\‘^\0L\0valueq\0~\0xpt\0$a1dd23ed-2b59-4521-b518-26f72cb15212sq\0~\0	w\0\0^v\‰¥xsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xr\0,java.util.Collections$UnmodifiableCollectionB\0Ä\À^˜\0L\0ct\0Ljava/util/Collection;xpsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0t\0readxt\0bearert\0$3b21c52a-4128-4415-98be-465b796bfe82','5ed6f8ca142962aa59a37718b487093f','admin','mobile-client','¨\Ì\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2AuthenticationΩ@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationToken”™(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList¸%1µ\Ïé\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0Ä\À^˜\0L\0cq\0~\0xpsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0ê\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERsq\0~\0\rt\0\nROLE_UNITYsq\0~\0\rt\0ROLE_MOBILExq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qiΩ\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0\rmobile-clientsr\0%java.util.Collections$UnmodifiableMapÒ•®˛tıB\0L\0mq\0~\0xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0	client_idt\0\rmobile-clientt\0scopet\0readt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xq\0~\0	sr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0q\0~\0%xsq\0~\0+w\0\0\0?@\0\0\0\0\0sq\0~\0\rt\0ROLE_CLIENTxsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0+w\0\0\0?@\0\0\0\0\0t\0mobile-resourcexsq\0~\0+w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0ê\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0xq\0~\07sr\0java.util.LinkedHashMap4¿N\\l¿˚\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0 q\0~\0!q\0~\0$q\0~\0%t\0\rclient_secrett\0mobileq\0~\0\"q\0~\0#q\0~\0&q\0~\0\'x\0psr\0com.hzlh.entity.MyUserDetails\√‹°më¶_2\0Z\0statusL\0grantedAuthoritiesq\0~\0L\0usert\0Lcom/hzlh/entity/User;xp\0sq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0xsr\0Forg.apache.ibatis.executor.loader.javassist.JavassistSerialStateHolder|§+¥pu\0\0xr\0;org.apache.ibatis.executor.loader.AbstractSerialStateHolder|§+¥pu\0\0xpur\0[B¨Û¯T\‡\0\0xp\0\0ö¨\Ì\0sr\0com.hzlh.entity.User\0\0\0\0\0\0\0\0L\0archivedt\0Ljava/lang/Boolean;L\0\ncreateTimet\0Ljava/util/Date;L\0defaultUserq\0~\0L\0emailt\0Ljava/lang/String;L\0guidq\0~\0L\0idt\0Ljava/lang/Long;L\0\rlastLoginTimeq\0~\0L\0passwordq\0~\0L\0phoneq\0~\0L\0\nprivilegest\0Ljava/util/List;L\0usernameq\0~\0xpsr\0java.lang.Boolean\Õ rÄ’ú˙\Ó\0Z\0valuexp\0sr\0java.util.DatehjÅKYt\0\0xpw\0\0^Pﬂéxsq\0~\0t\0\radmin@wdcy.cct\0 29f6004fb1b0466f9572b02bf2ac1be8sr\0java.lang.Long;ã\‰êÃè#\ﬂ\0J\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\0\0\0\0pt\0 21232f297a57a5a743894a0e4a801fc3t\0028-1234567sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0xt\0adminsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\nPRIVILEGESsr\0:org.apache.ibatis.executor.loader.ResultLoaderMap$LoadPair\0\0\0\03*l\0L\0configurationFactoryt\0Ljava/lang/Class;L\0mappedParametert\0Ljava/io/Serializable;L\0mappedStatementq\0~\0L\0propertyq\0~\0xppsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexq\0~\0\0\0\0t\0.com.hzlh.dao.UserMapper.findPrivilegesByUserIdt\0\nprivilegesxsr\09org.apache.ibatis.reflection.factory.DefaultObjectFactoryÖJ≠€ª\Ë¸\0\0xpur\0[Ljava.lang.Class;´◊Æ\À\ÕZô\0\0xp\0\0\0\0ur\0[Ljava.lang.Object;ê\ŒXüs)l\0\0xp\0\0\0\0x','3dd9989344db360d0385378c3719e632');
/*!40000 ALTER TABLE `oauth_access_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `archived` tinyint(1) DEFAULT '0',
  `trusted` tinyint(1) DEFAULT '0',
  `autoapprove` varchar(255) DEFAULT 'false',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('mobile-client','mobile-resource','mobile','read,write','password,refresh_token',NULL,'ROLE_CLIENT',NULL,NULL,NULL,'2017-09-05 07:09:44',0,0,'false'),('unity-client','unity-resource','unity','read,write','authorization_code,refresh_token,implicit',NULL,'ROLE_CLIENT',NULL,NULL,NULL,'2017-09-05 07:09:44',0,0,'false');
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_code`
--

DROP TABLE IF EXISTS `oauth_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_code` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `code` varchar(255) DEFAULT NULL,
  `authentication` blob,
  KEY `code_index` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_code`
--

LOCK TABLES `oauth_code` WRITE;
/*!40000 ALTER TABLE `oauth_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_refresh_token`
--

DROP TABLE IF EXISTS `oauth_refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_refresh_token` (
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `token_id` varchar(255) DEFAULT NULL,
  `token` blob,
  `authentication` blob,
  KEY `token_id_index` (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_refresh_token`
--

LOCK TABLES `oauth_refresh_token` WRITE;
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
INSERT INTO `oauth_refresh_token` VALUES ('2017-09-06 06:54:37','3dd9989344db360d0385378c3719e632','¨\Ì\0sr\0Lorg.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken/\ﬂGcù\–…∑\0L\0\nexpirationt\0Ljava/util/Date;xr\0Dorg.springframework.security.oauth2.common.DefaultOAuth2RefreshTokens\·\ncT\‘^\0L\0valuet\0Ljava/lang/String;xpt\0$a1dd23ed-2b59-4521-b518-26f72cb15212sr\0java.util.DatehjÅKYt\0\0xpw\0\0^v\‰¥x','¨\Ì\0sr\0Aorg.springframework.security.oauth2.provider.OAuth2AuthenticationΩ@bR\0L\0\rstoredRequestt\0<Lorg/springframework/security/oauth2/provider/OAuth2Request;L\0userAuthenticationt\02Lorg/springframework/security/core/Authentication;xr\0Gorg.springframework.security.authentication.AbstractAuthenticationToken”™(~nGd\0Z\0\rauthenticatedL\0authoritiest\0Ljava/util/Collection;L\0detailst\0Ljava/lang/Object;xp\0sr\0&java.util.Collections$UnmodifiableList¸%1µ\Ïé\0L\0listt\0Ljava/util/List;xr\0,java.util.Collections$UnmodifiableCollectionB\0Ä\À^˜\0L\0cq\0~\0xpsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0sr\0Borg.springframework.security.core.authority.SimpleGrantedAuthority\0\0\0\0\0\0ê\0L\0rolet\0Ljava/lang/String;xpt\0	ROLE_USERsq\0~\0\rt\0\nROLE_UNITYsq\0~\0\rt\0ROLE_MOBILExq\0~\0psr\0:org.springframework.security.oauth2.provider.OAuth2Request\0\0\0\0\0\0\0\0Z\0approvedL\0authoritiesq\0~\0L\0\nextensionst\0Ljava/util/Map;L\0redirectUriq\0~\0L\0refresht\0;Lorg/springframework/security/oauth2/provider/TokenRequest;L\0resourceIdst\0Ljava/util/Set;L\0\rresponseTypesq\0~\0xr\08org.springframework.security.oauth2.provider.BaseRequest6(z>£qiΩ\0L\0clientIdq\0~\0L\0requestParametersq\0~\0L\0scopeq\0~\0xpt\0\rmobile-clientsr\0%java.util.Collections$UnmodifiableMapÒ•®˛tıB\0L\0mq\0~\0xpsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\ngrant_typet\0passwordt\0	client_idt\0\rmobile-clientt\0scopet\0readt\0usernamet\0adminxsr\0%java.util.Collections$UnmodifiableSetÄí—èõÄU\0\0xq\0~\0	sr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0q\0~\0%xsq\0~\0+w\0\0\0?@\0\0\0\0\0sq\0~\0\rt\0ROLE_CLIENTxsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xppsq\0~\0+w\0\0\0?@\0\0\0\0\0t\0mobile-resourcexsq\0~\0+w\0\0\0?@\0\0\0\0\0\0xsr\0Oorg.springframework.security.authentication.UsernamePasswordAuthenticationToken\0\0\0\0\0\0ê\0L\0credentialsq\0~\0L\0	principalq\0~\0xq\0~\0sq\0~\0sq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0xq\0~\07sr\0java.util.LinkedHashMap4¿N\\l¿˚\0Z\0accessOrderxq\0~\0?@\0\0\0\0\0w\0\0\0\0\0\0q\0~\0 q\0~\0!q\0~\0$q\0~\0%t\0\rclient_secrett\0mobileq\0~\0\"q\0~\0#q\0~\0&q\0~\0\'x\0psr\0com.hzlh.entity.MyUserDetails\√‹°më¶_2\0Z\0statusL\0grantedAuthoritiesq\0~\0L\0usert\0Lcom/hzlh/entity/User;xp\0sq\0~\0\0\0\0w\0\0\0q\0~\0q\0~\0q\0~\0xsr\0Forg.apache.ibatis.executor.loader.javassist.JavassistSerialStateHolder|§+¥pu\0\0xr\0;org.apache.ibatis.executor.loader.AbstractSerialStateHolder|§+¥pu\0\0xpur\0[B¨Û¯T\‡\0\0xp\0\0ö¨\Ì\0sr\0com.hzlh.entity.User\0\0\0\0\0\0\0\0L\0archivedt\0Ljava/lang/Boolean;L\0\ncreateTimet\0Ljava/util/Date;L\0defaultUserq\0~\0L\0emailt\0Ljava/lang/String;L\0guidq\0~\0L\0idt\0Ljava/lang/Long;L\0\rlastLoginTimeq\0~\0L\0passwordq\0~\0L\0phoneq\0~\0L\0\nprivilegest\0Ljava/util/List;L\0usernameq\0~\0xpsr\0java.lang.Boolean\Õ rÄ’ú˙\Ó\0Z\0valuexp\0sr\0java.util.DatehjÅKYt\0\0xpw\0\0^Pﬂéxsq\0~\0t\0\radmin@wdcy.cct\0 29f6004fb1b0466f9572b02bf2ac1be8sr\0java.lang.Long;ã\‰êÃè#\ﬂ\0J\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0\0\0\0\0pt\0 21232f297a57a5a743894a0e4a801fc3t\0028-1234567sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0xt\0adminsr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\nPRIVILEGESsr\0:org.apache.ibatis.executor.loader.ResultLoaderMap$LoadPair\0\0\0\03*l\0L\0configurationFactoryt\0Ljava/lang/Class;L\0mappedParametert\0Ljava/io/Serializable;L\0mappedStatementq\0~\0L\0propertyq\0~\0xppsr\0java.lang.Integer‚†§˜Åá8\0I\0valuexq\0~\0\0\0\0t\0.com.hzlh.dao.UserMapper.findPrivilegesByUserIdt\0\nprivilegesxsr\09org.apache.ibatis.reflection.factory.DefaultObjectFactoryÖJ≠€ª\Ë¸\0\0xpur\0[Ljava.lang.Class;´◊Æ\À\ÕZô\0\0xp\0\0\0\0ur\0[Ljava.lang.Object;ê\ŒXüs)l\0\0xp\0\0\0\0x');
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_`
--

DROP TABLE IF EXISTS `user_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `default_user` tinyint(1) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_`
--

LOCK TABLES `user_` WRITE;
/*!40000 ALTER TABLE `user_` DISABLE KEYS */;
INSERT INTO `user_` VALUES (21,'29f6004fb1b0466f9572b02bf2ac1be8','2017-09-05 15:09:42',0,'admin@wdcy.cc','21232f297a57a5a743894a0e4a801fc3','028-1234567','admin',1,NULL),(22,'55b713df1c6f423e842ad68668523c49','2017-09-05 15:09:43',0,'unity@wdcy.cc','439b3a25b555b3bc8667a09a036ae70c','','unity',0,NULL),(23,'612025cb3f964a64a48bbdf77e53c2c1','2017-09-05 15:09:43',0,'mobile@wdcy.cc','532c28d5412dd75bf975fb951c740a30','','mobile',0,NULL);
/*!40000 ALTER TABLE `user_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_privilege`
--

DROP TABLE IF EXISTS `user_privilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_privilege` (
  `user_id` int(11) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL,
  KEY `user_id_index` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_privilege`
--

LOCK TABLES `user_privilege` WRITE;
/*!40000 ALTER TABLE `user_privilege` DISABLE KEYS */;
INSERT INTO `user_privilege` VALUES (22,'UNITY'),(23,'MOBILE');
/*!40000 ALTER TABLE `user_privilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'oauth2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-12 17:10:29
