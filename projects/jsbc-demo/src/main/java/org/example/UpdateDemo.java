package org.example;

import java.sql.*;
import java.util.function.Function;

public class UpdateDemo {
    static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        deleteItem();
        insertWithAutoKey();
        FindDemo.find();
        System.out.println("Hello world!");
    }


    public static void insert() throws Exception {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
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
        // 获取连接:
    }

    public static void insertWithAutoKey() throws Exception {

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (grade,name,gender,score) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 1);
                ps.setObject(2, "Bob");
                ps.setObject(3, 1);
                ps.setObject(4, 80);
                int n = ps.executeUpdate();
                System.out.println(n);
            }
        }
        // 获取连接:
    }

    public static void update() throws Exception {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "huahua");
                ps.setObject(2, 1000);
                int n = ps.executeUpdate();
                System.out.println(n);
            }
        }
        // 获取连接:
    }

    public static void deleteItem() throws Exception {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE  FROM students  WHERE id=?")) {
                ps.setObject(1, 999);
                int n = ps.executeUpdate();
                System.out.println(n);
            }
        }
        // 获取连接:
    }
}
