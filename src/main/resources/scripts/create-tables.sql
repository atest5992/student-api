USE student_db;

CREATE TABLE student
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    email    VARCHAR(100) UNIQUE KEY NOT NULL,
    username VARCHAR(50) UNIQUE KEY  NOT NULL,
    password VARCHAR(1000)           NOT NULL
);

CREATE TABLE student_grade
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    grade      DOUBLE NOT NULL,
    grade_date DATE   NOT NULL,
    description       VARCHAR(100) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (id)
);