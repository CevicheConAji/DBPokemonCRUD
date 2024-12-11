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
                String pokeType = rs.getString("pokename");
                System.out.printf("%-10s\n",pokeType);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
