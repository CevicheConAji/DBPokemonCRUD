package org.example;

import org.example.Controller.ControllerDB;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        ControllerDB controllerDB = new ControllerDB();
        connection(controllerDB);
        getPokeTypeSet(9,controllerDB);
        insertarPokemon(controllerDB);
        modificarPokemon(controllerDB);
        borrarPokemon(controllerDB);
        closeDB(controllerDB);
    }
    private static void connection(ControllerDB controllerDB) {
        controllerDB.connectDB();
    }
    private static void closeDB(ControllerDB controllerDB) {
        controllerDB.closeDB();
    }
    private static void getPokeTypeSet(int id,ControllerDB controllerDB){
        ResultSet rs = controllerDB.getconsulta("SELECT \n" +
                "    p.IDpoke,\n" +
                "    p.pokename,\n" +
                "    t.typename, \n" +
                "    m.movename \n" +
                "FROM \n" +
                "    pokemon p\n" +
                "INNER JOIN `poke-type` pt ON p.IDpoke = pt.IDpoke\n" +
                "INNER JOIN `type` t ON pt.IDtype = t.IDtype\n" +
                "INNER JOIN `learnsets` ls ON p.IDpoke = ls.IDpoke\n" +
                "INNER JOIN `moves` m ON ls.IDmove = m.IDmove\n" +
                "where p.IDpoke = " + id);
        controllerDB.showPokeTypeSet(rs);
    }

    private static void insertarPokemon(ControllerDB controllerDB) {
        controllerDB.insert("INSERT INTO " +
                "pokemon(IDpoke,pokename,HP,attack,defense,spattack,spdefense,speed,dualtype)" +
                " value(1,'Tyranitar',90,124,110,95,100,61,1);");
    }

    private static void borrarPokemon(ControllerDB controllerDB) {
        controllerDB.insert("DELETE FROM `pokemon` WHERE IDpoke = 1");
    }

    private static void modificarPokemon(ControllerDB controllerDB) {
        controllerDB.insert("UPDATE `pokemon`\n" +
                "SET `HP` = 100, `attack` = 134\n" +
                "WHERE `IDpoke` = 1 ");
    }

}