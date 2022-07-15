package com.example.demo.database;

import com.example.demo.model.*;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;


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
    public static boolean isThereSuchABrand(Brand b){
        return getBrand(b)!=null;

    }
    public static ResultSet getAllBrands(){
        ResultSet resultSet = null;
        String query = "SELECT * FROM " + " db.brands ";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public static boolean isThereSuchACarModel(CarModel cr){
        return getCarModel(cr)!=null;

    }
    public static ResultSet getAllCarModels(CarModel cr){
        ResultSet resultSet = null;

        if (!cr.getBrand_id().equals("")&&!cr.getModel_id().equals("")) {
            String query = "SELECT * FROM " + " db.car_models ";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultSet;
    }
    public static CarModel getCarModel(CarModel cr){
        ResultSet resultSet = null;

        if (!cr.getBrand_id().equals("")&&!cr.getModel_id().equals("")) {
            String query = "SELECT * FROM " + " db.car_models "+ " WHERE "
                    + "model_id=? and brand_id=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, cr.getModel_id());
                preparedStatement.setString(2,cr.getBrand_id());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int counter = 0;
        try {
            CarModel cm=cr;
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) cm.setModel_id(columnValue);
                    if(i==2) cm.setBrand_id(columnValue);
                    if(i==3) cm.setModel_name(columnValue);
                    if(i==4) cm.setModel_date(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }
            if (counter==1)return cm;
            else return null;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }
    }
    public static Brand getBrand(Brand b){

        ResultSet resultSet = null;

        if (!b.getBrand_id().equals("")) {
            String query = "SELECT * FROM " + " db.brands "+ " WHERE "
                    + "brand_id=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, b.getBrand_id());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int counter = 0;
        try {
            Brand brand=b;
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) brand.setBrand_id(columnValue);
                    if(i==2) brand.setBrand_name(columnValue);
                    if(i==3) brand.setAddress(columnValue);
                    if(i==4) brand.setNotes(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }
            if (counter==1)return brand;
            else return null;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }

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

    ///////
    public static long addUser(User u){
        long id =0;
        String insert = "INSERT INTO " + " db.users "+"(user_id, " + "person_id, "+" password_hash)"
                + " VALUES (?,( Select person_id from db.people where people.person_id=? and people.name=?),?);";
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1,u.getUser_id() );
            prpsttmnt.setString(2,u.getId_no() );
            prpsttmnt.setString(3, u.getName()) ;
            prpsttmnt.setString(4, u.getPassword() );
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
    /////////
    public static long addSalesman(Salesman s){
        long id =0;
        String insert = "INSERT INTO " + " db.salesmen "+"(salesman_id, " + "user_id, "+" seniority)"
                + " VALUES (?,(select user_id from db.users where person_id=( Select person_id from db.people where people.person_id=? and people.name=?)),?);";
        try {
            PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
            prpsttmnt.setString(1,s.getUser_id() );
            prpsttmnt.setString(2,s.getId_no() );
            prpsttmnt.setString(3, s.getName()) ;
            prpsttmnt.setInt(4, s.getSeniority());
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
    /////
    public static long addAdmin(Admin a){
        long id =0;
        if (!a.getUser_id().equals("")&&!a.getUser_id().equals(null)&&
                !a.getEmail().equals("") && !a.getPassword().equals("")){
            String insert = "INSERT INTO " + " db.admins "+"(admin_id, " + "user_id)"
                    + " VALUES (?,(select user_id from db.users where user_id=? and password_hash =?));";
            try {
                PreparedStatement prpsttmnt = getDbConnection().prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
                prpsttmnt.setString(1,a.getAdmin_id() );
                prpsttmnt.setString(2,a.getUser_id() );
                prpsttmnt.setString(3, a.getPassword()) ;
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
        }
        return id;
    }
    public static boolean deletePerson(Person p){
        String delete = "DELETE FROM db.people WHERE " + "( email=?" + ")";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.setString(1, p.getEmail());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteUserWithPersonInfo(User u){
      User user =getUser(u);
      String user_id=user.getUser_id();
      String email=user.getEmail();
      String delete = "DELETE FROM db.users WHERE " + "( person_id=(Select person_id from db.people where email=?)" + " )";
      try {
           PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
           preparedStatement.setString(1, u.getEmail());
           preparedStatement.executeUpdate();

           return deletePerson(new Person(email));

      } catch (SQLException e) {
            e.printStackTrace();
            return false;
      }

      //deletePerson(new Person(email));

    }
    public static boolean deleteUserWithoutPersonalInfo(User u){
        User user =getUser(u);
        String user_id=user.getUser_id();
        String email=user.getEmail();
        String delete = "DELETE FROM db.users WHERE " + "( person_id=(Select person_id from db.people where email=?)" + " )";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.setString(1, u.getEmail());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean deleteAdmin(Admin a){
        String query = "DELETE FROM " + " db.admins "+ " WHERE "
                + "user_id=(Select user_id from db.users where person_id="+
                "(Select person_id from db.people where email=?)" + "AND "
                + "users.password_hash" + "= ?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, a.getEmail());
            preparedStatement.setString(2, a.getPassword());
            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean updatePersonInfo(Person p){

        String update = "UPDATE db.people" +  " SET name=? , lastname=? , address=? ,  tel_no=?, notes=? " + " WHERE " +   "email=?";
        try {
            PreparedStatement preparedStatement = dbHandler.getDbConnection().prepareStatement(update);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setString(2, p.getLasname());
            preparedStatement.setString(3, p.getAddress());
            preparedStatement.setString(4, p.getTel_no());
            preparedStatement.setString(5, p.getNotes());
            preparedStatement.setString(6,p.getEmail());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public static Admin getAdmin(Admin a){
        ResultSet resultSet = null;

        if (!a.getEmail().equals("") && !a.getPassword().equals("")) {
            String query = "SELECT admin_id,user_id FROM " + " db.admins "+ " WHERE "
                    + "user_id=(Select user_id from db.users where person_id="+
                    "(Select person_id from db.people where email=?)" + "AND "
                    + "users.password_hash" + "= ?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, a.getEmail());
                preparedStatement.setString(2, a.getPassword());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if
        (!a.getUser_id().equals("") && !a.getUser_id().equals(null) && !a.getPassword().equals("") && !a.getPassword().equals(null)){
            String query = "SELECT admin_id,user_id FROM " + " db.admins "+ " WHERE "
                    + "user_id=(Select user_id from db.users where user_id=?"+
                    "AND "
                    + "users.password_hash" + "= ?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, a.getUser_id());
                preparedStatement.setString(2, a.getPassword());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill your correct Username and Password");
        }

        int counter = 0;
        try {
            Admin admin=a;
            admin.setEmail(a.getEmail());
            admin.setPassword(a.getPassword());
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) admin.setAdmin_id(columnValue);
                    if(i==2) admin.setUser_id(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }
            if (counter<=1)return admin;
            else return null;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }
    }
    public static int howManyAdminsAreThere(){
        int i =0;
        ResultSet rs=null;
        String query="Select * from db.admins";
        try{
            PreparedStatement ps=getDbConnection().prepareStatement(query);
            rs = ps.executeQuery();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                i++;
                System.out.println("");
            }
            return i;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }
    public static int howManyUsersAreThere(){
        int i =0;
        ResultSet rs=null;
        String query="Select * from db.users";
        try{
            PreparedStatement ps=getDbConnection().prepareStatement(query);
            rs = ps.executeQuery();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                i++;
                System.out.println("");
            }
            return i;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return i;
    }

    public static User getUser(User u) {
        ResultSet resultSet = null;

        if (!u.getEmail().equals("") && !u.getPassword().equals("")) {
            String query = "SELECT user_id,person_id FROM " + " db.users "+ " WHERE "
                    + "person_id=(Select person_id from db.people where email=?)" + "AND "
                    + "users.password_hash" + "= ?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, u.getEmail());
                preparedStatement.setString(2, u.getPassword());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill your correct Username and Password");
        }

        int counter = 0;
        try {
            User user=u;
            user.setEmail(u.getEmail());
            user.setPassword(u.getPassword());
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) user.setUser_id(columnValue);
                    if(i==2) user.setId_no(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }
            if (counter<=1)return user;
            else return null;
            /**/
            }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }


    }
    public static boolean resetUsersPasswordSearchByEmail(String eEmail){

        ResultSet resultSet = null;

        if (!eEmail.equals("") ) {
            String query = "SELECT user_id,person_id FROM " + " db.users "+ " WHERE "
                    + "person_id=(Select person_id from db.people where email=?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, eEmail);

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill your correct Username and Password");
        }

        int counter = 0;
        try {
            Person p =getPerson(new Person(eEmail));
            User user=new User(p,"pass");
            user.setEmail(eEmail);
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) user.setUser_id(columnValue);
                    if(i==2) user.setId_no(columnValue);
                    if(i==3)user.setPassword(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }

            if (counter<=1){String update = "UPDATE db.users" +  " SET password_hash='default'" + " WHERE " +   "person_id=(select person_id from db.people where email=?)";
                try {
                    PreparedStatement preparedStatement = dbHandler.getDbConnection().prepareStatement(update);
                    preparedStatement.setString(1, eEmail);
                    //preparedStatement.setString(2, eEmail);


                    preparedStatement.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
                ///
            }
            else return false;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return false;
        }




    }
    public static User getUserByEmail(String eEmail){
        ResultSet resultSet = null;

        if (!eEmail.equals("") ) {
            String query = "SELECT user_id,person_id FROM " + " db.users "+ " WHERE "
                    + "person_id=(Select person_id from db.people where email=?)";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, eEmail);

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill your correct Username and Password");
        }

        int counter = 0;
        try {
            Person p =getPerson(new Person(eEmail));
            User user=new User(p,"pass");
            user.setEmail(eEmail);
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) user.setUser_id(columnValue);
                    if(i==2) user.setId_no(columnValue);
                    if(i==3)user.setPassword(columnValue);
                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }

            if (counter<=1)return user;
            else return null;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }



    }
    public static boolean isThereSuchaPerson(Person p){
        return getPerson(p)!=null;
    }



    public static boolean isThereSuchaUserWithID(String id){
        ResultSet resultSet = null;
         if( id!=null){
            System.out.println("got here3");

            String query = "SELECT * FROM " + " db.users "+ " WHERE "
                    + "person_id=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, id);

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                System.out.println("got here4");

                e.printStackTrace();
            }
        }
        else{
            System.out.println("got here5");

            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill your correct Username and Password");
        }
        int counter = 0;
        try {
            System.out.println("got here6");
            while (resultSet.next()) {
                counter++;
                System.out.println("");
                System.out.println("got here7");

            }
            if (counter!=0){
                System.out.println("got here7");
                return true;
            }
            else {
                System.out.println("got here8");
                return false;}
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    /////
    public static Person getPerson(Person p) {
        ResultSet resultSet = null;

        if (!p.getEmail().equals("")&&!p.getEmail().equals(null)) {
            String query = "SELECT * FROM " + " db.people "+ " WHERE "
                    + "email=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, p.getEmail());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(!p.getId_no().equals("")&&!p.getId_no().equals(null)){
            String query = "SELECT * FROM " + " db.people "+ " WHERE "
                    + "person_id=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, p.getId_no());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please fill with either email or id number");
        }

        int counter = 0;
        try {
            Person person=p;
            ResultSetMetaData  rsmd=resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("col num = "+columnsNumber);

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    if(i==1) person.setId_no(columnValue);
                    if(i==2) person.setName(columnValue);
                    if(i==3) person.setLasname(columnValue);
                    if(i==4) person.setAddress(columnValue);
                    if(i==5) person.setBirth(columnValue);
                    if(i==6) person.setTel_no(columnValue);
                    if(i==7) person.setEmail(columnValue);
                    if(i==8 && !columnValue.equals(null)&&!columnValue.equals("")) person.setNotes(columnValue);

                    System.out.print(i+"  "+columnValue + ", " + rsmd.getColumnName(i));
                }
                counter++;
                System.out.println("");
            }
            if (counter==1)return person;
            else return null;
            /**/
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("error "+2);
            return null;
        }

    }


}
