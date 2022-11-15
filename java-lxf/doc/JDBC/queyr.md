

## 基本链接

mysql 的本地连接地址，用户名和密码 

通过DriverManager.getConnection 方法来连接数据库。DriverManager会自动扫描classpath，找到所有的JDBC驱动，然后根据我们传入的URL自动挑选一个合适的驱动。
```java

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // JDBC 链接的URL，不同数据库有不同的格式：
        String JDBC_URL = "jdbc:mysql://localhost:3306/test";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "password";

        // 获取链接：
        Connection conn = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        // 关闭链接
        conn.close();
    }
}

```
tray (resource) 


### JDBC 查询
获取到JDBC链接后，下一步我们就可以查询数据库了。查询数据库分以下几步：

1. 通过Connection 提供的createStatement() 方法创建一个 Statement 对象，用于执行一个查询：
2. 执行Statement对象提供的executeQuery("SELECT * FROM students") 并传入SQL语句，执行查询并获得返回的结果集，使用ResultSet来引用这个结果集：
3. 反复调用ResultSet的next()方法并读取每一行结果

```java
        // 获取链接：
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("SELECT  id,grade,name,gender FROM students WHERE gender=1")) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                    }
                }

            }
        }

```
Statement 和 ResultSet 都是需要关闭的资源，因此嵌套使用 try(resource) 
rs.next 用于判断是否有下一行的记录，若果有，将自动吧当前行移动到下一行，一开始获得的rs并不是第一行
ResultSet获取列时，索引从1开始而不是0
必须根据SELECT的列的对应位置来调用getLong,乳沟对应位置的数据类型不对，将报错。

#### SQL 注入

使用PreparedStatement 来避免sql注入。



