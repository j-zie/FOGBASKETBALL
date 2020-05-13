
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
  `tagtypeNavn` VARCHAR(95) NULL DEFAULT NULL,
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
    REFERENCES `fog_db`.`tagtyper` (`tagtypeNr`)
    )


ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `fog_db`.`stykliste`
-- -----------------------------------------------------
select * from notificationer;
CREATE TABLE `stykliste` (
    `ordre` INT NOT NULL,
    `materialer` INT NOT NULL,
    `antal` INT NOT NULL,
    PRIMARY KEY (`ordre`, `materialer`),
	CONSTRAINT `Constr_materiale_fk`
        FOREIGN KEY `materiale_fk` (`materialer`) REFERENCES `materialer` (`materialeID`)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `Constr_ordre_fk`
        FOREIGN KEY `ordre_fk` (`ordre`) REFERENCES `fog_db`.`ordre` (`ordreNr`)
        ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fog_db`.`materialer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fog_db`.`materialer` (
  `materialeID` INT(11) NOT NULL AUTO_INCREMENT,
  `materialeNavn` VARCHAR(100) NULL DEFAULT NULL,
  `materialeBeskrivelse` varchar(5000) NULL DEFAULT NULL,
  `antal` INT NULL DEFAULT NULL,
  `tag` VARCHAR(100) NULL DEFAULT NULL,
  `pris` DOUBLE NULL DEFAULT NULL,
  `path` VARCHAR(150) NULL DEFAULT NULL,
  PRIMARY KEY (`materialeID`)
  )

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- noti

CREATE TABLE IF NOT EXISTS `fog_db`.`notificationer` (
  `notificationId` int(11) NOT NULL AUTO_INCREMENT,
    `brugerId` INT(11) NOT NULL,
    `ordreId` INT(11) NOT NULL,
  `beskrivelse` varchar(5000) NULL DEFAULT NULL,
   `ny` Boolean  DEFAULT true,
  PRIMARY KEY (`notificationId`, `brugerId`),
   CONSTRAINT `brugerId2`
    FOREIGN KEY (`brugerId`)
    REFERENCES `fog_db`.`bruger` (`brugerId`)
  )


ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
-- Some stuff to fill the pages
insert into tagtyper (tagtypeNavn,dækningsgrad) values ("TRAPEZPLADE BLÅTONET 109X600CM PLASTMO ECOLITE TAGPLADE PVC",0.35),
 ("Beton tegltagsten - Rød",8.9) ,("Beton tegltagsten - Sort	", 8.9),("EternittagB6 - Sort", 0.92),("EternittagB6 - Rødbrun",0.92),("EternittagB7 - Sort", 2.3),("EternittagB7 - Mokka",2.3);
insert into bruger(email, password, rolle) values("admin", "admin", "Admin");
insert into bruger(email, password, rolle) values("bruger", "bruger", "");

insert into materialer(materialeNavn, materialeBeskrivelse, tag, pris ,path)
values ("Trykimprægnerede stolpe 100x100mm", "Imprægneret stolpe til hegn, plankeværk eller andre
		udendørs byggeprojekter der kræver modstandsdygtigt og slidstærkt træ.",
		"default_stolpe", 76.99, "resources/Komponenter/StolpeTrykImp10x300cm.png"),
        ("Høvlet spærtræ 45x145 mm", "Høvlet spærtræ 45x145 mm trykimprægneret af fyr/gran anvendes
        til udendørs bærende konstruktioner. Spærtræet er derfor styrkesorteret og efterfølgende
        CE-mærket, så det er godkendt som konstruktionstræ. I daglig tale benævnes styrkesorteringen
        for spærtræ enten T1 eller K18. Trykimprægneret spærtræ bør ikke benyttes indendørs.",
        "default_spær", 61.50, "resources/Komponenter/HoevletSpaerTrae45x145.png"),
        ("TRAPEZPLADE BLÅTONET 109X600CM PLASTMO ECOLITE TAGPLADE PVC", "Perfekt til udestuen og carporten. Blåtonet. 109 x 240 cm",
        "default_bekældning", 250.00, "resources/Komponenter/blatonet-trapezplade-naturel-310-cm.jpg"),
        ("Beton tegltagsten - Rød", "Den klassiske danske tegltagsten. Formen og den smukke røde farve er et billede på Danmark.
        Dantegl er et helt igennem dansk naturprodukt, der bygger på stolte håndværksmæssige traditioner, der går mere end 1.000 år tilbage i tiden.",
        "bekældning", 72.85, "resources/Komponenter/beton-roed.jpg"),
        ("Beton tegltagsten - Sort", "En moderne tegltagsten. Formen og den smukke sorte farve er et billede af verdens forfald.
        Dantegl er et helt igennem dansk naturprodukt, der bygger på stolte håndværksmæssige traditioner, der går mere end en milliard år tilbage i tiden.",
        "bekældning", 72.85, "resources/Komponenter/beton-sort.jpg"),
		("EternittagB6 - Sort", "Den klassiske danske tegltagsten. Formen og den smukke røde farve er et billede på Danmark.
        Dantegl er et helt igennem dansk naturprodukt, der bygger på stolte håndværksmæssige traditioner, der går mere end 1.000 år tilbage i tiden.",
        "bekældning", 30.50, "resources/Komponenter/beton-sort.jpg"),
		("EternittagB6 - Rødbrun", "Den klassiske danske tegltagsten. Formen og den smukke røde farve er et billede på Danmark.
        Dantegl er et helt igennem dansk naturprodukt, der bygger på stolte håndværksmæssige traditioner, der går mere end 1.000 år tilbage i tiden.",
        "bekældning", 30.50, "resources/Komponenter/beton-roed.jpg"),
		("EternittagB7 - Mokka", "Den klassiske danske tegltagsten. Formen og den smukke røde farve er et billede på Danmark.
        Dantegl er et helt igennem dansk naturprodukt, der bygger på stolte håndværksmæssige traditioner, der går mere end 1.000 år tilbage i tiden.",
        "bekældning", 30.50, "resources/Komponenter/beton-sort.jpg");

insert into materialer(materialeNavn, pris, path, tag)
values("Carport 3,60X7,20M med redskabsrum 3,20X2,20M", 13447, "resources/Carporte/Carport1.png", "carport"),
	("Carport enkelt 3,60X5,40M med Høj rejsning", 39213, "resources/Carporte/Carport2.png", "carport"),
	("Carport 3,90X7,80M med redskabsrum 2,40X3,30M", 40000, "resources/Carporte/Carport3.png", "carport"),
	("Carport 3,60X8,10M med redskabsrum 3,05X3,20M", 11111, "resources/Carporte/Carport4.png", "carport"),
	("Carport 3,00X4,80M med Fladt tag", 19231, "resources/Carporte/Carport5.png", "carport");

insert into materialer(materialeNavn, pris, path, tag)
values("Plasttrapezplade-fladtag", 13447, "resources/Carporte/Carport1.png", "carport"),
	("Carport enkelt 3,60X5,40M med Høj rejsning", 39213, "resources/Carporte/Carport2.png", "carport"),
	("Carport 3,90X7,80M med redskabsrum 2,40X3,30M", 40000, "resources/Carporte/Carport3.png", "carport"),
	("Carport 3,60X8,10M med redskabsrum 3,05X3,20M", 11111, "resources/Carporte/Carport4.png", "carport"),
	("Carport 3,00X4,80M med Fladt tag", 19231, "resources/Carporte/Carport5.png", "carport");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;