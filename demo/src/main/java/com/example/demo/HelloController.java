package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Brand;
import com.example.demo.model.Car;
import com.example.demo.model.CarModel;
import com.example.demo.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void initialize(){

        connect();
    Person p=new Person("991901230","Ahmad","Aljbawy",
            "Aleppo", "19-10-1999","0933581706",
            "malk@laksd.com","nonotes");
    dbHandler.addPerson(p);




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
        CarModel c = new CarModel("toyota","1toyota_cruz","cruz","2014");
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

}