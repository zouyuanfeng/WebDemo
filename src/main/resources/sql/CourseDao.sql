#2nd其次执行
CREATE TABLE Course
(
  Cno   CHAR(5) PRIMARY KEY NOT NULL,
  Cname VARCHAR(10)         NOT NULL,
  Tno   VARCHAR(50)         NOT NULL,
  FOREIGN KEY (Tno) REFERENCES Teacher (Tno)
);
INSERT INTO Course VALUES ('3-105', '计算机导论', '825');
INSERT INTO Course VALUES ('3-245', '操作系统', '804');
INSERT INTO Course VALUES ('6-166', '数字电路', '856');
INSERT INTO Course VALUES ('9-888', '高等数学', '831');

SELECT *
FROM Course;
# DELETE FROM Course

SELECT c.Cno, c.Cname, c.Tno, t.Tno, t.Depart, t.Prof, t.Tbirthday, t.Tname, t.Tsex FROM course c LEFT OUTER JOIN teacher t ON c.Tno = t.Tno