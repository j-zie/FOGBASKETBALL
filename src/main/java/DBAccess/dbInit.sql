-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fog_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fog_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS fog_db;
CREATE SCHEMA IF NOT EXISTS `fog_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fog_db` ;

-- -----------------------------------------------------
-- Table `fog_db`.`byer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_db`.`byer` (
  `postNr` INT(11) NOT NULL,
  `by` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`postNr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_db`.`bruger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_db`.`bruger` (
  `brugerId` INT(11) NOT NULL AUTO_INCREMENT,
  `navn` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `rolle` VARCHAR(45) NULL DEFAULT NULL,
  `adresse` VARCHAR(45) NULL DEFAULT NULL,
  `postnr` INT(11) NULL DEFAULT NULL,
  `telefon` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`brugerId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fog_db`.`tagtyper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_db`.`tagtyper` (
  `tagtypeNr` INT(11) NOT NULL AUTO_INCREMENT,
  `tagtypeNavn` VARCHAR(45) NULL DEFAULT NULL,
  `dækningsgrad` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`tagtypeNr`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_db`.`ordre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_db`.`ordre` (
  `ordreNr` INT(11) NOT NULL AUTO_INCREMENT,
  `brugerId` INT(11) NULL DEFAULT NULL,
  `carportLængde` INT(11) NULL DEFAULT NULL,
  `carportBredde` INT(11) NULL DEFAULT NULL,
  `redskabsrumLængde` INT(11) NULL DEFAULT NULL,
  `tagtypeNr` INT(11) NULL DEFAULT NULL,
  `hældning` DOUBLE NULL DEFAULT NULL,
  `redskabsrumBredde` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ordreNr`),
  INDEX `brugerId_idx` (`brugerId` ASC) VISIBLE,
  INDEX `tagtypeNr_idx` (`tagtypeNr` ASC) VISIBLE,
  CONSTRAINT `brugerId`
    FOREIGN KEY (`brugerId`)
    REFERENCES `fog_db`.`bruger` (`brugerId`),
  CONSTRAINT `tagtypeNr`
    FOREIGN KEY (`tagtypeNr`)
    REFERENCES `fog_db`.`tagtyper` (`tagtypeNr`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into tagtyper (tagtypeNavn,dækningsgrad) values ("Plasttrapezplade-fladtag",0.35), ("Betontag-Rød",8.9) ,("Betontag-Sort", 8.9),("EternittagB6-Sort", 0.92),("EternittagB6-Rødbrun",0.92),("EternittagB7-Sort", 2.3),("EternittagB7-Mokka",2.3);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;