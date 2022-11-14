
mysql基本语句

查询数据库、表

```sql
SHOW DATABASES;
SHOW TABLES;
```

1. 基础查询

```sql
SELECT * FROM 表名;
```
2. 条件查询

```sql
SELECT * FROM students WHERE score >= 80;
```

条件查询的语法是

```sql
SELECT * FROM <表名> WHERE <条件表达式>
```

第一种，条件表达式可以用 <条件1> AND <条件2> 表达满足条件1并且满足条件2。
第二种， <条件1> OR <条件2>
第三种，NOT <条件>

要组合三个或者更多的条件，就需要用到小括号()表示如何进行条件运算。

```sql
SELECT * FROM students WHERE (score < 80 OR score > 90) AND gender = 'M';
```

如果不加括号会根据关系关键字的优先级进行组合，优先级顺序是NOT，AND,OR。

常用的条件表达式
```sql

=
>
>=
<
<=
<>
LIKE

```

3. 投影查询

使用SELECT * FROM 表 查询的结果每一个记录包含了原表中的所有字段，如果想要查询某个字段使用语法SELECT 列1，列2，列3 FROM 表  来查询具体想要查询的列，这种查询方式就做投影查询。
还可以使用别名 SELECT 列1 别名1，列2 别名2，列3 别名3 FROM 表
4. 排序
默认的排序规则是按照主键排序，可以制定排序的规则，使用ORDER BY的方式
顺序是升序排列，如果想要按照倒序排列要加上DESC表示倒序


5. 分页查询
LIMIT size OFFSET count
可见，分页查询的关键在于，首先要确定每页需要显示的结果数量size，
* LIMIT 总是设定为pageSize
* OFFSET 计算公式为 PageSize * (pageIndex-1)
6. 聚合查询

对于统计总数，平均数这类计算，SQL提供了专门的聚合函数，使用聚合函数进行查询，就是聚合查询。

* COUNT
* SUM
* AVG
* MAX
* MIN

分组聚合

GROUP BY


7. 多表查询
8. 连接查询


