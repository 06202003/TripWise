package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Hotel;
import com.example.model.modelEnum.StatusHotelEnum;
import com.example.model.modelEnum.YesNoEnum;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                hotels.add(extractHotelFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve hotels from the database.");
            e.printStackTrace();
        }
        return hotels;
    }

    public void displayAllHotelsToConsole() {
        List<Hotel> hotels = getAllHotels();
        for (Hotel hotel : hotels) {
            displayHotel(hotel);
        }
    }

    public List<Hotel> getHotelsByCity(int cityId) {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel WHERE city_id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cityId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    hotels.add(extractHotelFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve hotels by city from the database.");
            e.printStackTrace();
        }
        return hotels;
    }

    private Hotel extractHotelFromResultSet(ResultSet rs) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setHotelName(rs.getString("hotelName"));
        hotel.setCityId(rs.getInt("city_id"));
        hotel.setTipeRoom(rs.getString("tipeRoom"));
        hotel.setReturnTicket(YesNoEnum.fromValue(rs.getString("returnTicket")));
        hotel.setMaxCapacity(rs.getInt("maxCapacity"));
        hotel.setPrice(rs.getBigDecimal("price"));
        hotel.setLocation(rs.getString("location"));
        hotel.setStatus(StatusHotelEnum.fromValue(rs.getString("status")));
        hotel.setRemainingRoom(rs.getInt("remainingRoom"));
        return hotel;
    }

    private void displayHotel(Hotel hotel) {
        System.out.println("Nama Hotel : " + hotel.getHotelName());
        System.out.println("Kota : " + hotel.getCityId());
        System.out.println("Tipe Kamar: " + hotel.getTipeRoom());
        System.out.println("Tiket Kembali: " + hotel.getReturnTicket());
        System.out.println("Kapasitas Maksimal: " + hotel.getMaxCapacity());
        System.out.println("Harga : " + hotel.getPrice());
        System.out.println("status : " + hotel.getStatus());
        System.out.println("Kamar Yang Tersedia : " + hotel.getRemainingRoom());
        System.out.println("------------------------------------------------");
    }



}
