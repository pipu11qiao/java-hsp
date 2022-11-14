USE test;
SELECT id,name,gender,score FROM students
                            ORDER BY score DESC
LIMIT 3 OFFSET 0 ;

