/*
Navicat MySQL Data Transfer

Source Server         : socle - DEV
Source Server Version : 50516
Source Host           : caliban:3306
Source Database       : socle

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2015-08-13 18:10:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `socle_ref_directory`
-- ----------------------------
DROP TABLE IF EXISTS `socle_ref_directory`;
CREATE TABLE `socle_ref_directory` (
  `idRefDirectory` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `technicalNameRefDirectory` varchar(30) NOT NULL,
  `pathRefDirectory` varchar(100) NOT NULL,
  `commentsRefDirectory` text CHARACTER SET utf8mb4,
  PRIMARY KEY (`idRefDirectory`),
  UNIQUE KEY `indUnique_RefDirectoryTechnicalName` (`technicalNameRefDirectory`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of socle_ref_directory
-- ----------------------------
INSERT INTO `socle_ref_directory` VALUES ('1', 'SOCLE_tmp', 'd:\\was\\tmp', null);
INSERT INTO `socle_ref_directory` VALUES ('2', 'SOCLE_Test', 'd:\\RépertoireTest', null);

-- ----------------------------
-- Table structure for `socle_role`
-- ----------------------------
DROP TABLE IF EXISTS `socle_role`;
CREATE TABLE `socle_role` (
  `idRole` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Roles des utilisateurs',
  `technicalNameRole` varchar(20) NOT NULL COMMENT 'Nom technique',
  `labelRole` varchar(100) NOT NULL,
  PRIMARY KEY (`idRole`),
  UNIQUE KEY `indUnique_technicalNameUserRole` (`technicalNameRole`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of socle_role
-- ----------------------------
INSERT INTO `socle_role` VALUES ('1', 'SOCLE_adminMOE', 'Administrateur MOE');
INSERT INTO `socle_role` VALUES ('40', 'SOCLE_test', 'test');
INSERT INTO `socle_role` VALUES ('42', 'SOCLE_test1', 'test15');
INSERT INTO `socle_role` VALUES ('43', 'SOCLE_test2', 'test 5');
INSERT INTO `socle_role` VALUES ('44', 'SOCLE_test4', 'test4');
INSERT INTO `socle_role` VALUES ('88', 'SOCLE_Test5', 'Test5');

-- ----------------------------
-- Table structure for `socle_user`
-- ----------------------------
DROP TABLE IF EXISTS `socle_user`;
CREATE TABLE `socle_user` (
  `idUser` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nomUser` varchar(35) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `prenomUser` varchar(35) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `loginUser` varchar(50) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `passwordUser` varchar(56) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `mailUser` varchar(100) DEFAULT NULL,
  `cpUser` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `robotUser` bit(1) NOT NULL DEFAULT b'0',
  `tomcatRoleUser` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `telephonePro1User` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `telephonePro2User` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `telephonePortable1User` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `fax1User` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `adresseNumeroRueUser` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `adresseNomRueUser` varchar(75) CHARACTER SET latin1 DEFAULT NULL,
  `adresseComplement1User` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `adresseComplement2User` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `adresseCodepostalUser` varchar(10) CHARACTER SET latin1 DEFAULT NULL,
  `adresseVilleUser` varchar(30) CHARACTER SET latin1 DEFAULT NULL,
  `attribut1User` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `attribut2User` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `attribut3User` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `attribut4User` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `attribut5User` varchar(35) CHARACTER SET latin1 DEFAULT NULL,
  `idUserCreateUser` int(11) unsigned NOT NULL,
  `dateCreateUser` datetime NOT NULL,
  `idUserUpdateUser` int(11) unsigned NOT NULL,
  `dateUpdateUser` datetime NOT NULL,
  `commentaireUtilisateurUser` varchar(75) CHARACTER SET latin1 DEFAULT NULL,
  `dateLastUpdateUtilisateurUser` datetime DEFAULT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `indUnique_loginUser` (`loginUser`) USING BTREE,
  UNIQUE KEY `indUnique_cpUser` (`cpUser`) USING BTREE,
  UNIQUE KEY `indUniqueMailUser` (`mailUser`) USING BTREE,
  KEY `idUserCreateUser_FK` (`idUserCreateUser`),
  KEY `idUserUpdateUser_FK` (`idUserUpdateUser`),
  CONSTRAINT `socle_user_ibfk_1` FOREIGN KEY (`idUserCreateUser`) REFERENCES `socle_user` (`idUser`),
  CONSTRAINT `socle_user_ibfk_2` FOREIGN KEY (`idUserUpdateUser`) REFERENCES `socle_user` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of socle_user
-- ----------------------------
INSERT INTO `socle_user` VALUES ('1', 'admin', 'admin', 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'admin@avancial.com', '0123456A', '', 'user', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2015-01-13 09:54:50', '1', '2015-01-13 17:41:28', null, null);
INSERT INTO `socle_user` VALUES ('2', 'quentin', 'quentin', 'quentin', 'd6b8e48afb2534b213e391cab43016505747a234', null, null, '', 'user', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2015-01-13 09:54:50', '1', '2015-01-13 09:54:59', null, null);
INSERT INTO `socle_user` VALUES ('3', 'andrieu', 'liana', '8008286j', '0123456B', 'liana.andrieu@avancial.com', '0123456B', '', 'user', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2015-01-01 00:00:00', '1', '2015-01-13 00:00:00', null, null);
INSERT INTO `socle_user` VALUES ('4', 'Erdogan', 'Caglar', 'caglar', '1234', 'caglar.erdogan@avancial.com', '1234567X', '', 'user', null, null, '0612345678', '0123456789', '40', 'avenue des Terroirs de France', null, null, '75012', 'Paris', null, null, null, null, null, '4', '2015-01-01 00:00:00', '4', '2015-01-01 00:00:00', 'Test', null);

-- ----------------------------
-- Table structure for `socle_user2role`
-- ----------------------------
DROP TABLE IF EXISTS `socle_user2role`;
CREATE TABLE `socle_user2role` (
  `idUser2Role` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `idUser` int(11) unsigned NOT NULL,
  `idRole` int(11) unsigned NOT NULL,
  PRIMARY KEY (`idUser2Role`),
  UNIQUE KEY `indUnique_UserRole` (`idUser`,`idRole`),
  KEY `FK_Role_User2Role` (`idRole`),
  CONSTRAINT `FK_Role_User2Role` FOREIGN KEY (`idRole`) REFERENCES `socle_role` (`idRole`),
  CONSTRAINT `FK_User_User2Role` FOREIGN KEY (`idUser`) REFERENCES `socle_user` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of socle_user2role
-- ----------------------------
INSERT INTO `socle_user2role` VALUES ('1', '1', '1');
