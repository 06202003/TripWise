package com.example.DBUtil;
import java.sql.*;
public class DatabaseUtil {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/trip_wise?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "user";
    private static final String DB_PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
