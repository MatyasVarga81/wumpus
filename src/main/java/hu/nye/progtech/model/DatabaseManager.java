package hu.nye.progtech.model;

import java.sql.*;

public class DatabaseManager {
    private static final String DATABASE_URL = "jdbc:sqlite:wumpus.db";

    public void saveToDatabase(String serializedGameData) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "INSERT INTO saved_games (game_data) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, serializedGameData);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String loadFromDatabase() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            String query = "SELECT game_data FROM saved_games ORDER BY id DESC LIMIT 1";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("game_data");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}