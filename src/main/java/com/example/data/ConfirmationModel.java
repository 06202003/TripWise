package com.example.data;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationModel {
    private static List<ArrayList<ConfirmationData>> confirmedHotelsList = new ArrayList<>();

    public static List<ArrayList<ConfirmationData>> getConfirmedHotelsList() {
        return confirmedHotelsList;
    }

    public static void addConfirmedHotel(ArrayList<ConfirmationData> hotelData) {
        confirmedHotelsList.add(hotelData);
    }
}
