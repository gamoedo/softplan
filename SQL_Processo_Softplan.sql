CREATE database softplan;
USE softplan;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_perfil` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `ds_perfil` VARCHAR(45) NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `ds_login` VARCHAR(45) NULL,
  `ds_senha` VARCHAR(45) NULL,
  `fl_ativo` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `softplan`.`tb_usuario_perfil` (
  `id_usuario` INT NOT NULL,
  `id_perfil` INT NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_perfil`),
  INDEX `tb_usuario_perfil_fk_2_idx` (`id_perfil` ASC),
  CONSTRAINT `fk_usuario_perfil_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `softplan`.`tb_usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_perfil_2`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `softplan`.`tb_perfil` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

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