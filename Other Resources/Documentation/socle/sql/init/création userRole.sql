CREATE TABLE `socle_user_role` (
  `idUserRole` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Roles des utilisateurs',
  `technicalNameUserRole` varchar(20) NOT NULL COMMENT 'Nom technique',
  `labelUserRole` varchar(100) NOT NULL,
  PRIMARY KEY (`idUserRole`),
  KEY `indUnique_technicalNameUserRole` (`technicalNameUserRole`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
