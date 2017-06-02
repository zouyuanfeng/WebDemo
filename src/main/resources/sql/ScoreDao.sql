#最后执行
CREATE TABLE Score
(
  Sno    INT     NOT NULL,
  Cno    CHAR(5) NOT NULL,
  Degree DECIMAL(4, 1),
  FOREIGN KEY (Sno)
  REFERENCES Student (Sno),
  FOREIGN KEY (Cno)
  REFERENCES Course (Cno),
  PRIMARY KEY (Sno, Cno)
);
INSERT INTO Score VALUES (103, '3-245', 86);
INSERT INTO Score VALUES (105, '3-245', 75);
INSERT INTO Score VALUES (109, '3-245', 68);
INSERT INTO Score VALUES (103, '3-105', 92);
INSERT INTO Score VALUES (105, '3-105', 88);
INSERT INTO Score VALUES (109, '3-105', 76);

INSERT INTO Score VALUES (101, '3-105', 64);
INSERT INTO Score VALUES (107, '3-105', 91);
INSERT INTO Score VALUES (108, '3-105', 78);
INSERT INTO Score VALUES (101, '6-166', 85);
INSERT INTO Score VALUES (107, '6-166', 79);
INSERT INTO Score VALUES (108, '6-166', 81);

SELECT *
FROM Score;
# DELETE FROM Score


