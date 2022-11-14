# 修改数据

* INSERT 插入新纪录
* UPDATE 更新已有数据
* DELETE 删除已有记录

## INSERT语法

INSERT INTO <tableName> (column1,column2,column3,...) VALUES (value1,value2,value3,...);

如果一个字段有默认值，在INSERT语句中可以不出现

字段的顺序不必和数据库表的字段顺序一致，但值的顺序和字段顺序一致。

可以一次添加多条数据，只要在VALUES字句中指定多个记录值，每个记录是由(...)包含一组值：

```sql
INSERT INTO students (class_id, name, gender, score)
VALUES (2, 'bob', 'M', 85),
       (2, 'bob', 'M', 85),
       (2, 'bob', 'M', 85)
;

```
## UPDATE

UPDATE tableName SET column1=value1,column2=value2,column3=value3,...WHERE...;
如果WHERE条件没有匹配到任何记录，UPDATE语句

## DELETE

DELETE FROM <表名> WHERE ...;

如果WHERE条件没有匹配到任何记录，UPDATE语句

不带条件的语句会删除整个表格