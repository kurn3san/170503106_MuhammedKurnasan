package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signInView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 720);
        stage.setTitle("AutoBaYi!");
        stage.setScene(scene);
        stage.show();
        //System.out.println("number of users: "+dbHandler.howManyUsersAreThere());
        //System.out.println("number of admins: "+dbHandler.howManyAdminsAreThere());




    }

    public static void main(String[] args) {


        launch();
    }
}