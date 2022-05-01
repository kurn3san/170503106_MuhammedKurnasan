package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Sign_in_controller {
    @FXML
    private TextField signInEmailTextField;
    @FXML
    private PasswordField signInPasswordField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSignInButtonClick(){

        String email=signInEmailTextField.getText();
        String password=signInPasswordField.getText();
        System.out.println(email+password);
        Person p=new Person("2304","alj","SADF","SDFA",
                "123","SAFSADF",email,"notes");
        User u=new User(p,"",password);
        //dbHandler.getUser(u);
        System.out.println(dbHandler.getUser(u));

    }

    @FXML
    private void initialize(){

        connect();



    }


    private void connect(){

        try {
            dbHandler.connect();
            System.out.println("connected!");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            ;
        }
    }
    private void insert_new_brand(){
        Brand a = new Brand("22222siiiii","somethings22i22iiii","somethings2222iiiiicc ");
        a.setNotes("222siiiii");
        long id= dbHandler.addBrand(a);
        System.out.println(
                String.format("%s,%s, added with id= %d",a.getBrand_id(),a.getBrand_name(),id)
        );
    }
    private void insert_new_CarModel_for_existing_brand(){
        CarModel c = new CarModel("somethings22i22iiii","1toyota_cruz","cruz","2014");
        long id =dbHandler.addCarModel(c);
        System.out.println(
                String.format("%s added with id= %d",c.getModel_name(),id)
        );
    }
    private void insert_car(){
        Car sonata2=new Car("something",
                "sonata","id0000",
                96000,"20-03-2009","none");
        dbHandler.addCar(sonata2);
    }
    private void insert_person(){
        Person p=new Person("991901230","Ahmad","Aljbawy",
                "Aleppo", "19-10-1999","0933581706",
                "malk@laksd.com","nonotes");
        dbHandler.addPerson(p);
    }
    private void insert_user1(){
        Person alj=new Person("991901230","Ahmad","Aljbawy","Aleppo","19-10-1999","safdsaf","lsk;dfa","kl");
        User u=new User(alj,"00001","pas");
        dbHandler.addUser(u);
    }
    private void insert_user2(){
        Person alj=new Person("99","a","Aljbawy","Aleppo","19-10-1999","safdsaf","lsk;dfa","kl");
        User u=new User(alj,"00002","pas");
        dbHandler.addUser(u);
    }
    private void insert_salesman(){
        Person alj=new Person("99","a","Aljbawy","Aleppo","19-10-1999","safdsaf","lsk;dfa","kl");
        Salesman s=new Salesman(alj,"00002","pass");
        s.setSeniority(3);
        dbHandler.addSalesman(s);
    }


}