CREATE TABLE  `hr_request`.`role`(
`role_id` INT NOT NULL,
`role` VARCHAR(45) NOT NULL,
`role_abbv` VARCHAR(15) NOT NULL,
 PRIMARY KEY (`role_id`));
 
 CREATE TABLE `hr_request`.`user`(
 `user_id` INT NOT NULL,
 `role_id` INT NOT NULL,
 `username` VARCHAR(45) NOT NULL,
 `user_fname` VARCHAR(45) NOT NULL,
 `user_lname` VARCHAR(45) NOT NULL,
 `password` VARCHAR(45) NOT NULL,
 `email` VARCHAR(45) NOT NULL,
 
 PRIMARY KEY (`user_id`),
 FOREIGN KEY (`role_id`) REFERENCES role(`role_id`));
 
   CREATE TABLE `hr_request`.`ticket_type`(
  `type_id` INT NOT NULL,
  `type_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  
  PRIMARY KEY(`type_id`));


CREATE TABLE `hr_request`.`ticket` (
  `ticket_id` INT NOT NULL,
  `assignee_id` INT NOT NULL,
  `sender_id` INT NOT NULL,
  `tracker_id` INT NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `status` VARCHAR(45) NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `expires_at` TIMESTAMP NULL,
    
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`assignee_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`sender_id`) REFERENCES user(`user_id`),
  FOREIGN KEY (`tracker_id`) REFERENCES ticket_type(`type_id`));
  
