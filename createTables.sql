-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `workshop` DEFAULT CHARACTER SET utf8 ;
USE `workshop` ;

-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(80) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `address` VARCHAR(80) NOT NULL,
  `registration_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`work_day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `work_day` (
  `work_day_id` INT NOT NULL AUTO_INCREMENT,
  `from_day` ENUM('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY') NOT NULL,
  `from_hour` CHAR(2) NOT NULL,
  `from_min` CHAR(2) NOT NULL,
  `to_day` ENUM('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY') NOT NULL,
  `to_hour` CHAR(2) NOT NULL,
  `to_min` CHAR(2) NOT NULL,
  `client_client_id` INT NOT NULL,
  PRIMARY KEY (`work_day_id`),
  INDEX `fk_work_day_client_idx` (`client_client_id` ASC),
  CONSTRAINT `fk_work_day_client`
    FOREIGN KEY (`client_client_id`)
    REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `text` TEXT NOT NULL,
  `mark` TINYINT(5) NOT NULL,
  `client_client_id` INT NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_comment_client1_idx` (`client_client_id` ASC),
  CONSTRAINT `fk_comment_client1`
    FOREIGN KEY (`client_client_id`)
    REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `news` (
  `news_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `text` TEXT NOT NULL,
  `picture_url` VARCHAR(150) NOT NULL,
  `time` TIMESTAMP NOT NULL,
  `client_client_id` INT NOT NULL,
  PRIMARY KEY (`news_id`),
  INDEX `fk_news_client1_idx` (`client_client_id` ASC),
  CONSTRAINT `fk_news_client1`
  FOREIGN KEY (`client_client_id`)
  REFERENCES `client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
