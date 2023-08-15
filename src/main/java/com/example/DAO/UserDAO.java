package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Hotel;
import com.example.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
//                user.setBirthDate(rs.getDate("birthDate"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setNik(rs.getString("nik"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void displayAllUsersToConsole() {
        List<User> users = getAllUsers();  // memanggil metode yang sudah ada

        for (User user : users) {
            System.out.println("id : " + user.getId());
            System.out.println("Nama : " + user.getName());
            System.out.println("address : " + user.getAddress());
            System.out.println("phoneNumber : " + user.getPhoneNumber());
            System.out.println("username : " + user.getUsername());
            System.out.println("password : " + user.getPassword());
            System.out.println("nik : " + user.getNik());
            System.out.println("email : " + user.getEmail());
        }
    }
}
