# MySQL Workbench 6.3 CE

# Host: localhost    Database: pbms
# ------------------------------------------------------


#
# Table structure for table account
#
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `aId` VARCHAR(10) NOT NULL,
  `year` INT NOT NULL,
  `month` INT NOT NULL,
  `tInc` FLOAT NULL,
  `tExp` FLOAT NULL,
  PRIMARY KEY (`aId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

#
# Table structure for table income
#
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `iId` VARCHAR(10) NOT NULL,
  `year` INT NOT NULL,
  `month` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `money` FLOAT NOT NULL,
  PRIMARY KEY (`iId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

#
# Table structure for table expenditure
#
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `eId` VARCHAR(10) NOT NULL,
  `year` INT NOT NULL,
  `month` INT NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `money` FLOAT NOT NULL,
  PRIMARY KEY (`eId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;