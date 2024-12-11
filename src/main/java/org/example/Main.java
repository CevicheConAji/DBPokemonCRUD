package org.example;

import org.example.Controller.ControllerDB;

import java.sql.Connection;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        ControllerDB controllerDB = new ControllerDB();
        connection(controllerDB);
        getPokeTypeSet(9,controllerDB);
        closeDB(controllerDB);
    }
    private static void connection(ControllerDB controllerDB) {
        controllerDB.connectDB();
    }
    private static void closeDB(ControllerDB controllerDB) {
        controllerDB.closeDB();
    }
    private static void getPokeTypeSet(int id,ControllerDB controllerDB){
        ResultSet rs = controllerDB.getconsulta("SELECT * FROM pokemon WHERE IDpoke = 9");
        controllerDB.showPokeTypeSet(rs);
    }

}