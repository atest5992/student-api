DROP DATABASE IF EXISTS student_db;

CREATE DATABASE student_db DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE USER 'student_admin'@'localhost' IDENTIFIED BY 'student_pass';
GRANT ALL PRIVILEGES ON student_db.* TO 'student_admin'@'localhost'  WITH GRANT OPTION;
FLUSH PRIVILEGES;