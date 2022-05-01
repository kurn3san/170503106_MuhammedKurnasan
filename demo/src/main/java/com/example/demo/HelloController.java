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

        Brand a = new Brand("12321cccc","somethingcccc","somethingcccccc ");
        a.setNotes("ccccc");

        dbHandler.addBrand(a);


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

}