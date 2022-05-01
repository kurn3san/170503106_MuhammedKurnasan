package com.example.demo.database;

import com.example.demo.model.Brand;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class dbHandler {
    protected static final String dbHost =  "localhost";
    protected static final String dbPort = "3306";
    protected static final String dbUser = "root";

    protected static final String dbPass = "123456789";
    protected static final String dbName = "db";
    private static Connection dbConnection;



    public static void connect() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
    }

    public static Connection getDbConnection() {

        return dbConnection;
    }

    // from bilal
    public static void addBrand(Brand brand) {
        String insert = "INSERT INTO " + "db.brands"+ "(brand_id"  + ", name"
                + ", adress" + ",notes" + ")"
                + "VALUES("+
                brand.getBrand_id()+
                brand.getBrand_name()+
                brand.getAddress()+
                brand.getNotes()+
                ")";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "this brand is already registered");
        }
    }


}
