package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Hotel;
import com.example.model.User;
import javafx.scene.text.Text;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birthDate"),
                        rs.getString("address"),
                        rs.getString("phoneNumber"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("nik"),
                        rs.getString("email"),
                        rs.getString("profilePicture")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void displayAllUsersToConsole() {
        List<User> users = getAllUsers();

        for (User user : users) {
            System.out.println("id : " + user.getId());
            System.out.println("Nama : " + user.getName());
            System.out.println("Birth : " + user.getBirthDate());
            System.out.println("address : " + user.getAddress());
            System.out.println("phoneNumber : " + user.getPhoneNumber());
            System.out.println("username : " + user.getUsername());
            System.out.println("password : " + user.getPassword());
            System.out.println("nik : " + user.getNik());
            System.out.println("email : " + user.getEmail());
        }
    }

    public boolean updateUser(User user) {
        String query = "UPDATE user SET name=?, birthDate=?, address=?, phoneNumber=?, password=?, username=?, nik=?, email=?, profilePicture=? WHERE id=?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setDate(2, user.getBirthDate());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getUsername());
            stmt.setString(7, user.getNik());
            stmt.setString(8, user.getEmail());
            stmt.setString(9, user.getProfilePicture());
            stmt.setInt(10, user.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User authenticateUser(String username, String password) {
        User user = null;

        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Integer userId = resultSet.getInt("id");
                    String userFullName = resultSet.getString("name");
                    Date userBirthDate = resultSet.getDate("birthDate");
                    String userAddress = resultSet.getString("address");
                    String userPhoneNum = resultSet.getString("phoneNumber");
                    String userUsername = resultSet.getString("username");
                    String userPassword = resultSet.getString("password");
                    String userNik = resultSet.getString("nik");
                    String userEmail = resultSet.getString("email");
                    String userProfilePic = resultSet.getString("profilePicture");

                    user = new User(userId, userFullName, userBirthDate, userAddress, userPhoneNum, userUsername, userPassword, userNik, userEmail, userProfilePic);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
