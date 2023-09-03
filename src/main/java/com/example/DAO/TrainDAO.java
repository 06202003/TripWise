package com.example.DAO;

import com.example.model.Train;
import com.example.model.TrainRoute;

import java.util.List;

public interface TrainDAO {
    List<TrainRoute> getAllTrainRoutes();
    List<Train> getTrainsForRoute(String source, String destination);
    void bookTrainTicket(TrainRoute trainRoute, Train train);
    List<String> getAllOrigins();
    List<String> getAllDestinations();
    List<TrainRoute> searchRoutes(String source, String destination);
}
