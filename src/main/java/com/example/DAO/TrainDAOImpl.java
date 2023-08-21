package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Train;
import com.example.model.TrainRoute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainDAOImpl implements TrainDAO {
    @Override
    public List<TrainRoute> getAllTrainRoutes() {
        List<TrainRoute> trainRoutes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM train_route");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int trainRouteId = resultSet.getInt("train_route_id");
                String sourceStation = resultSet.getString("source_station");
                String destinationStation = resultSet.getString("destination_station");

                List<Train> availableTrains = getTrainsForRoute(sourceStation, destinationStation);

                TrainRoute trainRoute = new TrainRoute(trainRouteId, sourceStation, destinationStation, availableTrains);

                trainRoutes.add(trainRoute);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainRoutes;
    }

    @Override
    public List<Train> getTrainsForRoute(String source, String destination) {
        List<Train> trains = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT t.train_id, name, departure_time, origin_time, ticket_price, train_class " +
                     "FROM train t " +
                     "JOIN trainroute_train tt ON t.train_id = tt.train_id " +
                     "JOIN train_route tr ON tt.route_id = tr.route_id " +
                     "WHERE tr.source_station = ? AND tr.destination_station = ?")) {

            statement.setString(1, source);
            statement.setString(2, destination);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String trainId = resultSet.getString("train_id");
                String trainName = resultSet.getString("name");
                String departureTime = resultSet.getString("departure_time");
                String originTime = resultSet.getString("origin_time");
                String ticketPrice = resultSet.getString("ticket_price");
                String trainClass = resultSet.getString("train_class");
                Train train = new Train(trainId, trainName, departureTime, originTime, ticketPrice, trainClass);
                trains.add(train);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trains;
    }

    @Override
    public void bookTrainTicket(TrainRoute trainRoute, Train train) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO booked_train_ticket (route_id, train_id) VALUES (?, ?)")) {

            statement.setInt(1, trainRoute.getTrainRouteId());
            statement.setString(2, train.getTrainId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAllOrigins() {
        List<String> origins = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT source_station FROM train_route");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String origin = resultSet.getString("source_station");
                origins.add(origin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return origins;
    }

    @Override
    public List<String> getAllDestinations() {
        List<String> destinations = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT destination_station FROM train_route");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String destination = resultSet.getString("destination_station");
                destinations.add(destination);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinations;
    }

    @Override
    public List<TrainRoute> searchRoutes(String source, String destination) {
        List<TrainRoute> matchingTrainRoutes = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM train_route WHERE source_station = ? AND destination_station = ?")) {

            statement.setString(1, source);
            statement.setString(2, destination);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int routeId = resultSet.getInt("route_id");
                String srcStation = resultSet.getString("source_station");
                String destStation = resultSet.getString("destination_station");

                List<Train> availableTrains = getTrainsForRoute(srcStation, destStation);

                TrainRoute trainRoute = new TrainRoute(routeId, srcStation, destStation, availableTrains);

                matchingTrainRoutes.add(trainRoute);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchingTrainRoutes;
    }
}
