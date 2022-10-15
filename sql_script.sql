CREATE TABLE `hr_request`.`ticket_module` (
  `ticketid` INT NOT NULL,
  `asignee` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `tracker` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ticketid`));
