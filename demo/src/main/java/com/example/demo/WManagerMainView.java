package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Brand;
import com.example.demo.model.Car;
import com.example.demo.model.CarModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class WManagerMainView {
    public TextField carBarcodeTextField;
    public TextField carPriceTextField;
    public TextField carDeliveryDateTextField;
    public TextField addCarNotesTextField;
    public TextField registerBrandNotes;
    public TextField RegisterBrandCompanyName;
    public TextField registerBrandNameTextField;
    public TextField registerBrandAddress;
    ////////register model
    public ChoiceBox registerModelBrandsChoiceBox;
    public TextField modelSubNameTextField;
    public TextField ModelNameTextField;
    public TextField dateTextField;//
    public TextField registerCarQuantityTextField;
    public ChoiceBox registerCarBox2;
    public ChoiceBox registerCarBox1;
    public TextField registerCarPriceTextField;
    public ChoiceBox registeraCarBox3;
    public ChoiceBox registerCarBox4;
    ///



    public void registerBrandAddFinish() {
        String brandName=registerBrandNameTextField.getText();
        String companyName=RegisterBrandCompanyName.getText();
        String address=registerBrandAddress.getText();
        String notes;
        if(registerBrandNotes.getText()!=null){
            notes= registerBrandNotes.getText();
        }

        if(!brandName.isEmpty()&&!companyName.isEmpty()&&!address.isEmpty()){
            Brand b=new Brand(brandName,companyName,address);
            if (!dbHandler.isThereSuchABrand(b)){
                try{
                    dbHandler.addBrand(b);
                }catch (Exception e){
                    Frame parent = new JFrame();
                    parent.setTitle("error !");
                    JOptionPane.showMessageDialog(parent, "fields required ");
                }

            }


        }else{
            Frame parent = new JFrame();
            parent.setTitle("error !");
            JOptionPane.showMessageDialog(parent, "fields required ");
        }
    }

    public void RegisterBrandClearFields() {
        registerBrandNameTextField.clear();
        RegisterBrandCompanyName.clear();
        registerBrandNotes.clear();
    }

    public void registerModelAddFinish() {
        String brandName=String.valueOf(registerModelBrandsChoiceBox.getValue());
        System.out.println(brandName);
        String modelSubname=modelSubNameTextField.getText();
        String modelName=ModelNameTextField.getText();
        String date=dateTextField.getText();
        if(!brandName.isEmpty()&&!modelName.isEmpty()){
            CarModel carModel=new CarModel(brandName,modelName);
            carModel.setModel_id(modelName);
            carModel.setBrand_id(brandName);
            carModel.setModel_name(modelSubname);
            carModel.setModel_date(date);
            System.out.println("carModel: model_id="+carModel.getModel_id()+carModel.getBrand_id()+carModel.getModel_name()+carModel.getModel_date());
            if(!dbHandler.isThereSuchACarModel(carModel)){
                dbHandler.addCarModel(carModel);
                modelSubNameTextField.clear();
                ModelNameTextField.clear();
                dateTextField.clear();
                Frame parent = new JFrame();
                parent.setTitle("done !");
                JOptionPane.showMessageDialog(parent, "Successfully added!");
            }else{
                Frame parent = new JFrame();
                parent.setTitle("error !");
                JOptionPane.showMessageDialog(parent, "this model is already registered!");
            }

        }

    }
    public void refreshBrandsBoxInCarsRegister(){
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getAllBrandsFromCarModels();
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("brand_id"));
                }
                registerCarBox1.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox2InCarRegister(){
        String box1String= String.valueOf(registerCarBox1.getValue()) ;
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getAllModelsFromCarModels(box1String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_id"));
                }
                registerCarBox2.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox3InCarRegister(){

        String box1String= String.valueOf(registerCarBox1.getValue()) ;
        String box2String=String.valueOf(registerCarBox2.getValue());
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getModel_Sub_NamesFromCarModels(box1String,box2String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_name"));
                }
                registeraCarBox3.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    public void refreshBox4InCarRegister(){
        String box1String= String.valueOf(registerCarBox1.getValue()) ;
        String box2String=String.valueOf(registerCarBox2.getValue());
        String box3String=String.valueOf(registeraCarBox3.getValue());

        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getyearFromCarModels(box1String,box2String,box3String);
        //System.out.println("refreshing 2 "+box1String+" was value of 1");
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("model_date"));
                }
                registerCarBox4.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }
    @FXML
    private void refreshModelBrandsChoiceBox(){
        ObservableList<String> listacombo= FXCollections.observableArrayList();
        ResultSet rs=dbHandler.getAllBrands();
        if(rs!=null){
            try{
                while ( rs.next() )
                {
                    listacombo.add(rs.getString("brand_id"));
                }
                registerModelBrandsChoiceBox.setItems(listacombo);
            }catch (Exception e){
            }
        }else{
        }
    }

    public void registerCarDeliveryFinish() {
        System.out.println("clicked!");
        String first=String.valueOf(registerCarBox1.getValue());
        String second=String.valueOf(registerCarBox2.getValue());
        String third=String.valueOf(registeraCarBox3.getValue());
        String fourth=String.valueOf(registerCarBox4.getValue());
        System.out.println(first+"  "+second+"   "+third+"   "+fourth);
        int p=0;
        int q=0;
        try{
            p=Integer.valueOf(registerCarPriceTextField.getText());
            q=Integer.valueOf(registerCarQuantityTextField.getText());
            System.out.println("p= "+ p+"q="+q);
        }catch (Exception e){

        }
        try{
            if(!first.isEmpty()&&!second.isEmpty()&&!third.isEmpty()&&!fourth.isEmpty()&&(p!=0&&q!=0)){
                CarModel cr=new CarModel(first,second);
                cr.setModel_id(first);
                cr.setBrand_id(second);
                cr.setModel_name(third);
                cr.setModel_date(fourth);
                boolean b=dbHandler.addCar(cr,q,p);

                if (b){
                    Frame parent = new JFrame();
                    parent.setTitle("done !");
                    JOptionPane.showMessageDialog(parent, "the new batch of cars is registered!");
                    registerCarQuantityTextField.clear();
                    registerCarPriceTextField.clear();
                    registerCarBox1.setValue("");
                    registerCarBox2.setValue("");
                    registeraCarBox3.setValue("");
                    registerCarBox4.setValue("");
                }else{

                }
                ///
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
