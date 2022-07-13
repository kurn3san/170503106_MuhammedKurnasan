package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.Admin;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AdminMainView {
    @FXML
    private Pane AdminsManagmentAddingPane;
    @FXML
    private TextField AdminsPanelAddAddressTextField;

    @FXML
    private Button AdminsPanelAddAdminCleanAllViewsButton;
    @FXML
    private Button AdminsViewAddingPaneExitPageButton;

    @FXML
    private Button AdminsPanelAddAdminFinishButton;

    @FXML
    private TextField AdminsPanelAddBirthDateTextField;

    @FXML
    private TextField AdminsPanelAddEmailTextField;

    @FXML
    private TextField AdminsPanelAddFirstNameTextField;

    @FXML
    private TextField AdminsPanelAddIdTextField;

    @FXML
    private TextField AdminsPanelAddLastNameTextField;

    @FXML
    private TextField AdminsPanelAddNotesTextField;

    @FXML
    private TextField AdminsPanelAddTellNoTextField;

    ///editing search stuff
    @FXML
    private TextField EditingAdminSearchEmailTextField;
    @FXML
    private TextField searchedAdminsPasswordTextField;
    @FXML
    private TextField AdminsPanelAddAddressTextField1;
    @FXML
    private TextField AdminsPanelAddBirthDateTextField1;

    @FXML
    private TextField AdminsPanelAddEmailTextField1;

    @FXML
    private TextField AdminsPanelAddFirstNameTextField1;

    @FXML
    private TextField AdminsPanelAddIdTextField1;

    @FXML
    private TextField AdminsPanelAddLastNameTextField1;

    @FXML
    private TextField AdminsPanelAddNotesTextField1;

    @FXML
    private TextField AdminsPanelAddTellNoTextField1;
    ///////// end of editing manager search stuff

    @FXML
    private Button AdminsPanelAddingViewButton;

    @FXML
    private Button AdminsPanelDeletingView;

    @FXML
    private Button AdminsPanelEditingViewButton;

    @FXML
    private void showAdminsPanelAddingPane(){
        AdminsManagmentAddingPane.setVisible(true);
        AdminsManagmentEditingPane.setVisible(false);
    }

    @FXML
    private void hideAdminAddingPane(){
        AdminsManagmentAddingPane.setVisible(false);
    }
    @FXML
    private Pane AdminsManagmentEditingPane;
    @FXML
    private void onClickAdminsPanelAddAdminCleanAllViewsButton(){
        AdminsPanelAddAddressTextField.clear();
        AdminsPanelAddBirthDateTextField.clear();
        AdminsPanelAddEmailTextField.clear();
        AdminsPanelAddFirstNameTextField.clear();
        AdminsPanelAddIdTextField.clear();
        AdminsPanelAddLastNameTextField.clear();
        AdminsPanelAddNotesTextField.clear();
        AdminsPanelAddTellNoTextField.clear();

    }

    @FXML
    public void onClickAdminsPanelAddAdminFinishButton() {
        String address=AdminsPanelAddAddressTextField.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField.getText();
        String Email=AdminsPanelAddEmailTextField.getText();
        String FirstName=AdminsPanelAddFirstNameTextField.getText();
        String Id=AdminsPanelAddIdTextField.getText();
        String LastName=AdminsPanelAddLastNameTextField.getText();
        String Notes=AdminsPanelAddNotesTextField.getText();
        String TellNo=AdminsPanelAddTellNoTextField.getText();
        if(address.isEmpty()||BirthDate.isEmpty()||Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||TellNo.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else if (!Email.endsWith("@admin")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure admin's email ends with @admin. otherwise it won't be assigned as an admin!");
            AdminsPanelAddEmailTextField.clear();
            AdminsPanelAddEmailTextField.getCursor();
        }
        else{
            // here we add the info...

            //
            //add person
            Person p=new Person(Id,FirstName,
                    LastName,address,BirthDate,
                    TellNo,Email,Notes);

            try{
                int number_of_users=dbHandler.howManyUsersAreThere();
                System.out.println(number_of_users+"   :    number of users");
                if(!dbHandler.isThereSuchaPerson(p)&&!dbHandler.isThereSuchaUserWithID(p.getId_no())){

                    try{
                        dbHandler.addPerson(p);
                        //add user
                        User u=new User(p,Integer.toString(number_of_users+1),"default");
                        dbHandler.addUser(u);
                        // add admin
                        String admin_id=Integer.toString(dbHandler.howManyAdminsAreThere()+1);
                        Admin a = new Admin(admin_id,u);
                        long l1 = dbHandler.addAdmin(a);
                        System.out.println(l1);
                        AdminsPanelAddAddressTextField.clear();
                        AdminsPanelAddBirthDateTextField.clear();
                        AdminsPanelAddEmailTextField.clear();
                        AdminsPanelAddFirstNameTextField.clear();
                        AdminsPanelAddIdTextField.clear();
                        AdminsPanelAddLastNameTextField.clear();
                        AdminsPanelAddNotesTextField.clear();
                        AdminsPanelAddTellNoTextField.clear();
                    }catch (Exception e ){
                        e.printStackTrace();
                    }
                }
                //dbHandler.addPerson(p);
            }
            catch (Exception e){
                e.printStackTrace();
                Frame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "error while adding Person!");
            }
            /**/


        }


    }
    @FXML
    private void signOut(){
        AdminsPanelAddEmailTextField.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signInView.fxml"));
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("signInView.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setTitle("Admin View");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void exit() {
        Platform.exit();
    }


    @FXML
    public void editingAdminUpdate() {
        String address=AdminsPanelAddAddressTextField1.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField1.getText();
        String Email=AdminsPanelAddEmailTextField1.getText();
        String FirstName=AdminsPanelAddFirstNameTextField1.getText();
        String Id=AdminsPanelAddIdTextField1.getText();
        String LastName=AdminsPanelAddLastNameTextField1.getText();
        String Notes=AdminsPanelAddNotesTextField1.getText();
        String TellNo=AdminsPanelAddTellNoTextField1.getText();
        /*if(Email.equals("koro1@admin")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "");
        }*/
        if(address.isEmpty()||BirthDate.isEmpty()||Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||TellNo.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else{
            Person p=new Person(Email);
            p.setEmail(Email);
            p.setName(FirstName);
            p.setLasname(LastName);
            p.setBirth(BirthDate);
            p.setAddress(address);
            p.setTel_no(TellNo);
            p.setId_no(Id);
            p.setNotes(Notes);
            try{
                boolean b=dbHandler.updatePersonInfo(p);
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success ! ");
                    AdminsPanelAddAddressTextField1.clear();
                    AdminsPanelAddBirthDateTextField1.clear();
                    AdminsPanelAddEmailTextField1.clear();
                    AdminsPanelAddFirstNameTextField1.clear();
                    AdminsPanelAddIdTextField1.clear();
                    AdminsPanelAddLastNameTextField1.clear();
                    AdminsPanelAddNotesTextField1.clear();
                    AdminsPanelAddTellNoTextField1.clear();
                    AdminsManagmentEditingPane.setVisible(false);

                }else{
                    Frame parent = new JFrame();
                    parent.setTitle("error !");
                    JOptionPane.showMessageDialog(parent, "unkonwn error! ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void hideAdminEditingPane() {
        AdminsManagmentEditingPane.setVisible(false);
        AdminsManagmentAddingPane.setVisible(false);
        AdminsPanelAddAddressTextField1.clear();
        AdminsPanelAddBirthDateTextField1.clear();
        AdminsPanelAddEmailTextField1.clear();
        AdminsPanelAddFirstNameTextField1.clear();
        AdminsPanelAddIdTextField1.clear();
        AdminsPanelAddLastNameTextField1.clear();
        AdminsPanelAddNotesTextField1.clear();
        AdminsPanelAddTellNoTextField1.clear();
        searchedAdminsPasswordTextField.clear();

    }
    @FXML
    public void editingAdminFindByEmailSearch() {
        String Email=EditingAdminSearchEmailTextField.getText();
        if(!Email.isEmpty()){
            Person p=new Person(Email);
            if(!dbHandler.isThereSuchaPerson(p)||!Email.endsWith("@admin")) {
                Frame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "there is no such admin!");
                ;
            }
            else{
                String pass=searchedAdminsPasswordTextField.getText();
                if(pass.isEmpty()){
                    Frame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "provied that admin's password!");
                }else{
                    User u=new User(new Person(Email),pass);

                    Admin a=new Admin("",u);
                    a.setEmail(Email);
                    System.out.println(a.getEmail()+a.getPassword());
                    try {
                        Admin admin = dbHandler.getAdmin(a);
                        System.out.println(admin.getUser_id()+admin.getBirth());
                        u=dbHandler.getUser(u);
                        Person person=dbHandler.getPerson(new Person(Email));

                        ////
                        AdminsPanelAddAddressTextField1.setText(person.getAddress());
                        AdminsPanelAddBirthDateTextField1.setText(person.getBirth());
                        AdminsPanelAddEmailTextField1.setText(person.getEmail());
                        AdminsPanelAddFirstNameTextField1.setText(person.getName());
                        AdminsPanelAddIdTextField1.setText(person.getId_no());
                        AdminsPanelAddLastNameTextField1.setText(person.getLasname());
                        AdminsPanelAddNotesTextField1.setText(person.getNotes());
                        AdminsPanelAddTellNoTextField1.setText(person.getTel_no());

                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    @FXML
    public void editAdminPaneViewshow() {
        AdminsManagmentAddingPane.setVisible(false);
        AdminsManagmentEditingPane.setVisible(true);
    }

    @FXML
    public void onClickAdminsPanelEditingAdminsCleanAllViewsButton() {
        AdminsPanelAddAddressTextField1.clear();
        AdminsPanelAddBirthDateTextField1.clear();
        AdminsPanelAddEmailTextField1.clear();
        AdminsPanelAddFirstNameTextField1.clear();
        AdminsPanelAddIdTextField1.clear();
        AdminsPanelAddLastNameTextField1.clear();
        AdminsPanelAddNotesTextField1.clear();
        AdminsPanelAddTellNoTextField1.clear();
        searchedAdminsPasswordTextField.clear();
    }

    @FXML
    public void editPaneDeleteAdmin() {


        String address=AdminsPanelAddAddressTextField1.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField1.getText();
        String Email=AdminsPanelAddEmailTextField1.getText();
        String FirstName=AdminsPanelAddFirstNameTextField1.getText();
        String Id=AdminsPanelAddIdTextField1.getText();
        String LastName=AdminsPanelAddLastNameTextField1.getText();
        String Notes=AdminsPanelAddNotesTextField1.getText();
        String TellNo=AdminsPanelAddTellNoTextField1.getText();
        String pass=searchedAdminsPasswordTextField.getText();
        /*if(Email.equals("koro1@admin")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "");
        }*/
        if(Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||pass.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else{
            Person p=new Person(Email);
            p.setEmail(Email);
            p.setName(FirstName);
            p.setLasname(LastName);
            p.setBirth(BirthDate);
            p.setAddress(address);
            p.setTel_no(TellNo);
            p.setId_no(Id);
            p.setNotes(Notes);
            User u=new User(new Person(Email),pass);
            Admin a=new Admin("",u);
            a.setEmail(Email);
            System.out.println(a.getEmail()+a.getPassword());
            try{
                Admin admin = dbHandler.getAdmin(a);
                System.out.println(admin.getUser_id()+admin.getBirth());
                u=dbHandler.getUser(u);
                Person person=dbHandler.getPerson(new Person(Email));
                //b=deleted=true if b
                boolean b=dbHandler.deleteAdmin(a);
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");
                    AdminsPanelAddAddressTextField1.clear();
                    AdminsPanelAddBirthDateTextField1.clear();
                    AdminsPanelAddEmailTextField1.clear();
                    AdminsPanelAddFirstNameTextField1.clear();
                    AdminsPanelAddIdTextField1.clear();
                    AdminsPanelAddLastNameTextField1.clear();
                    AdminsPanelAddNotesTextField1.clear();
                    AdminsPanelAddTellNoTextField1.clear();
                    searchedAdminsPasswordTextField.clear();
                    AdminsManagmentEditingPane.setVisible(false);


                }else{
                    Frame parent = new JFrame();
                    parent.setTitle("error !");
                    JOptionPane.showMessageDialog(parent, "unkonwn error! ");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
