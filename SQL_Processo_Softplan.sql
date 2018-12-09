CREATE database softplan;
USE softplan;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `ds_perfil` VARCHAR(45) NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `ds_login` varchar(45) DEFAULT NULL,
  `ds_senha` varchar(45) DEFAULT NULL,
  `fl_ativo` tinyint(1) DEFAULT '1',
  `id_perfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_usuario_perfil_1_idx` (`id_perfil`),
  CONSTRAINT `fk_usuario_perfil_1` FOREIGN KEY (`id_perfil`) REFERENCES `tb_perfil` (`id_perfil`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `softplan`.`tb_processo` (
  `id_processo` INT NOT NULL AUTO_INCREMENT,
  `ds_titulo` VARCHAR(45) NULL,
  `ds_processo` TEXT NULL,
  `ds_parecer` TEXT NULL,
  `fl_parecer` TINYINT(1) NULL DEFAULT 0,
  `id_usuario_parecer` INT NULL,
  PRIMARY KEY (`id_processo`),
  INDEX `fk_processo_usuario_1_idx` (`id_usuario_parecer` ASC),
  CONSTRAINT `fk_processo_usuario_1`
    FOREIGN KEY (`id_usuario_parecer`)
    REFERENCES `softplan`.`tb_usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_usuario_processo` (
  `id_processo` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_processo`, `id_usuario`),
  INDEX `fk_usuario_processo_2_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_usuario_processo_1`
    FOREIGN KEY (`id_processo`)
    REFERENCES `softplan`.`tb_processo` (`id_processo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_processo_2`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `softplan`.`tb_usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `softplan`.`tb_perfil` (`id_perfil`, `ds_perfil`) VALUES ('1', 'Usuário Administrador');
INSERT INTO `softplan`.`tb_perfil` (`id_perfil`, `ds_perfil`) VALUES ('2', 'Usuario Triador');
INSERT INTO `softplan`.`tb_perfil` (`id_perfil`, `ds_perfil`) VALUES ('3', 'Usuário Finalizador');
