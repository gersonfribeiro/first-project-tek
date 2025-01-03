CREATE TABLE users (
id_user varchar(36),
username varchar(100),
email varchar(100),
passwordUser varchar(255)
);

CREATE TABLE tasks (
 id_task varchar(36),
 title varchar(100),
 descriptionTask text,
 statusTask varchar(20),
 priority varchar(20),
 createdDate date
);
