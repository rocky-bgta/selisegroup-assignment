CREATE TABLE user (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL
);

CREATE TABLE role (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      role_name VARCHAR(255),
                      role_fk INT,
                      FOREIGN KEY (role_fk) REFERENCES user(id) ON DELETE CASCADE
);

INSERT INTO `user` (username, password) VALUES ('john_doe', 'password123');
INSERT INTO `user` (username, password) VALUES ('jane_doe', 'password456');


INSERT INTO role (role_name, role_fk) VALUES ('ROLE_USER', 1);
INSERT INTO role (role_name, role_fk) VALUES ('ROLE_ADMIN', 2);
