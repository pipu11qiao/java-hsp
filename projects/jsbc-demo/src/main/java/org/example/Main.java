package org.example;

import java.sql.*;
import java.util.function.Function;

public class Main {
    static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "password";

    public static void prepare(Function<Connection, String> method) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            method.apply(conn);
        }
    }

    public static void main(String[] args) throws Exception {
        // JDBC连接的URL, 不同数据库有不同的格式:
        // 获取连接:
        prepare((Connection conn) -> {
            try {
//                find(conn);
                update(conn);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return "";
        });
        System.out.println("Hello world!");
    }

    public static void find(Connection conn) throws Exception {
        // 获取连接:
        try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
            ps.setObject(1, "M");
            ps.setObject(2, 3);
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

    public static void update(Connection conn) throws Exception {
        // 获取连接:
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (id,grade,name,gender,score) VALUES (?,?,?,?,?)")) {
            ps.setObject(1, 999);
            ps.setObject(2, 1);
            ps.setObject(3, "Bob");
            ps.setObject(4, 1);
            ps.setObject(5, 80);
            int n = ps.executeUpdate();
            System.out.println(n);
        }
    }
}
