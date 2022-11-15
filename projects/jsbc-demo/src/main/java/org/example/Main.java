package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // JDBC 链接的URL，不同数据库有不同的格式：
    static String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
    static String JDBC_USER = "root";
    static String JDBC_PASSWORD = "password";

    static DataSource ds;

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

    public Connection openConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        return conn;
    }

    public void insert() throws SQLException {
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

    public void update() throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE  students SET name=? WHERE  id=?")) {
                ps.setObject(1, "Bobxxx");
                ps.setObject(2, 1);
                int n = ps.executeUpdate();
            }
        }
    }

    public void business() throws SQLException {
        Connection conn = openConnection();
        try {
            // 关闭自动提交
            conn.setAutoCommit(false);
            insert();
            update();
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }

    }

    public static void main(String[] args) throws SQLException {
        Main mObj = new Main();
        mObj.query();
//        mObj.update();
//        mObj.business();
        mObj.testDataSource();
        mObj.query();

    }

    public DataSource getDataSource() {
        if (ds != null) {
            return ds;

        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(JDBC_USER);
        config.setPassword(JDBC_PASSWORD);
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
        Main.ds = new HikariDataSource(config);
        return Main.ds;
    }
    public void testDataSource() throws SQLException {
        DataSource ds = getDataSource();
        try (Connection conn = ds.getConnection();) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE  students SET name=? WHERE  id=?")) {
                ps.setObject(1, "Bobxxx");
                ps.setObject(2, 2);
                int n = ps.executeUpdate();
            }
        }
    }
}
