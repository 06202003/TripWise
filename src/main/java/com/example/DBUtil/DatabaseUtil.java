package com.example.DBUtil;
import java.sql.*;
public class DatabaseUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/trip_wise?serverTimezone=UTC";
    private static final String DB_USER = "User";
    private static final String DB_PASS = "david20juni2003";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
