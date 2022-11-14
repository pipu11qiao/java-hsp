
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


