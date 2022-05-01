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
    public static long addBrand(Brand brand) {
        String insert = "INSERT INTO " + " db.brands "+"(brand_id, name, address, notes)"
                + " VALUES (?,?,?,?);";
        long id=0;
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1,brand.getBrand_id());
            prpsttmnt.setString(2, brand.getBrand_name());
            prpsttmnt.setString(3, brand.getAddress());
            prpsttmnt.setString(4, brand.getNotes());
            prpsttmnt.toString();
            int affected_raws =prpsttmnt.executeUpdate();
            try (ResultSet rs = prpsttmnt.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getLong(1);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "this brand is already registered");
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return id;
    }


}
