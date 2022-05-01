package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Brand;
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
    private void insert_random_brand(){
        Brand a = new Brand("22222siiiii","somethings22i22iiii","somethings2222iiiiicc ");
        a.setNotes("222siiiii");
        long id= dbHandler.addBrand(a);
        System.out.println(
                String.format("%s,%s, added with id= %d",a.getBrand_id(),a.getBrand_name(),id)
        );
    }

}