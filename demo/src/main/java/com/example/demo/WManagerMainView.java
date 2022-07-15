package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Brand;
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
        String modelSubname=modelSubNameTextField.getText();
        String modelName=ModelNameTextField.getText();
        String date=dateTextField.getText();
        if(!brandName.isEmpty()&&!modelName.isEmpty()){
            CarModel carModel=new CarModel(brandName,modelName,modelSubname,date);
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
}
