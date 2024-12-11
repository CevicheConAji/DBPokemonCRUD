package org.example.DB;
import java.sql.Connection;

public class ConnectDB {
    private String db;
    private String port;
    private String jdbc;
    private String user;
    private String password;
    private Connection connection;

    public ConnectDB() {
        this.db = "pokemon";
        this.port = "3306";
        this.jdbc = "jdbc:mysql://localhost:"+port+"/"+db;
        this.user = "root";
        this.password = "root";
        this.connection = null;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getJdbc() {
        return jdbc;
    }

    public void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
