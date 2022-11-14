SELECT s.id, s.name, s.class_id, c.name, s.gender, s.score
FROM students s
         INNER JOIN classes c
                    ON s.class_id = c.id;