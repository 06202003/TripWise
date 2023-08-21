package com.example.DAO;

import com.example.DBUtil.DatabaseUtil;
import com.example.model.Airplane;
import com.example.model.AirplaneRoute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO {

    @Override
    public void addRoute(AirplaneRoute airplaneRoute) {
        // Implement the logic to add a route to the database
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO airplane_route (source_airport, destination_airport) VALUES (?, ?)")) {

            statement.setString(1, airplaneRoute.getSourceAirport());
            statement.setString(2, airplaneRoute.getDestinationAirport());

            statement.executeUpdate();

            // Insert airplanes associated with this route
            List<Airplane> airplanes = airplaneRoute.getAvailableAirplanes();
            for (Airplane airplane : airplanes) {
                insertAirplane(connection, airplaneRoute.getSourceAirport(), airplaneRoute.getDestinationAirport(), airplane);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AirplaneRoute> searchRoutes(String source, String destination) {
        // Implement the logic to search routes in the database
        List<AirplaneRoute> matchingRoutes = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM airplane_route WHERE source_airport = ? AND destination_airport = ?")) {

            statement.setString(1, source);
            statement.setString(2, destination);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AirplaneRoute airplaneRoute = new AirplaneRoute(resultSet.getString("source_airport"), resultSet.getString("destination_airport"));
                airplaneRoute.setAvailableAirplanes(getAirplanesForRoute(connection, source, destination));
                matchingRoutes.add(airplaneRoute);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchingRoutes;
    }

    private void insertAirplane(Connection connection, String source, String destination, Airplane airplane) throws SQLException {
        // Implement the logic to insert an airplane into the database
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO airplane (name, origin_time, departure_time, ticket_price, airplane_class) VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, airplane.getAirplaneName());
            statement.setTime(2, Time.valueOf(airplane.getOriginTime()));
            statement.setTime(3, Time.valueOf(airplane.getDepartureTime()));
            statement.setString(4, airplane.getTicketPrice());
            statement.setString(5, airplane.getAirplaneClass());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Airplane> getAirplanesForRoute(Connection connection, String source, String destination) throws SQLException {
        // Implement the logic to retrieve airplanes for a route from the database
        List<Airplane> airplanes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM airplane_route ar JOIN airplaneroute_airplane ac ON ar.route_id = ac.route_id JOIN airplane a ON ac.airplane_id = a.airplane_id WHERE ar.source_airport = ? AND ar.destination_airport = ?;")) {

            statement.setString(1, source);
            statement.setString(2, destination);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Airplane airplane = new Airplane(
                        resultSet.getString("name"),
                        resultSet.getTime("origin_time").toLocalTime(),
                        resultSet.getTime("departure_time").toLocalTime(),
                        resultSet.getString("ticket_price"),
                        resultSet.getString("airplane_class")
                );
                airplanes.add(airplane);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplanes;
    }

    @Override
    public List<String> getAllOrigins() {
        List<String> origins = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT source_airport FROM airplane_route")) {

            while (resultSet.next()) {
                origins.add(resultSet.getString("source_airport"));
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
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT destination_airport FROM airplane_route")) {

            while (resultSet.next()) {
                destinations.add(resultSet.getString("destination_airport"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinations;
    }
}
