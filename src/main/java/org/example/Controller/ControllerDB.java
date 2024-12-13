package org.example.Controller;

import org.example.DB.ConnectDB;

import java.sql.*;

public class ControllerDB {
    private final ConnectDB connectDB = new ConnectDB();
    private Connection connection = connectDB.getConnection();

    public Connection connectDB() {
        try{
            connection = DriverManager.getConnection(connectDB.getJdbc(), connectDB.getUser(), connectDB.getPassword());
            System.out.println("Connected to database");
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return connection;
    }
    public void closeDB() {
        try{
            connection.close();
            System.out.println("Disconnected from database");

        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public ResultSet getconsulta(String query){
        Statement statement;
        ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
        return resultSet;
    }
    public void showPokeTypeSet(ResultSet rs){

        try{
            while (rs.next()){
                String idPoke = rs.getString("IDpoke");
                String pokeType = rs.getString("pokename");
                String typename = rs.getString("typename");
                String movename = rs.getString("movename");
                System.out.printf("%-10s %-10s %-10s %-10s\n", idPoke, pokeType, typename, movename);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void insert(String query) {
        int count;
        Statement statement;
        try {
            statement = connection.createStatement();
            count = statement.executeUpdate(query);
            System.out.println("Updated " + count + " rows");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
