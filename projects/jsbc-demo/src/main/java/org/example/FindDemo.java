package org.example;

import java.sql.*;
import java.util.function.Function;

public class FindDemo {
    static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
//        System.out.println("Hello world!");
        find();
    }
    public static void find() throws Exception {
        // 获取连接:
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.printf("id:%s,grade:%s,name:%s,gender:%s\n", id, grade, name, gender);
                    }
                }
            }        // TODO: 访问数据库...
        }
    }
}
