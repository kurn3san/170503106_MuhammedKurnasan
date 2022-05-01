package com.example.demo.database;

import com.example.demo.model.Brand;
import com.example.demo.model.Car;
import com.example.demo.model.CarModel;
import com.example.demo.model.Person;

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

    public static long addCarModel(CarModel cm){
        long id =0;
        String insert = "INSERT INTO " + " db.car_models "+"(model_id, " + "brand_id, "+" model_name"+", model_date)"
                + " VALUES (?,( Select brand_id from db.brands where brands.name=? ),?,?);";
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1,cm.getModel_id());
            prpsttmnt.setString(2, cm.getBrand_name());
            prpsttmnt.setString(3, cm.getModel_name());
            prpsttmnt.setString(4,cm.getModel_date() );
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
            JOptionPane.showMessageDialog(parent, "error!");
        }
        catch (Exception e ){
            e.printStackTrace();
        }

        return id;
    }

      public static long addCar(Car car){
        long id=0;

        String insert = "INSERT INTO " + " db.cars "+"(car_id, " + " model_id,"+" price, "+" delivery_date, "+" car_notes)"
                + " VALUES (?,( Select model_id from db.car_models where model_name=? and brand_id=" +
                "(SELECT brand_id from db.brands where brands.name=?) ),?,?,?);";
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1, car.getCar_id());
            prpsttmnt.setString(2, car.getModel_name());
            prpsttmnt.setString(3, car.getBrand_name());
            prpsttmnt.setInt(4,car.getPrice());
            prpsttmnt.setString(5,car.getDelivery_date());
            prpsttmnt.setString(6,car.getCar_notes());
            prpsttmnt.toString();
            prpsttmnt.executeUpdate();
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
            JOptionPane.showMessageDialog(parent, "error!");
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return id;

    }
    public static long addPerson(Person p){
        long id=0;

        String insert = "INSERT INTO " + " db.people "
                + " VALUES (?,?,?,?,?,?,?,?);";
        /*
        * +"(person_id "
                +" ,name "+", lastname, "+" address, "
                +" birth, "
                +" tel_no, "
                +" email, "
                +" notes)"
                *
                * */
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1, p.getId_no());
            prpsttmnt.setString(2, p.getName());
            prpsttmnt.setString(3, p.getLasname());
            prpsttmnt.setString(4,p.getAddress());
            prpsttmnt.setString(5,p.getBirth());
            prpsttmnt.setString(6,p.getTel_no());
            prpsttmnt.setString(7,p.getEmail());
            prpsttmnt.setString(8, p.getNotes());
            prpsttmnt.toString();
            prpsttmnt.executeUpdate();
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
            JOptionPane.showMessageDialog(parent, "error!");
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return id;

    }



}
