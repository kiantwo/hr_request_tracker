INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (001, "John Doe","Active", "Request for salary increase", "","IT Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (002, "Thor Java","Cancelled", "Request for leave", "Would like to take a vacation" ,"IT Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (003, "Gad Gadiane","Inactive", "Conflict with colleague", "Keeps stealing my lunch", "Finance Dept");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (004, "Maria Gad","Declined", "Request for transfer of management", "Would like to manage different area", "Management");
INSERT into ticket_module(ticketid, asignee,status,subject,description,tracker) values (005, "John Doe","Approved", "Request for team building","New training and seminars", "IT Dept");

USE hr_request;

INSERT into role(role_id, role_name, role_abbv) values(500, "Admin", "ADMIN");
INSERT into role(role_id, role_name, role_abbv) values(501, "Developer", "DEV");
INSERT into role(role_id, role_name, role_abbv) values(502, "Project Manager", "PM");
INSERT into role(role_id, role_name, role_abbv) values(503, "Human Resources", "HR");

INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (100, 500, "admin", "Admin", "", "123456", "admin@alliance.com");
INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (101, 503, "saturnina", "Saturnina", "Alvarez", "123456", "saturnina@alliance.com");
INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (102, 503, "rejine", "Rejine", "Alquisa", "123456", "alquisa@alliance.com");
INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (103, 503, "pelisa", "Pelisa Jane", "Ligalig", "123456", "pjligalig@alliance.com");
INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (104, 503, "giselle", "Ma. Giselle", "Mabunga", "123456", "giselle@alliance.com");
INSERT into user(user_id, role_id, username, user_fname, user_lname, password, email) values (105, 503, "jasmine", "Jasmine", "Patalinghug", "123456", "jasminep@alliance.com");

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

INSERT into user_ticket(assignee_id, tracker_id) values(101, 200);
INSERT into user_ticket(assignee_id, tracker_id) values(102, 201);
INSERT into user_ticket(assignee_id, tracker_id) values(103, 202);
INSERT into user_ticket(assignee_id, tracker_id) values(104, 203);
INSERT into user_ticket(assignee_id, tracker_id) values(104, 204);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 205);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 206);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 207);
INSERT into user_ticket(assignee_id, tracker_id) values(105, 208);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 209);
INSERT into user_ticket(assignee_id, tracker_id) values(101, 210);
INSERT into user_ticket(assignee_id, tracker_id) values(105, 211);

INSERT INTO status(status_id, status_name, description) values (400, "Active", "");
INSERT INTO status(status_id, status_name, description) values (401, "Inactive", "");
INSERT INTO status(status_id, status_name, description) values (402, "Canceled", "");

INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status_id, description, created_at) values (300, 101, 200, "Request for salary increase", 400, "", "2022-10-01");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status_id, description, created_at) values (301, 101, 201, "Request for leave", 402, "Would like to take a vacation", "2022-10-03");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status_id, description, created_at) values (302, 101, 203, "Conflict with colleague", 401, "Keeps stealing my lunch", "2022-10-04");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status_id, description, created_at) values (303, 101, 203, "Request for transfer of management", 402,  "Would like to manage different area", "2022-11-22");
INSERT into ticket(ticket_id, assignee_id, tracker_id, subject, status_id, description, created_at) values (304, 101, 205,"Request for team building", 400, "New training and seminars", "2022-11-25");

