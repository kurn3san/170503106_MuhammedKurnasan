package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Car;
import com.example.demo.model.CarModel;
import com.example.demo.model.Customer;
import com.example.demo.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class SalesmanMainView {
    public TextField textField1;
    public TextField textField2;
    public TextField textField3;
    public TextField textField4;
    public TextField textField5;
    public TextField textField6;
    public TextField textField7;
    public TextField textField8;
    public TextField priceSold;
    public TextField carsSold;
    public Label priceLabel;
    public Label quantityLabel;
    public ChoiceBox choicebox1;
    public ChoiceBox choicebox2;
    public ChoiceBox choicebox3;
    public ChoiceBox choicebox4;
    Car currentCar=null;
    Person currentCustomer=null;
    @FXML
    private void initialize(){
        refreshBox1();
    }
    public void refreshBox1(){
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs= dbHandler.getAllBrandsFromCarModels();
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("brand_id"));
                }
                choicebox1.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox2(){
        String box1String= String.valueOf(choicebox1.getValue()) ;
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getAllModelsFromCarModels(box1String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_id"));
                }
                choicebox2.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox3(){

        String box1String= String.valueOf(choicebox1.getValue()) ;
        String box2String=String.valueOf(choicebox2.getValue());
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getModel_Sub_NamesFromCarModels(box1String,box2String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_name"));
                }
                choicebox3.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox4(){

        String box1String= String.valueOf(choicebox1.getValue()) ;
        String box2String=String.valueOf(choicebox2.getValue());
        String box3String=String.valueOf(choicebox3.getValue());

        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getyearFromCarModels(box1String,box2String,box3String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_date"));
                }
                choicebox4.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }

    public void recordSale() {
        if (currentCustomer==null&&currentCar!=null){
            try {
                Person p=new Person("");
                p.setId_no(String.valueOf(textField1.getText()));
                p.setName(String.valueOf(textField2.getText()));
                p.setLasname(String.valueOf(textField3.getText()));
                p.setAddress(String.valueOf(textField4.getText()));
                p.setBirth(String.valueOf(textField5.getText()));
                p.setEmail(String.valueOf(textField7.getText()));
                p.setTel_no(String.valueOf(textField6.getText()));
                p.setNotes(String.valueOf(textField8.getText()));
                dbHandler.addPerson(p);
                int price=Integer.valueOf(priceSold.getText());
                int quantitiy=Integer.valueOf(carsSold.getText());

                dbHandler.sellCar("koro",currentCar,price,quantitiy,p   );

            }catch (Exception e){

            }

        }
        else if(currentCustomer!=null&&currentCar!=null){
            try {

                int price=Integer.valueOf(priceSold.getText());
                int quantitiy=Integer.valueOf(carsSold.getText());

                dbHandler.sellCar("koro",currentCar,price,quantitiy,currentCustomer   );

            }catch (Exception e){

            }
        }

    }

    public void getInfo() {
        String s=String.valueOf(choicebox1.getValue());
        String s2=String.valueOf(choicebox2.getValue());
        String s3=String.valueOf(choicebox3.getValue()) ;
        String s4=String.valueOf(choicebox4.getValue());
        if(!s.isEmpty()&&!s2.isEmpty()&&!s3.isEmpty()&&!s4.isEmpty()){
            CarModel cm=new CarModel("","");
            cm.setBrand_id(s2);
            cm.setModel_id(s);
            cm.setModel_name(s3);
            cm.setModel_date(s4);
            try{
                Car c=dbHandler.getCar(cm);
                currentCar=c;
                priceLabel.setText(String.valueOf(c.getPrice()));
                quantityLabel.setText(String.valueOf(c.getCounts()));
            }catch (Exception e){
                Frame parent = new JFrame();
                parent.setTitle("error !");
                JOptionPane.showMessageDialog(parent, "error!!");
            }

        }
        else{
            Frame parent = new JFrame();
            parent.setTitle("error !");
            JOptionPane.showMessageDialog(parent, "make sure all values are set!!");
        }
    }

    public void clearCustomerInfo() {
        textField5.clear();
        textField3.clear();
        textField8.clear();
        textField7.clear();
        textField6.clear();
        textField1.clear();
        textField2.clear();
    }

    public void findCustomerByEmail() {
        String email=textField7.getText();
        if(email.isEmpty()){
            Frame parent = new JFrame();
            parent.setTitle("error !");
            JOptionPane.showMessageDialog(parent, "Provide an email");
        }else{
            if(!dbHandler.isThereSuchaPerson(new Person(email))){
                Frame parent = new JFrame();
                parent.setTitle("error !");
                JOptionPane.showMessageDialog(parent, "there's no one registered with this email...");
            }else{
                Person p=dbHandler.getPerson(new Person(email));
                textField1.setText(p.getId_no());
                textField2.setText(p.getName());
                textField3.setText(p.getLasname());
                textField4.setText(p.getAddress());
                textField5.setText(p.getBirth());
                textField6.setText(p.getTel_no());
                textField8.setText(p.getNotes());
                currentCustomer=p;

            }
        }
    }
}
