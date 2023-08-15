package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.City;
import com.example.model.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    public List<City> getAllCitys() {
        List<City> citys = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM city")) {

            while (rs.next()) {
                City city = new City();
                city.setId(rs.getInt("id"));
                city.setCityName(rs.getString("cityName"));
                city.setCountryName(rs.getString("countryName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citys;
    }

    public void displayAllHotelsToConsole() {
        List<City> citys = getAllCitys();  // memanggil metode yang sudah ada

        for (City city : citys) {
            System.out.println("id : " + city.getId());
            System.out.println("Nama Kota : " + city.getCityName());
            System.out.println("Nama Negara : " + city.getCountryName());
        }
    }
}
