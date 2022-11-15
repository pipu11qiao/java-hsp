# mysql 相关知识

命令行链接

> mysql -u root -p

输入密码后提示符变为 mysql>

输入exit断开与MySQL Server的链接并返回到命令提示符
> EXIT

#### 链接远程的mysqlserver

> mysql -h 10.0.0.1 -u root -p

命令行程序实际上是MySQL客户端，真正的MySQL服务器程序是mysqld，在后台运行。

## 管理mysql

### 数据库

1. 查看所有数据库

> SHOW DATABASES;

其中 information_schema,mysql,performance_schema,sys是系统库，不要改动它们。

2. 创建数据库

> CREATE DATABASE test;

3. 删除数据库

> DROP DATABASE test;

4. 对一个数据库进行操作时，将其切换为当前数据库

> USE test;

### 表

1. 显示当前数据库中的所有表

> SHOW TABLES;

2. 查看表结构

> DESC students;

3. 查看创建表的SQL语句

> SHOW CREATE TABLE students;

4. 创建和删除表

> CREATE TABLE students;
> DROP TABLE students;

5. 修改表 新增一列

> ALTER TABLE students ADD COLUMN birth VARCHAR(10) NOT NULL;

6. 修改表 修改列名和类型信息

> ALTER TABLE students CHANGE COLUMN birth birthday VARCHAR(20) NOT NULL;

7. 修改表，删除列

> ALTER TABLE students DROP COLUMN birthday;

### 实用SQL语句

1. 插入或替换
   如果我们想插入一条新纪录，如果记录存在就先删除原纪录，在插入新纪录。 可以使用REPLACE语句

> REPLACE INTO students (id,class_id,name,gender,score) VALUES (1,1,'小明','F',99);

若id=1不存在，插入新的记录，若id=1存在就先删除原纪录，插入新纪录。

2. 插入或更新
   如果我们希望插入一条新纪录，若果记录存在，就更新该记录。 可以使用INSERT INTO ... ON DUPLICATE KEY UPDATE ...

> INSERT INTO students (id,class_id,name,gender,score) VALUES (1,1,'小明','F',99) ON DUPLICATE KEY UPDATE name='小明'
> ,gender='F',score=99;

若id=1不存在就根据insert语句更新，如果存在，跟新字段由UPDATE指定

3. 插入或忽略

如果我们希望插入一条记录，但如果记录存在，就忽略 INSERT IGNORE INTO

> INSERT IGNORE INTO students (id,class_id,name,gender,score) VALUES (1,1,'小明'，'F',99);

4. 快照

如果想要对一个表进行快照，即复制一份当前表的数据到一个表，可以结合CREATE TABLE 和 SELECT

> CREATE TABLE students_of_class1 SELECT * FROM students WHERE class_id=1;

5. 写入查询结果集





