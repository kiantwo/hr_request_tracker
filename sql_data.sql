INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (001, "John Doe","Active", "Request for salary increase", "","IT Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (002, "Thor Java","Cancelled", "Request for leave", "Would like to take a vacation" ,"IT Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (003, "Gad Gadiane","Inactive", "Conflict with colleague", "Keeps stealing my lunch", "Finance Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (004, "Maria Gad","Declined", "Request for transfer of management", "Would like to manage different area", "Management");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (005, "John Doe","Approved", "Request for team building","New training and seminars", "IT Dept");

USE hr_request;

INSERT into user(user_id, username, user_fname, user_lname, password, email) values (100, "saturnina", "Saturnina", "Alvarez", "123456", "saturnina@alliance.com");
INSERT into user(user_id, username, user_fname, user_lname, password, email) values (101, "rejine", "Rejine", "Alquisa", "123456", "alquisa@alliance.com");
INSERT into user(user_id, username, user_fname, user_lname, password, email) values (102, "pelisa", "Pelisa Jane", "Ligalig", "123456", "pjligalig@alliance.com");
INSERT into user(user_id, username, user_fname, user_lname, password, email) values (103, "giselle", "Ma. Giselle", "Mabunga", "123456", "giselle@alliance.com");
INSERT into user(user_id, username, user_fname, user_lname, password, email) values (104, "jasmine", "Jasmine", "Patalinghug", "123456", "jasminep@alliance.com");

INSERT INTO ticket_type(type_id, type_name, description) values(200, "Benefits", "");
INSERT INTO ticket_type(type_id, type_name, description) values(201, "Payroll", "");
INSERT INTO ticket_type(type_id, type_name, description) values(202, "Recruitment", "");
INSERT INTO ticket_type(type_id, type_name, description) values(203, "Training", "");
INSERT INTO ticket_type(type_id, type_name, description) values(204, "PES", "");
INSERT INTO ticket_type(type_id, type_name, description) values(205, "Employee Relation", "");
INSERT INTO ticket_type(type_id, type_name, description) values(206, "Memo", "");
INSERT INTO ticket_type(type_id, type_name, description) values(207, "COE", "");
INSERT INTO ticket_type(type_id, type_name, description) values(208, "Engagement (RNR)", "");
INSERT INTO ticket_type(type_id, type_name, description) values(209, "Policy", "");
INSERT INTO ticket_type(type_id, type_name, description) values(210, "Others", "");
INSERT INTO ticket_type(type_id, type_name, description) values(211, "HR Business Partner", "");

INSERT into user_ticket(assignee_id, tracker_id) values(100, 200);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 201);
INSERT into user_ticket(assignee_id, tracker_id) values(102, 202);
INSERT into user_ticket(assignee_id, tracker_id) values(103, 203);
INSERT into user_ticket(assignee_id, tracker_id) values(103, 204);
INSERT into user_ticket(assignee_id, tracker_id) values(100, 205);
INSERT into user_ticket(assignee_id, tracker_id) values(100, 206);
INSERT into user_ticket(assignee_id, tracker_id) values(100, 207);
INSERT into user_ticket(assignee_id, tracker_id) values(104, 208);
INSERT into user_ticket(assignee_id, tracker_id) values(100, 209);
INSERT into user_ticket(assignee_id, tracker_id) values(100, 210);
INSERT into user_ticket(assignee_id, tracker_id) values(104, 211);

INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status, description) values (300, 100, 200, "Request for salary increase", "Active", "");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status, description) values (301, 101, 201, "Request for leave", "Cancelled", "Would like to take a vacation");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status, description) values (302, 102, 203, "Conflict with colleague", "Inactive", "Keeps stealing my lunch");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status, description) values (303, 103, 203, "Request for transfer of management", "Declined",  "Would like to manage different area");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status, description) values (304, 100, 205,"Request for team building", "Approved", "New training and seminars");



