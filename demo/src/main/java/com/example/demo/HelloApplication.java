package com.example.demo;

import com.example.demo.database.dbHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        dbHandler dbh= new dbHandler();
        try {
            dbh.connect();
            System.out.println("connected!");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            ;
        }
    }

    public static void main(String[] args) {


        launch();
    }
}