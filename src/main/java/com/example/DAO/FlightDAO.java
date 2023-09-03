package com.example.DAO;

import com.example.model.AirplaneRoute;
import java.util.List;

public interface FlightDAO {
    void addRoute(AirplaneRoute airplaneRoute);
    List<AirplaneRoute> searchRoutes(String source, String destination);
    List<String> getAllOrigins();
    List<String> getAllDestinations();
}
