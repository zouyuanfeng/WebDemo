CREATE TABLE Teacher
(
  Tno       VARCHAR(50) PRIMARY KEY NOT NULL,
  Tname     VARCHAR(50)             NOT NULL,
  Tsex      VARCHAR(50)             NOT NULL,
  Tbirthday DATETIME,
  Prof      VARCHAR(50),
  Depart    VARCHAR(10)             NOT NULL
);
INSERT INTO Teacher VALUES (804, '李诚', '男', '1958-12-02', '副教授', '计算机系');
INSERT INTO Teacher VALUES (856, '张旭', '男', '1969-03-12', '讲师', '电子工程系');
INSERT INTO Teacher VALUES (825, '王萍', '女', '1972-05-05', '助教', '计算机系');
INSERT INTO Teacher VALUES (831, '刘冰', '女', '1977-08-14', '助教', '电子工程系');


SELECT *
FROM Teacher;

