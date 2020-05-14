-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Table `bd_pas`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_pas`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(5000) NOT NULL,
  `title` VARCHAR(500) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_news_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_news_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_pas`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `source` VARCHAR(255) NOT NULL,
  `news_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_image_news_idx` (`news_id` ASC),
  CONSTRAINT `image_fk_news_id`
    FOREIGN KEY (`news_id`)
    REFERENCES `news` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_pas`.`subscription`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subscription` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_email` VARCHAR(255) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_subscription_category1_idx` (`category_id` ASC),
  CONSTRAINT `subscription_fk_category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;