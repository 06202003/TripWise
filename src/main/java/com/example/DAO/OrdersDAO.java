package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
    public List<Orders> getOrdersByUserId(int userId) {
        List<Orders> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(extractOrderFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve orders by user from the database.");
            e.printStackTrace();
        }
        return orders;
    }

    private Orders extractOrderFromResultSet(ResultSet rs) throws SQLException {
        Orders orders = new Orders();
        orders.setId(rs.getInt("id"));
        orders.setUser_id(rs.getInt("user_id"));
        orders.setHotel_id(rs.getInt("hotel_id"));
        orders.setCity_id(rs.getInt("city_id"));

        // Check if the date is null before converting
        Date checkInDate = rs.getDate("check_in_date");
        if (checkInDate != null) {
            orders.setCheck_in_date(Date.valueOf(checkInDate.toLocalDate()));
        }

        // Check if the date is null before converting
        Date checkOutDate = rs.getDate("check_out_date");
        if (checkOutDate != null) {
            orders.setCheck_out_date(Date.valueOf(checkOutDate.toLocalDate()));
        }

        return orders;
    }

    public void renumberOrderIDs() {
        String createTempTableSQL = "CREATE TEMPORARY TABLE temp_orders AS SELECT * FROM orders ORDER BY id;";
        String updateIDsSQL = "SET @new_id = 0;";
        String updateTempTableSQL = "UPDATE temp_orders SET id = (@new_id:=@new_id + 1);";
        String truncateOrdersSQL = "TRUNCATE orders;";
        String insertBackSQL = "INSERT INTO orders SELECT * FROM temp_orders;";
        String dropTempTableSQL = "DROP TEMPORARY TABLE temp_orders;";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {

            conn.setAutoCommit(false); // Start transaction

            stmt.executeUpdate(createTempTableSQL);
            stmt.executeUpdate(updateIDsSQL);
            stmt.executeUpdate(updateTempTableSQL);
            stmt.executeUpdate(truncateOrdersSQL);
            stmt.executeUpdate(insertBackSQL);
            stmt.executeUpdate(dropTempTableSQL);

            conn.commit(); // Commit transaction

        } catch (SQLException e) {
            System.err.println("Failed to renumber order IDs in the database.");
            e.printStackTrace();
        }
    }



}
