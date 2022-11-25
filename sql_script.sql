DROP TABLE IF EXISTS `hr_request`.`user`;

CREATE TABLE `hr_request`.`user`(
 `user_id` INT NOT NULL AUTO_INCREMENT,
 `username` VARCHAR(45) NOT NULL,
 `user_fname` VARCHAR(45) NOT NULL,
 `user_lname` VARCHAR(45) NOT NULL,
 `password` VARCHAR(45) NOT NULL,
 `email` VARCHAR(45) NOT NULL,
 
 PRIMARY KEY (`user_id`));
 
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

DROP TABLE IF EXISTS `hr_request`.`ticket`;

CREATE TABLE `hr_request`.`ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `assignee_id` INT NOT NULL,
  `tracker_id` INT NOT NULL,
  `status_id` INT NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `created_at` VARCHAR(45) NULL,
  `expires_at` TIMESTAMP NULL,
    
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`assignee_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`tracker_id`) REFERENCES ticket_type(`type_id`),
  FOREIGN KEY (`status_id`) REFERENCES status(`status_id`));
  