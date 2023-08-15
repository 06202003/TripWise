package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Hotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM hotel")) {

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelName(rs.getString("hotelName"));
                hotel.setCityId(rs.getInt("city_id"));
                hotel.setTipeRoom(rs.getString("tipeRoom"));
//                hotel.setReturnTicket(YesNoEnum.valueOf(rs.getString("returnTicket")));
                hotel.setMaxCapacity(rs.getInt("maxCapacity"));
                hotel.setPrice(rs.getBigDecimal("price"));
//                hotel.setStatus(StatusHotelEnum.valueOf(rs.getString("status")));
                hotel.setRemainingRoom(rs.getInt("remainingRoom"));
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    public void displayAllHotelsToConsole() {
        List<Hotel> hotels = getAllHotels();  // memanggil metode yang sudah ada

        for (Hotel hotel : hotels) {
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
}
