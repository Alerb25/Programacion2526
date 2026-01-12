-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NULL,
  `duracion` INT NULL,
  `clasificacion` INT NULL,
  `sinopsis` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`actor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(500) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  `fecha_nac` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`actor_has_Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`actor_has_Pelicula` (
  `actor_id` INT NOT NULL,
  `Pelicula_id` INT NOT NULL,
  `personaje` VARCHAR(45) NULL,
  PRIMARY KEY (`actor_id`, `Pelicula_id`),
  CONSTRAINT `fk_actor_has_Pelicula_actor`
    FOREIGN KEY (`actor_id`)
    REFERENCES `mydb`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_has_Pelicula_Pelicula1`
    FOREIGN KEY (`Pelicula_id`)
    REFERENCES `mydb`.`Pelicula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_actor_has_Pelicula_Pelicula1_idx` ON `mydb`.`actor_has_Pelicula` (`Pelicula_id` ASC) VISIBLE;

CREATE INDEX `fk_actor_has_Pelicula_actor_idx` ON `mydb`.`actor_has_Pelicula` (`actor_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`cine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cine` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(1000) NULL,
  `localidades` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cine_has_Pelicula`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cine_has_Pelicula` (
  `cine_id` INT NOT NULL,
  `Pelicula_id` INT NOT NULL,
  PRIMARY KEY (`cine_id`, `Pelicula_id`),
  CONSTRAINT `fk_cine_has_Pelicula_cine1`
    FOREIGN KEY (`cine_id`)
    REFERENCES `mydb`.`cine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cine_has_Pelicula_Pelicula1`
    FOREIGN KEY (`Pelicula_id`)
    REFERENCES `mydb`.`Pelicula` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_cine_has_Pelicula_Pelicula1_idx` ON `mydb`.`cine_has_Pelicula` (`Pelicula_id` ASC) VISIBLE;

CREATE INDEX `fk_cine_has_Pelicula_cine1_idx` ON `mydb`.`cine_has_Pelicula` (`cine_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sala` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `capacidad` INT NULL,
  `tipo_sala` INT NULL,
  `cine_id` INT NOT NULL,
  PRIMARY KEY (`id`, `cine_id`),
  CONSTRAINT `fk_sala_cine1`
    FOREIGN KEY (`cine_id`)
    REFERENCES `mydb`.`cine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_sala_cine1_idx` ON `mydb`.`sala` (`cine_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
