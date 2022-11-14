USE test;
SELECT COUNT(*) FROM students;
SELECT COUNT(*) num FROM students;

SELECT class_id,COUNT(*) num FROM students GROUP BY class_id;