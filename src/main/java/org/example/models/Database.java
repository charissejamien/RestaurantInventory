package org.example.models;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String url = "jdbc:sqlite:detabeso.db"; // Database URL

    public static void main(String[] args) {
        createTable();
        createMealsTable();

    }

    //Create Users Table
    public static void createTable() {
        String usersSql = "CREATE TABLE IF NOT EXISTS users (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userName TEXT NOT NULL, " +
                "passWord TEXT NOT NULL," +
                "roles TEXT NOT NULL);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(usersSql);
                System.out.println("User table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Create Meals Table
    public static void createMealsTable() {
        String mealsSql= "CREATE TABLE IF NOT EXISTS meals (" +
                "mealId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "mealName TEXT, " +
                "description TEXT, " +
                "category TEXT, " +
                "dietType TEXT, " +
                "spice TEXT, " +
                "calories INTEGER);";

        try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(mealsSql);
                System.out.println("Meals table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Insert meals to meals table
    public static void addMeals(String mealName, String description, String category, String dietType, String spice, int calories) {
        String insertMeals = "INSERT INTO meals (mealName, description, category, dietType, spice, calories) VALUES (?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertMeals)) {
            preparedStatement.setString(1, mealName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setString(4, dietType);
            preparedStatement.setString(5, spice);
            preparedStatement.setInt(6, calories);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Retrieve meals from the meals table
    public static List<String[]> getMeals() {
        List<String[]> menu = new ArrayList<>();
        String selectMeals = "SELECT mealName, description FROM meals"; // Adjust SQL query

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectMeals);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                String description = resultSet.getString("description");
                menu.add(new String[]{mealName, description}); // Add meal name and description as an array
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menu;
    }



    public static void registerUser(String userName, String passWord, String roles) {
        String insertSql = "INSERT INTO users (userName, passWord, roles) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            preparedStatement.setString(3, roles);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public static boolean authenticateUser(String userName, String passWord) {
        String selectSql = "SELECT * FROM users WHERE userName = ? AND passWord = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
}
