-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gi_plast
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gi_plast
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gi_plast` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci ;
USE `gi_plast` ;

-- -----------------------------------------------------
-- Table `gi_plast`.`extruder_nev`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`extruder_nev` (
  `extruder_id` INT NOT NULL AUTO_INCREMENT,
  `extruder_nev` VARCHAR(60) NULL,
  PRIMARY KEY (`extruder_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`dolgozok`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`dolgozok` (
  `dolgozok_id` INT NOT NULL AUTO_INCREMENT,
  `dolgozok_nev` VARCHAR(60) NULL,
  `dolgozok_azonosito` VARCHAR(45) NULL,
  `dolgozok_aktiv` VARCHAR(10) NULL,
  PRIMARY KEY (`dolgozok_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`belepes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`belepes` (
  `belepes_id` INT NOT NULL AUTO_INCREMENT,
  `belepes_nev` VARCHAR(60) NULL,
  `belepes_jelszo` VARCHAR(45) NULL,
  `jogkor` VARCHAR(45) NULL,
  PRIMARY KEY (`belepes_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`megrendelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`megrendelo` (
  `megrendelo_id` INT NOT NULL AUTO_INCREMENT,
  `megrendelo_nev` VARCHAR(45) NULL,
  `megrendelo_iranyitoszam` VARCHAR(20) NULL,
  `megrendelo_helyseg` VARCHAR(30) NULL,
  `megrendelo_utca` VARCHAR(50) NULL,
  `megrendelo_mobil` VARCHAR(20) NULL,
  `megrendelo_email` VARCHAR(45) NULL,
  `megrendelo_megjegyzes` VARCHAR(255) NULL,
  PRIMARY KEY (`megrendelo_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`receptura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`receptura` (
  `alapanyag_id` INT NOT NULL,
  `alapanyag_nev` VARCHAR(100) NULL,
  `ossz_kg` INT NULL,
  `alap_nev_a` VARCHAR(45) NULL,
  `alap_nev_b` VARCHAR(45) NULL,
  `alap_nev_c` VARCHAR(45) NULL,
  `alap_nev_d` VARCHAR(45) NULL,
  `alap_nev_e` VARCHAR(45) NULL,
  `alap_nev_f` VARCHAR(45) NULL,
  `alap_nev_g` VARCHAR(45) NULL,
  `alap_nev_h` VARCHAR(45) NULL,
  `alap_szazalek_a` VARCHAR(45) NULL,
  `alap_szazalek_b` VARCHAR(45) NULL,
  `alap_szazalek_c` VARCHAR(45) NULL,
  `alap_szazalek_d` VARCHAR(45) NULL,
  `alap_szazalek_e` VARCHAR(45) NULL,
  `alap_szazalek_f` VARCHAR(45) NULL,
  `alap_szazalek_g` VARCHAR(45) NULL,
  `alap_szazalek_h` VARCHAR(45) NULL,
  `alap_kg_a` VARCHAR(45) NULL,
  `alap_kg_b` VARCHAR(45) NULL,
  `alap_kg_c` VARCHAR(45) NULL,
  `alap_kg_d` VARCHAR(45) NULL,
  `alap_kg_e` VARCHAR(45) NULL,
  `alap_kg_f` VARCHAR(45) NULL,
  `alap_kg_g` VARCHAR(45) NULL,
  `alap_kg_h` VARCHAR(45) NULL,
  PRIMARY KEY (`alapanyag_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`csomagolas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`csomagolas` (
  `csomagolas_id` INT NOT NULL,
  `cseve_tipus` VARCHAR(60) NULL,
  `cseve_hossz` VARCHAR(45) NULL,
  `cseve_vastagsag` VARCHAR(45) NULL,
  `tekercs_atmero` VARCHAR(45) NULL,
  `tekercs_tomeg` VARCHAR(45) NULL,
  `tekercs_hossz` VARCHAR(45) NULL,
  `tekrecs_atmero_min` VARCHAR(45) NULL,
  `tekercs_tomeg_min` VARCHAR(45) NULL,
  `tekercs_hossz_min` VARCHAR(45) NULL,
  `egyedi_vevo` LONGTEXT NULL,
  `raklap_tipus` VARCHAR(45) NULL,
  `tekercs_szama` VARCHAR(45) NULL,
  `b_raklaptomeg` VARCHAR(45) NULL,
  `n_raklaptomeg` VARCHAR(45) NULL,
  `nn_raklaptomeg` VARCHAR(45) NULL,
  `tekercs_helyezes` LONGTEXT NULL,
  `egyeb_megjegyzes` LONGTEXT NULL,
  `raklap_csomagolas` LONGTEXT NULL,
  `raklap_megjegyzes` LONGTEXT NULL,
  PRIMARY KEY (`csomagolas_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`extruder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`extruder` (
  `extruder_id` INT NOT NULL AUTO_INCREMENT,
  `megrendelo_megrendelo_id` INT NOT NULL,
  `azonostio` VARCHAR(20) NULL,
  `allapot` VARCHAR(45) NULL,
  `felvetel_idopont` DATE NULL,
  `hatarido` DATE NULL,
  `alapanyag` VARCHAR(100) NULL,
  `tenyleges_meret` VARCHAR(45) NULL,
  `meret_szeleseg` VARCHAR(10) NULL,
  `meret_hossz` VARCHAR(10) NULL,
  `vastagsag` VARCHAR(10) NULL,
  `zsak_siklap` VARCHAR(1) NULL,
  `gramm_meter` VARCHAR(45) NULL,
  `megrendelt_kg` VARCHAR(45) NULL,
  `extruder_nev` VARCHAR(60) NULL,
  `megjegyzes` LONGTEXT NULL,
  `prioritas` VARCHAR(5) NULL,
  `receptura_alapanyag_id` INT NULL,
  `csomagolas_csomagolas_id` INT NULL,
  PRIMARY KEY (`extruder_id`),
  INDEX `fk_extruder_1_megrendelo_idx` (`megrendelo_megrendelo_id` ASC) VISIBLE,
  INDEX `fk_extruder_receptura1_idx` (`receptura_alapanyag_id` ASC) VISIBLE,
  INDEX `fk_extruder_csomagolas1_idx` (`csomagolas_csomagolas_id` ASC) VISIBLE,
  CONSTRAINT `fk_extruder_1_megrendelo`
    FOREIGN KEY (`megrendelo_megrendelo_id`)
    REFERENCES `gi_plast`.`megrendelo` (`megrendelo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_extruder_receptura1`
    FOREIGN KEY (`receptura_alapanyag_id`)
    REFERENCES `gi_plast`.`receptura` (`alapanyag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_extruder_csomagolas1`
    FOREIGN KEY (`csomagolas_csomagolas_id`)
    REFERENCES `gi_plast`.`csomagolas` (`csomagolas_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `gi_plast`.`alapanyag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`alapanyag` (
  `alapanyag_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`alapanyag_id`));


-- -----------------------------------------------------
-- Table `gi_plast`.`alapanyag_szamitas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gi_plast`.`alapanyag_szamitas` (
  `alapanyag_id` INT NOT NULL AUTO_INCREMENT,
  `alapanyag_nev` VARCHAR(100) NULL,
  `ossz_kg` INT NULL,
  `alap_nev_a` VARCHAR(45) NULL,
  `alap_nev_b` VARCHAR(45) NULL,
  `alap_nev_c` VARCHAR(45) NULL,
  `alap_nev_d` VARCHAR(45) NULL,
  `alap_nev_e` VARCHAR(45) NULL,
  `alap_nev_f` VARCHAR(45) NULL,
  `alap_nev_g` VARCHAR(45) NULL,
  `alap_nev_h` VARCHAR(45) NULL,
  `alap_szazalek_a` VARCHAR(45) NULL,
  `alap_szazalek_b` VARCHAR(45) NULL,
  `alap_szazalek_c` VARCHAR(45) NULL,
  `alap_szazalek_d` VARCHAR(45) NULL,
  `alap_szazalek_e` VARCHAR(45) NULL,
  `alap_szazalek_f` VARCHAR(45) NULL,
  `alap_szazalek_g` VARCHAR(45) NULL,
  `alap_szazalek_h` VARCHAR(45) NULL,
  `alap_kg_a` VARCHAR(45) NULL,
  `alap_kg_b` VARCHAR(45) NULL,
  `alap_kg_c` VARCHAR(45) NULL,
  `alap_kg_d` VARCHAR(45) NULL,
  `alap_kg_e` VARCHAR(45) NULL,
  `alap_kg_f` VARCHAR(45) NULL,
  `alap_kg_g` VARCHAR(45) NULL,
  `alap_kg_h` VARCHAR(45) NULL,
  PRIMARY KEY (`alapanyag_id`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
