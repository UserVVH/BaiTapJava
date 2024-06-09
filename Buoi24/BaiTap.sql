CREATE DATABASE company;

USE company;

CREATE TABLE user(
	id INT AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	passwd VARCHAR(255) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
    	username VARCHAR(50) NOT NULL,
    	phone VARCHAR(20) NOT NULL,
    	role_id INT, 
    	PRIMARY KEY(id)
);

ALTER TABLE `user` ADD CONSTRAINT fk_role_id FOREIGN KEY(role_id) REFERENCES role(id);

CREATE TABLE role(
	id INT AUTO_INCREMENT,
	description VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE task(
	id INT AUTO_INCREMENT,
	user_id INT,
	project_id INT,
	status_id INT,
	name VARCHAR(255) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	PRIMARY KEY(id)
);

ALTER TABLE `task` ADD CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES user(id);
ALTER TABLE `task` ADD CONSTRAINT fk_status_id FOREIGN KEY(status_id) REFERENCES status(id);
ALTER TABLE `task` ADD CONSTRAINT fk_project_id FOREIGN KEY(project_id) REFERENCES project(id);

CREATE TABLE status(
	id INT AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE project(
	id INT AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	PRIMARY KEY(id)
);
