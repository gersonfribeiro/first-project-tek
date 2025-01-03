CREATE TABLE tasks (
	id_task INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    descriptionTask text,
    statusTask ENUM('PENDING', 'IN_PROGRESS', 'COMPLETED'),
    priority ENUM('LOW', 'MEDIUM', 'HIGH'),
    PRIMARY KEY (id_task)
);

CREATE TABLE users (
	id_user INT NOT NULL AUTO_INCREMENT,
    username varchar(30) NOT NULL,
    email varchar(100) NOT NULL UNIQUE,
    passwordUser varchar(255) NOT NULL,
    PRIMARY KEY (id_user)
);
