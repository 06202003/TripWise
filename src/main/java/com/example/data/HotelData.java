package com.example.data;

import com.example.model.Hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelData {
    private Map<String, List<Hotel>> cityToHotelsMap;

    public HotelData() {
        cityToHotelsMap = new HashMap<>();

        // Inisialisasi data hotel untuk Kota A
        List<Hotel> hotelsForKotaA = new ArrayList<>();
        hotelsForKotaA.add(new Hotel("Fulmar","Bakjer indah 1", "2023-08-10", "2023-08-15", "Standard", "Yes", "1", "Rp. 1.000.000"));
        hotelsForKotaA.add(new Hotel("BlueBird Inn","Jl. Pelangi 45", "2023-08-11", "2023-08-16", "Deluxe", "No", "2", "Rp. 1.100.000"));
        hotelsForKotaA.add(new Hotel("SunnyStay","Jl. Mentari 10", "2023-08-12", "2023-08-17", "Suite", "Yes", "3", "Rp. 3.000.000"));
        hotelsForKotaA.add(new Hotel("Moonlit Suites","Jl. Bintang Malam 23", "2023-08-13", "2023-08-18", "Deluxe", "No", "2", "Rp. 1.000.000"));
        hotelsForKotaA.add(new Hotel("OceanView Resort","Jl. Pantai Indah 5", "2023-08-14", "2023-08-19", "Standard", "Yes", "1", "Rp. 2.000.000"));
        cityToHotelsMap.put("Kota A", hotelsForKotaA);

        // Inisialisasi data hotel untuk Kota B
        List<Hotel> hotelsForKotaB = new ArrayList<>();
        hotelsForKotaB.add(new Hotel("b","Bakjer indah 1", "2023-08-10", "2023-08-15", "Standard", "Yes", "1", "Rp. 100.000"));
        hotelsForKotaB.add(new Hotel("b Inn","Jl. Pelangi 45", "2023-08-11", "2023-08-16", "Deluxe", "No", "2", "Rp. 200.000"));
        hotelsForKotaB.add(new Hotel("b","Jl. Mentari 10", "2023-08-12", "2023-08-17", "Suite", "Yes", "3", "Rp. 1.000.000"));
        hotelsForKotaB.add(new Hotel("b Suites","Jl. Bintang Malam 23", "2023-08-13", "2023-08-18", "Deluxe", "No", "2", "Rp. 300.000"));
        hotelsForKotaB.add(new Hotel("b Resort","Jl. Pantai Indah 5", "2023-08-14", "2023-08-19", "Standard", "Yes", "1", "Rp. 500.000"));
        cityToHotelsMap.put("Kota B", hotelsForKotaB);

        // Inisialisasi data hotel untuk Kota C
        List<Hotel> hotelsForKotaC = new ArrayList<>();
        hotelsForKotaC.add(new Hotel("c","Bakjer indah 1", "2023-08-10", "2023-08-15", "Standard", "Yes", "1", "Rp. 1.700.000"));
        hotelsForKotaC.add(new Hotel("c Inn","Jl. Pelangi 45", "2023-08-11", "2023-08-16", "Deluxe", "No", "2", "Rp. 1.800.000"));
        hotelsForKotaC.add(new Hotel("c","Jl. Mentari 10", "2023-08-12", "2023-08-17", "Suite", "Yes", "3", "Rp. 100.000"));
        hotelsForKotaC.add(new Hotel("c Suites","Jl. Bintang Malam 23", "2023-08-13", "2023-08-18", "Deluxe", "No", "2", "Rp. 200.000"));
        hotelsForKotaC.add(new Hotel("c Resort","Jl. Pantai Indah 5", "2023-08-14", "2023-08-19", "Standard", "Yes", "1", "Rp. 400.000"));
        cityToHotelsMap.put("Kota C", hotelsForKotaC);
    }

    public List<Hotel> getHotelsByCity(String city) {
        return cityToHotelsMap.get(city);
    }
}
