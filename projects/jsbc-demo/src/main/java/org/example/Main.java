package org.example;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // JDBC 链接的URL，不同数据库有不同的格式：
    String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    String JDBC_USER = "root";
    String JDBC_PASSWORD = "password";

    public void query() throws SQLException {
        List<String> list = new ArrayList<>();
        // 获取链接：
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id,grade,name,gender,score FROM  students")) {
//                ps.setObject(1, 1);
//                ps.setObject(2, 3);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        int score = rs.getInt(5);
                        String str = "\nid: " + id + ",grade: " + grade + ",name: " + name + ",gender: " + gender + ",score: " + score;
                        list.add(str);
                    }
                    System.out.println(list);
                }

            }
        }
    }

    public void update() throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (grade,name,gender,score) VALUES (?,?,?,?)")) {
                ps.setObject(1, 3);
                ps.setObject(2, "学习");
                ps.setObject(3, 1);
                ps.setObject(4, 96);
                int n = ps.executeUpdate();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Main mObj = new Main();
        mObj.query();
        mObj.update();
        mObj.query();

    }
}
