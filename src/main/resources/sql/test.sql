SELECT *
FROM teacher;

SELECT *
FROM teacher
WHERE Tname NOT LIKE '王%';

SELECT *
FROM teacher
WHERE Tname IN ('刘冰', '李诚');

SELECT *
FROM teacher
WHERE Tno BETWEEN 825 AND 831;

SELECT Tname AS name
FROM teacher;

SELECT *
FROM course;

SELECT
  c.Tno AS no,
  t.Tname,
  c.Cname
FROM teacher AS t, course AS c
WHERE t.Tno = C.Tno;

# JOIN: 如果表中有至少一个匹配，则返回行  INNER JOIN 与 JOIN 是相同的。
# LEFT JOIN: 即使右表中没有匹配，也从左表返回所有的行
# RIGHT JOIN: 即使左表中没有匹配，也从右表返回所有的行
# FULL JOIN: 只要其中一个表中存在匹配，就返回行
SELECT
  t.Tno AS no,
  t.Tname,
  c.Cname
FROM teacher AS t
  INNER JOIN course AS c
    ON t.Tno = c.Tno
ORDER BY t.Tno;

SELECT
  t.Tno AS no,
  t.Tname,
  c.Cname
FROM teacher AS t
  LEFT JOIN course AS c
    ON t.Tno = c.Tno
ORDER BY t.Tno;

#创建一个索引
CREATE INDEX teacherIndex
  ON teacher (Tno ASC, Tname);
#删除索引
DROP INDEX teacherIndex
ON teacher;

SELECT *
FROM score;


SELECT avg(score.Degree) AS degree
FROM score;

# 查询高于平均分的
SELECT *
FROM score
WHERE Degree > (SELECT avg(Degree)
                FROM score);

# 统计部门数
SELECT count(DISTINCT Depart) AS depart
FROM teacher;

SELECT max(Degree)
FROM score;

SELECT *,now()
FROM teacher
GROUP BY Depart;

