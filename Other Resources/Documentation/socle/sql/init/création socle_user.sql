CREATE TABLE `socle_user` (
  `idUser` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nomUser` varchar(35) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `prenomUser` varchar(35) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `loginUser` varchar(50) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `passwordUser` varchar(56) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `mailUser` varchar(100) DEFAULT NULL,
  `cpUser` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `robotUser` tinyint(1) NOT NULL DEFAULT '0',
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
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `indUnique_loginUser` (`loginUser`) USING BTREE,
  UNIQUE KEY `indUnique_cpUser` (`cpUser`) USING BTREE,
  UNIQUE KEY `indUniqueTomcatRole` (`tomcatRoleUser`) USING BTREE,
  UNIQUE KEY `indUniqueMailUser` (`mailUser`) USING BTREE,
  KEY `idUserCreateUser_FK` (`idUserCreateUser`),
  KEY `idUserUpdateUser_FK` (`idUserUpdateUser`),
  CONSTRAINT `idUserCreateUser_FK` FOREIGN KEY (`idUserCreateUser`) REFERENCES `socle_user` (`idUser`),
  CONSTRAINT `idUserUpdateUser_FK` FOREIGN KEY (`idUserUpdateUser`) REFERENCES `socle_user` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



INSERT INTO socle_user ( `nomUser`, `prenomUser`, `loginUser`, `passwordUser`, `mailUser`, `cpUser`, `robotUser`, `tomcatRoleUser`, `telephonePro1User`, `telephonePro2User`, `telephonePortable1User`, `fax1User`, `adresseNumeroRueUser`, `adresseNomRueUser`, `adresseComplement1User`, `adresseComplement2User`, `adresseCodepostalUser`, `adresseVilleUser`, `attribut1User`, `attribut2User`, `attribut3User`, `attribut4User`, `attribut5User`, `dateCreateUser`, `dateUpdateUser`, `dateUpdateUtilisateurUser`, `commentaireUtilisateurUser` ) VALUES ( 'admin', 'admin', 'admin', SHA1('admin'), NULL, NULL, FALSE, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2015-01-13 09:54:50.0', NULL, '2015-01-13 09:54:59.0', NULL );