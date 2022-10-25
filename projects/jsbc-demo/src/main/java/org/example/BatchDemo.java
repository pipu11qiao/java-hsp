package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BatchDemo {
    static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        Student s1 = new Student("aa", 1, 6, 60);
        System.out.println(s1.name);
        batch();
        FindDemo.find();
        System.out.println("Hello world!");
    }

    public static List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        for (int i = 60; i < 100; i++) {
            list.add(new Student("aa" + i, 1, 6, i));
        }
        return list;
    }


    public static void batch() throws Exception {
        List<Student> students = getStudents();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                // 对同一个PreparedStatement反复设置参数并调用addBatch():
                for (Student s : students) {
                    ps.setString(1, s.name);
                    ps.setInt(2, s.gender);
                    ps.setInt(3, s.grade);
                    ps.setInt(4, s.score);
                    ps.addBatch(); // 添加到batch
                }
                // 执行batch:
                int[] ns = ps.executeBatch();
                for (int n : ns) {
                    System.out.println(n + " inserted."); // batch中每个SQL执行的结果数量
                }
            }        }
        // 获取连接:
    }

}
