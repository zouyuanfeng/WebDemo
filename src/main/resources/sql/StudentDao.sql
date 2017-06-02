# 第三个执行
CREATE TABLE Student (
  Sno       INT PRIMARY KEY NOT NULL,
  Sname     VARCHAR(50)     NOT NULL,
  Ssex      VARCHAR(10)     NOT NULL DEFAULT '男',
  Sbirthday DATETIME,
  Class     INT             NOT NULL

);

TRUNCATE TABLE Student;
INSERT INTO Student VALUES (108, '曾华', '男', '1977-09-01', 95033);
INSERT INTO Student VALUES (105, '匡明', '男', '1975-10-02', 95031);
INSERT INTO Student VALUES (107, '王丽', '女', '1976-01-23', 95033);
INSERT INTO Student VALUES (101, '李军', '男', '1976-02-20', 95033);
INSERT INTO Student VALUES (109, '王芳', '女', '1975-02-10', 95031);
INSERT INTO Student VALUES (103, '陆君', '男', '1974-06-03', 95031);

SELECT *
FROM Student;
# DELETE FROM Student;