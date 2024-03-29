DROP TABLE IF EXISTS `hr_request`.`role`;

CREATE TABLE `hr_request`.`role`(
	`role_id` INT NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(45) NOT NULL,
    `role_abbv` VARCHAR(15) NOT NULL,
PRIMARY KEY(`role_id`));

DROP TABLE IF EXISTS `hr_request`.`user`;

CREATE TABLE `hr_request`.`user`(
 `user_id` INT NOT NULL AUTO_INCREMENT,
 `role_id` INT NOT NULL,
 `username` VARCHAR(45) NOT NULL,
 `user_fname` VARCHAR(45) NOT NULL,
 `user_lname` VARCHAR(45) NOT NULL,
 `password` VARCHAR(45) NOT NULL,
 `email` VARCHAR(45) NOT NULL,
 
 PRIMARY KEY (`user_id`),
 FOREIGN KEY (`role_id`) REFERENCES role(`role_id`));
 
 DROP TABLE IF EXISTS `hr_request`.`token`;
 
 CREATE TABLE `hr_request`.`token`(
	`token_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `auth_token` VARCHAR(100),
    `expires_at` VARCHAR(45) NULL,
	
    PRIMARY KEY(`token_id`),
    FOREIGN KEY(`user_id`) REFERENCES user(`user_id`));
 
 DROP TABLE IF EXISTS `hr_request`.`ticket_type`;
 
CREATE TABLE `hr_request`.`ticket_type`(
  `type_id` INT NOT NULL AUTO_INCREMENT,
  `type_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  
  PRIMARY KEY(`type_id`));
  
DROP TABLE IF EXISTS `hr_request`.`user_ticket`;
  
CREATE TABLE `hr_request`.`user_ticket`(
	`assignee_id` INT NOT NULL,
    `tracker_id` INT NOT NULL,
  
  PRIMARY KEY(`assignee_id`, `tracker_id`),
  FOREIGN KEY (`assignee_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`tracker_id`) REFERENCES ticket_type(`type_id`));

DROP TABLE IF EXISTS `hr_request`.`status`;

CREATE TABLE `hr_request`.`status` (
	`status_id` INT NOT NULL AUTO_INCREMENT,
    `status_name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
	
    PRIMARY KEY(`status_id`));
    
DROP TABLE IF EXISTS `hr_request`.`file`;

CREATE TABLE `hr_request`.`file` (
	`file_id` INT NOT NULL AUTO_INCREMENT,
    `file_name` VARCHAR(100),
    `file_type` VARCHAR(25),
    `file_data` MEDIUMBLOB,
	PRIMARY KEY(`file_id`));

DROP TABLE IF EXISTS `hr_request`.`ticket`;

CREATE TABLE `hr_request`.`ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `assignee_id` INT NOT NULL,
  `tracker_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `file_id` INT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `created_at` VARCHAR(45) NULL,
  `expires_at` TIMESTAMP NULL,
    
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`assignee_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`tracker_id`) REFERENCES ticket_type(`type_id`),
  FOREIGN KEY (`status_id`) REFERENCES status(`status_id`),
  FOREIGN KEY (`file_id`) REFERENCES file(`file_id`));
  