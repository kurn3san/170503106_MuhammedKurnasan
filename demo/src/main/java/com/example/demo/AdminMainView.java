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
    public Pane ManagersPaneAdding;
    @FXML
    public TextField AdminsPanelAddIdTextField2;
    @FXML
    public TextField AdminsPanelAddFirstNameTextField2;
    @FXML
    public TextField AdminsPanelAddLastNameTextField2;
    @FXML
    public TextField AdminsPanelAddAddressTextField2;
    @FXML
    public TextField AdminsPanelAddBirthDateTextField2;
    @FXML
    public TextField AdminsPanelAddTellNoTextField2;
    @FXML
    public TextField AdminsPanelAddEmailTextField2;
    @FXML
    public TextField AdminsPanelAddNotesTextField2;
    @FXML
    public Button AdminsPanelAddAdminFinishButton2;
    @FXML
    public Button AdminsPanelAddAdminCleanAllViewsButton2;
    @FXML
    public Button AdminsViewAddingPaneExitPageButton2;
    ////editing manager stuff
    @FXML
    public Pane editManagerPane;
    @FXML
    public TextField EditingAdminSearchEmailTextField11;
    @FXML
    public TextField searchedAdminsPasswordTextField11;
    @FXML
    public TextField AdminsPanelAddIdTextField11;
    @FXML
    public TextField AdminsPanelAddFirstNameTextField11;
    @FXML
    public TextField AdminsPanelAddLastNameTextField11;
    @FXML
    public TextField AdminsPanelAddAddressTextField11;
    @FXML
    public TextField AdminsPanelAddBirthDateTextField11;
    @FXML
    public TextField AdminsPanelAddTellNoTextField11;
    @FXML
    public TextField AdminsPanelAddEmailTextField11;
    @FXML
    public TextField AdminsPanelAddNotesTextField11;
    @FXML
    public Button AdminsPanelAddAdminCleanAllViewsButton11;
    @FXML
    public Button AdminsViewAddingPaneExitPageButton11;
    @FXML
    public Button editingAdminSearchButton1;
    @FXML
    public Button editingAdminUpdateButton1;
    @FXML
    public TextField searchedManagerEmailTextField;
    ///warehouse manager add wmanager stuff
    @FXML
    public TextField AdminsPanelAddIdTextField21;
    @FXML
    public TextField AdminsPanelAddFirstNameTextField21;
    @FXML
    public TextField AdminsPanelAddLastNameTextField21;
    @FXML
    public TextField AdminsPanelAddAddressTextField21;
    @FXML
    public TextField AdminsPanelAddBirthDateTextField21;
    @FXML
    public TextField AdminsPanelAddTellNoTextField21;
    @FXML
    public TextField AdminsPanelAddEmailTextField21;
    @FXML
    public TextField AdminsPanelAddNotesTextField21;
    @FXML
    public Button AdminsPanelAddAdminFinishButton21;
    @FXML
    public Button AdminsPanelAddAdminCleanAllViewsButton21;
    @FXML
    public Button AdminsViewAddingPaneExitPageButton21;
    ///edit whouse manager stuff
    @FXML

    public Pane warehouseManagersPaneAdding1;
    @FXML
    public Pane editwManagerPane1;
    @FXML
    public TextField AdminsPanelAddIdTextField111;
    @FXML
    public TextField AdminsPanelAddFirstNameTextField111;
    @FXML
    public TextField AdminsPanelAddLastNameTextField111;
    @FXML
    public TextField AdminsPanelAddAddressTextField111;
    @FXML
    public TextField AdminsPanelAddBirthDateTextField111;
    @FXML
    public TextField AdminsPanelAddTellNoTextField111;
    @FXML
    public TextField AdminsPanelAddEmailTextField111;
    @FXML
    public TextField AdminsPanelAddNotesTextField111;
    @FXML
    public TextField EditingAdminSearchEmailTextField111;
    @FXML
    public TextField searchedAdminsPasswordTextField111;
    @FXML
    public TextField searchedManagerEmailTextField111;
    public Button AdminsPanelAddAdminCleanAllViewsButton111;
    public Button AdminsViewAddingPaneExitPageButton111;
    public Button editingAdminSearchButton11;
    public Button editingAdminUpdateButton11;
    public Button warehouseMangmentAddbutton1;
    public Pane editwManagerPane11;
    ///salesmen stuff
    public TextField AdminsPanelAddIdTextField211;
    public TextField AdminsPanelAddFirstNameTextField211;
    public TextField AdminsPanelAddLastNameTextField211;
    public TextField AdminsPanelAddAddressTextField211;
    public TextField AdminsPanelAddBirthDateTextField211;
    public TextField AdminsPanelAddTellNoTextField211;
    public TextField AdminsPanelAddEmailTextField211;
    public TextField AdminsPanelAddNotesTextField211;
    public Button AdminsPanelAddAdminFinishButton211;
    public Button AdminsPanelAddAdminCleanAllViewsButton211;
    public Button AdminsViewAddingPaneExitPageButton211;
    /////// end of add salesman stuff
    //begin of edit delete salesman stuff
    ///

    public TextField AdminsPanelAddIdTextField1111;
    public TextField AdminsPanelAddFirstNameTextField1111;
    public TextField AdminsPanelAddLastNameTextField1111;
    public TextField AdminsPanelAddAddressTextField1111;
    public TextField AdminsPanelAddBirthDateTextField1111;
    public TextField AdminsPanelAddTellNoTextField1111;
    public TextField AdminsPanelAddEmailTextField1111;
    public TextField AdminsPanelAddNotesTextField1111;
    public Button AdminsPanelAddAdminCleanAllViewsButton1111;
    public Button AdminsViewAddingPaneExitPageButton1111;
    public TextField EditingAdminSearchEmailTextField1111;
    public Button editingAdminUpdateButton1111;
    public TextField searchedAdminsPasswordTextField1111;
    public TextField searchedManagerEmailTextField1111;
    public Button editingAdminSearchButton1111;
    //end of edit delete salesman stuff

    /// end of editing manager stuff
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

    @FXML
    public void addManagersPaneShowPane() {
        ManagersPaneAdding.setVisible(true);
        editManagerPane.setVisible(false);
        //other must be false.. but we're not there yet...

    }
    @FXML
    public void addManagersPanehidePane() {
        ManagersPaneAdding.setVisible(false);
    }
    @FXML
    public void clearAllFieldsaddingManagers() {
        AdminsPanelAddAddressTextField2.clear();
        AdminsPanelAddBirthDateTextField2.clear();
        AdminsPanelAddEmailTextField2.clear();
        AdminsPanelAddFirstNameTextField2.clear();
        AdminsPanelAddIdTextField2.clear();
        AdminsPanelAddLastNameTextField2.clear();
        AdminsPanelAddNotesTextField2.clear();
        AdminsPanelAddTellNoTextField2.clear();

    }
    @FXML
    public void managersPaneAddManagerfinish() {
        String address=AdminsPanelAddAddressTextField2.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField2.getText();
        String Email=AdminsPanelAddEmailTextField2.getText();
        String FirstName=AdminsPanelAddFirstNameTextField2.getText();
        String Id=AdminsPanelAddIdTextField2.getText();
        String LastName=AdminsPanelAddLastNameTextField2.getText();
        String Notes=AdminsPanelAddNotesTextField2.getText();
        String TellNo=AdminsPanelAddTellNoTextField2.getText();
        if(address.isEmpty()||BirthDate.isEmpty()||Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||TellNo.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else if (!Email.endsWith("@manager")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure manager's email ends with @manager. otherwise it won't be assigned as a manager!");
            AdminsPanelAddEmailTextField2.clear();
            AdminsPanelAddEmailTextField2.getCursor();
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

                        AdminsPanelAddAddressTextField2.clear();
                        AdminsPanelAddBirthDateTextField2.clear();
                        AdminsPanelAddEmailTextField2.clear();
                        AdminsPanelAddFirstNameTextField2.clear();
                        AdminsPanelAddIdTextField2.clear();
                        AdminsPanelAddLastNameTextField2.clear();
                        AdminsPanelAddNotesTextField2.clear();
                        AdminsPanelAddTellNoTextField2.clear();
                    }catch (Exception e ){
                        e.printStackTrace();
                    }
                }else{
                    Frame parent = new JFrame();
                    parent.setTitle("failed !");
                    JOptionPane.showMessageDialog(parent, "error while adding Person!, there's already someone with that email!");
                }
                //dbHandler.addPerson(p);
            }
            catch (Exception e){
                e.printStackTrace();
                Frame parent = new JFrame();
                parent.setTitle("unknown error !");
                JOptionPane.showMessageDialog(parent, "error while adding Person!");
            }
            /**/


        }

    }
    @FXML
    public void hideEdigtingManagersPane() {
        editManagerPane.setVisible(false);

    }
    @FXML
    public void showManagerEditOrDeletePane() {
        ManagersPaneAdding.setVisible(false);
        editManagerPane.setVisible(true);
    }
    @FXML
    public void editingManagerFindByEmail() {
        String Email1=searchedManagerEmailTextField.getText();
        String Email=EditingAdminSearchEmailTextField11.getText();
        if(!Email.isEmpty()&&!Email1.isEmpty()){
            Person p=new Person(Email);
            Person p2=new Person(Email1);
            if((!dbHandler.isThereSuchaPerson(p)||!Email.endsWith("@admin"))&&(!dbHandler.isThereSuchaPerson(p2)||!Email1.endsWith("@manager"))) {
                Frame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "check the info...");
                ;
            }
            else{
                String pass=searchedAdminsPasswordTextField11.getText();
                if(pass.isEmpty()){
                    Frame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "provied that admin's password!");
                }else{
                    try {
                        User u=new User(new Person(Email),pass);
                        User u2=dbHandler.getUserByEmail(Email1);
                        p2=dbHandler.getPerson(p2);
                        Admin a=new Admin("",u);
                        a.setEmail(Email);
                        System.out.println(a.getEmail()+a.getPassword());
                        Admin admin = dbHandler.getAdmin(a);
                        ////
                        AdminsPanelAddAddressTextField11.setText(p2.getAddress());
                        AdminsPanelAddBirthDateTextField11.setText(p2.getBirth());
                        AdminsPanelAddEmailTextField11.setText(p2.getEmail());
                        AdminsPanelAddFirstNameTextField11.setText(p2.getName());
                        AdminsPanelAddIdTextField11.setText(p2.getId_no());
                        AdminsPanelAddLastNameTextField11.setText(p2.getLasname());
                        AdminsPanelAddNotesTextField11.setText(p2.getNotes());
                        AdminsPanelAddTellNoTextField11.setText(p2.getTel_no());

                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Frame parent = new JFrame();
                        JOptionPane.showMessageDialog(parent, "errror!");
                    }
                }
            }
        }

    }
    @FXML
    public void editingManagerUpdate() {
        String address=AdminsPanelAddAddressTextField11.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField11.getText();
        String Email=AdminsPanelAddEmailTextField11.getText();
        String FirstName=AdminsPanelAddFirstNameTextField11.getText();
        String Id=AdminsPanelAddIdTextField11.getText();
        String LastName=AdminsPanelAddLastNameTextField11.getText();
        String Notes=AdminsPanelAddNotesTextField11.getText();
        String TellNo=AdminsPanelAddTellNoTextField11.getText();
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
                    AdminsPanelAddAddressTextField11.clear();
                    AdminsPanelAddBirthDateTextField11.clear();
                    AdminsPanelAddEmailTextField11.clear();
                    AdminsPanelAddFirstNameTextField11.clear();
                    AdminsPanelAddIdTextField11.clear();
                    AdminsPanelAddLastNameTextField11.clear();
                    AdminsPanelAddNotesTextField11.clear();
                    AdminsPanelAddTellNoTextField11.clear();
                    searchedAdminsPasswordTextField.clear();
                    EditingAdminSearchEmailTextField11.clear();
                    searchedAdminsPasswordTextField11.clear();
                    searchedManagerEmailTextField.clear();
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
    public void editingManagerDeleteMethod() {


        String address=AdminsPanelAddAddressTextField11.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField11.getText();
        String Email=AdminsPanelAddEmailTextField11.getText();
        String FirstName=AdminsPanelAddFirstNameTextField11.getText();
        String Id=AdminsPanelAddIdTextField11.getText();
        String LastName=AdminsPanelAddLastNameTextField11.getText();
        String Notes=AdminsPanelAddNotesTextField11.getText();
        String TellNo=AdminsPanelAddTellNoTextField11.getText();
        String pass=searchedAdminsPasswordTextField11.getText();
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
            try{
                //b=deleted=true if b
                boolean b=dbHandler.deleteUserWithPersonInfo(u);
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");

                    AdminsPanelAddAddressTextField11.clear();
                    AdminsPanelAddBirthDateTextField11.clear();
                    AdminsPanelAddEmailTextField11.clear();
                    AdminsPanelAddFirstNameTextField11.clear();
                    AdminsPanelAddIdTextField11.clear();
                    AdminsPanelAddLastNameTextField11.clear();
                    AdminsPanelAddNotesTextField11.clear();
                    AdminsPanelAddTellNoTextField11.clear();
                    searchedAdminsPasswordTextField.clear();
                    EditingAdminSearchEmailTextField11.clear();
                    searchedAdminsPasswordTextField11.clear();
                    searchedManagerEmailTextField.clear();
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
    public void editingManagerPasswordReset() {
        String address=AdminsPanelAddAddressTextField11.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField11.getText();
        String Email=AdminsPanelAddEmailTextField11.getText();
        String FirstName=AdminsPanelAddFirstNameTextField11.getText();
        String Id=AdminsPanelAddIdTextField11.getText();
        String LastName=AdminsPanelAddLastNameTextField11.getText();
        String Notes=AdminsPanelAddNotesTextField11.getText();
        String TellNo=AdminsPanelAddTellNoTextField11.getText();
        String pass=searchedAdminsPasswordTextField11.getText();
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
                boolean b=dbHandler.resetUsersPasswordSearchByEmail(Email);
                //b=deleted=true if b
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");

                    AdminsPanelAddAddressTextField11.clear();
                    AdminsPanelAddBirthDateTextField11.clear();
                    AdminsPanelAddEmailTextField11.clear();
                    AdminsPanelAddFirstNameTextField11.clear();
                    AdminsPanelAddIdTextField11.clear();
                    AdminsPanelAddLastNameTextField11.clear();
                    AdminsPanelAddNotesTextField11.clear();
                    AdminsPanelAddTellNoTextField11.clear();
                    searchedAdminsPasswordTextField.clear();
                    EditingAdminSearchEmailTextField11.clear();
                    searchedAdminsPasswordTextField11.clear();
                    searchedManagerEmailTextField.clear();
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
    public void onEditingManagersCleanAllViews() {
        AdminsPanelAddAddressTextField11.clear();
        AdminsPanelAddBirthDateTextField11.clear();
        AdminsPanelAddEmailTextField11.clear();
        AdminsPanelAddFirstNameTextField11.clear();
        AdminsPanelAddIdTextField11.clear();
        AdminsPanelAddLastNameTextField11.clear();
        AdminsPanelAddNotesTextField11.clear();
        AdminsPanelAddTellNoTextField11.clear();
        searchedAdminsPasswordTextField.clear();
        EditingAdminSearchEmailTextField11.clear();
        searchedAdminsPasswordTextField11.clear();
        searchedManagerEmailTextField.clear();
    }

    @FXML
    public void addWarehouseManagerShowAddPane() {
        warehouseManagersPaneAdding1.setVisible(true);
        editwManagerPane1.setVisible(false);


    }
    @FXML
    public void editOrDeleteWarehouseManagerShowDeleteOrEditPain() {
        warehouseManagersPaneAdding1.setVisible(false);
        editwManagerPane1.setVisible(true);


    }
    @FXML
    public void addWarehouseManagersPaneHidePane() {
        warehouseManagersPaneAdding1.setVisible(false);
        //
    }
    @FXML
    public void clearAllFieldsWarehouseAddingManagers() {
        AdminsPanelAddAddressTextField21.clear();
        AdminsPanelAddBirthDateTextField21.clear();
        AdminsPanelAddEmailTextField21.clear();
        AdminsPanelAddFirstNameTextField21.clear();
        AdminsPanelAddIdTextField21.clear();
        AdminsPanelAddLastNameTextField21.clear();
        AdminsPanelAddNotesTextField21.clear();
        AdminsPanelAddTellNoTextField21.clear();
    }
    @FXML
    public void warehouseManagersPaneAddManagerfinish() {

        String address=AdminsPanelAddAddressTextField21.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField21.getText();
        String Email=AdminsPanelAddEmailTextField21.getText();
        String FirstName=AdminsPanelAddFirstNameTextField21.getText();
        String Id=AdminsPanelAddIdTextField21.getText();
        String LastName=AdminsPanelAddLastNameTextField21.getText();
        String Notes=AdminsPanelAddNotesTextField21.getText();
        String TellNo=AdminsPanelAddTellNoTextField21.getText();
        if(address.isEmpty()||BirthDate.isEmpty()||Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||TellNo.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else if (!Email.endsWith("@wmanager")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure warehouse manager's email ends with @wmanager. otherwise it won't be assigned as a warehouse manager!");
            AdminsPanelAddEmailTextField2.clear();
            AdminsPanelAddEmailTextField2.getCursor();
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

                        AdminsPanelAddAddressTextField21.clear();
                        AdminsPanelAddBirthDateTextField21.clear();
                        AdminsPanelAddEmailTextField21.clear();
                        AdminsPanelAddFirstNameTextField21.clear();
                        AdminsPanelAddIdTextField21.clear();
                        AdminsPanelAddLastNameTextField21.clear();
                        AdminsPanelAddNotesTextField21.clear();
                        AdminsPanelAddTellNoTextField21.clear();
                    }catch (Exception e ){
                        e.printStackTrace();
                    }
                }else{
                    Frame parent = new JFrame();
                    parent.setTitle("failed !");
                    JOptionPane.showMessageDialog(parent, "error while adding Person!, there's already someone with that email!");
                }
                //dbHandler.addPerson(p);
            }
            catch (Exception e){
                e.printStackTrace();
                Frame parent = new JFrame();
                parent.setTitle("unknown error !");
                JOptionPane.showMessageDialog(parent, "error while adding Person!");
            }
            /**/


        }
    }

    public void hideEdigtingwManagersPane() {
        editwManagerPane1.setVisible(false);
    }
    @FXML
    public void editingwManagerFindByEmail() {

        String Email1=searchedManagerEmailTextField111.getText();
        String Email=EditingAdminSearchEmailTextField111.getText();
        if(!Email.isEmpty()&&!Email1.isEmpty()){
            Person p=new Person(Email);
            Person p2=new Person(Email1);
            if((!dbHandler.isThereSuchaPerson(p)||!Email.endsWith("@admin"))&&(!dbHandler.isThereSuchaPerson(p2)||!Email1.endsWith("@wmanager"))) {
                Frame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "check the info...");
                ;
            }
            else{
                String pass=searchedAdminsPasswordTextField111.getText();
                if(pass.isEmpty()){
                    Frame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "provied that admin's password!");
                }else{
                    try {
                        User u=new User(new Person(Email),pass);
                        User u2=dbHandler.getUserByEmail(Email1);
                        p2=dbHandler.getPerson(p2);
                        Admin a=new Admin("",u);
                        a.setEmail(Email);
                        System.out.println(a.getEmail()+a.getPassword());
                        Admin admin = dbHandler.getAdmin(a);
                        ////
                        AdminsPanelAddAddressTextField111.setText(p2.getAddress());
                        AdminsPanelAddBirthDateTextField111.setText(p2.getBirth());
                        AdminsPanelAddEmailTextField111.setText(p2.getEmail());
                        AdminsPanelAddFirstNameTextField111.setText(p2.getName());
                        AdminsPanelAddIdTextField111.setText(p2.getId_no());
                        AdminsPanelAddLastNameTextField111.setText(p2.getLasname());
                        AdminsPanelAddNotesTextField111.setText(p2.getNotes());
                        AdminsPanelAddTellNoTextField111.setText(p2.getTel_no());

                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Frame parent = new JFrame();
                        JOptionPane.showMessageDialog(parent, "errror!");
                    }
                }
            }
        }


    }

    public void onEditingwManagersCleanAllViews() {
        AdminsPanelAddIdTextField111.clear();
        AdminsPanelAddFirstNameTextField111.clear();
        AdminsPanelAddLastNameTextField111.clear();
        AdminsPanelAddAddressTextField111.clear();
        AdminsPanelAddBirthDateTextField111.clear();
        AdminsPanelAddTellNoTextField111.clear();
        AdminsPanelAddEmailTextField111.clear();
        AdminsPanelAddNotesTextField111.clear();
        EditingAdminSearchEmailTextField111.clear();
        searchedAdminsPasswordTextField111.clear();
        searchedManagerEmailTextField111.clear();
    }

    public void editingwManagerUpdate() {

        String address=AdminsPanelAddAddressTextField111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField111.getText();
        String Email=AdminsPanelAddEmailTextField111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField111.getText();
        String Id=AdminsPanelAddIdTextField111.getText();
        String LastName=AdminsPanelAddLastNameTextField111.getText();
        String Notes=AdminsPanelAddNotesTextField111.getText();
        String TellNo=AdminsPanelAddTellNoTextField111.getText();
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
                    AdminsPanelAddAddressTextField111.clear();
                    AdminsPanelAddBirthDateTextField111.clear();
                    AdminsPanelAddEmailTextField111.clear();
                    AdminsPanelAddFirstNameTextField111.clear();
                    AdminsPanelAddIdTextField111.clear();
                    AdminsPanelAddLastNameTextField111.clear();
                    AdminsPanelAddNotesTextField111.clear();
                    AdminsPanelAddTellNoTextField111.clear();
                    searchedAdminsPasswordTextField111.clear();
                    EditingAdminSearchEmailTextField11.clear();
                    searchedAdminsPasswordTextField111.clear();
                    searchedManagerEmailTextField111.clear();
                    editwManagerPane1.setVisible(false);

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

    public void editingwManagerDeleteMethod() {
        String address=AdminsPanelAddAddressTextField111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField111.getText();
        String Email=AdminsPanelAddEmailTextField111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField111.getText();
        String Id=AdminsPanelAddIdTextField111.getText();
        String LastName=AdminsPanelAddLastNameTextField111.getText();
        String Notes=AdminsPanelAddNotesTextField111.getText();
        String TellNo=AdminsPanelAddTellNoTextField111.getText();
        String pass=searchedAdminsPasswordTextField111.getText();
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
            try{
                //b=deleted=true if b
                boolean b=dbHandler.deleteUserWithPersonInfo(u);
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");

                    AdminsPanelAddAddressTextField111.clear();
                    AdminsPanelAddBirthDateTextField111.clear();
                    AdminsPanelAddEmailTextField111.clear();
                    AdminsPanelAddFirstNameTextField111.clear();
                    AdminsPanelAddIdTextField111.clear();
                    AdminsPanelAddLastNameTextField111.clear();
                    AdminsPanelAddNotesTextField111.clear();
                    AdminsPanelAddTellNoTextField111.clear();
                    searchedAdminsPasswordTextField111.clear();
                    EditingAdminSearchEmailTextField111.clear();
                    searchedAdminsPasswordTextField111.clear();
                    searchedManagerEmailTextField111.clear();
                    editwManagerPane1.setVisible(false);


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

    public void editingwManagerPasswordReset() {

        String address=AdminsPanelAddAddressTextField111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField111.getText();
        String Email=AdminsPanelAddEmailTextField111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField111.getText();
        String Id=AdminsPanelAddIdTextField111.getText();
        String LastName=AdminsPanelAddLastNameTextField111.getText();
        String Notes=AdminsPanelAddNotesTextField111.getText();
        String TellNo=AdminsPanelAddTellNoTextField111.getText();
        String pass=searchedAdminsPasswordTextField111.getText();
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
                boolean b=dbHandler.resetUsersPasswordSearchByEmail(Email);
                //b=deleted=true if b
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");

                    AdminsPanelAddAddressTextField111.clear();
                    AdminsPanelAddBirthDateTextField111.clear();
                    AdminsPanelAddEmailTextField111.clear();
                    AdminsPanelAddFirstNameTextField111.clear();
                    AdminsPanelAddIdTextField111.clear();
                    AdminsPanelAddLastNameTextField111.clear();
                    AdminsPanelAddNotesTextField111.clear();
                    AdminsPanelAddTellNoTextField111.clear();
                    searchedAdminsPasswordTextField111.clear();
                    EditingAdminSearchEmailTextField111.clear();
                    searchedAdminsPasswordTextField111.clear();
                    searchedManagerEmailTextField111.clear();
                    editwManagerPane1.setVisible(false);


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

    public void addSalesmanShowAddPane() {
        warehouseMangmentAddbutton1.setVisible(true);
        editwManagerPane11.setVisible(false);
    }

    public void editOrDeleteSalesmanShowDeleteOrEditPain() {
        warehouseMangmentAddbutton1.setVisible(false);
        editwManagerPane11.setVisible(true);
    }

    public void clearAllFieldsaddSalespeople() {
        AdminsPanelAddAddressTextField211.clear();
        AdminsPanelAddBirthDateTextField211.clear();
        AdminsPanelAddEmailTextField211.clear();
        AdminsPanelAddFirstNameTextField211.clear();
        AdminsPanelAddIdTextField211.clear();
        AdminsPanelAddLastNameTextField211.clear();
        AdminsPanelAddNotesTextField211.clear();
        AdminsPanelAddTellNoTextField211.clear();
    }

    public void addSalesmanHideAddPane() {
        warehouseMangmentAddbutton1.setVisible(false);
    }

    public void salesAddSalemanFinish() {

        String address=AdminsPanelAddAddressTextField211.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField211.getText();
        String Email=AdminsPanelAddEmailTextField211.getText();
        String FirstName=AdminsPanelAddFirstNameTextField211.getText();
        String Id=AdminsPanelAddIdTextField211.getText();
        String LastName=AdminsPanelAddLastNameTextField211.getText();
        String Notes=AdminsPanelAddNotesTextField211.getText();
        String TellNo=AdminsPanelAddTellNoTextField211.getText();
        if(address.isEmpty()||BirthDate.isEmpty()||Email.isEmpty()||FirstName.isEmpty()||Id.isEmpty()||LastName.isEmpty()||TellNo.isEmpty()){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure you fill all necessary fileds properly! ");
        }
        else if (!Email.endsWith("@sales")){
            Frame parent = new JFrame();
            JOptionPane.showMessageDialog(parent, "Please make sure salesperson's email ends with @sales. otherwise it won't be assigned as a salesperson!");
            AdminsPanelAddEmailTextField211.clear();
            AdminsPanelAddEmailTextField211.getCursor();
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

                        AdminsPanelAddAddressTextField211.clear();
                        AdminsPanelAddBirthDateTextField211.clear();
                        AdminsPanelAddEmailTextField211.clear();
                        AdminsPanelAddFirstNameTextField211.clear();
                        AdminsPanelAddIdTextField211.clear();
                        AdminsPanelAddLastNameTextField211.clear();
                        AdminsPanelAddNotesTextField211.clear();
                        AdminsPanelAddTellNoTextField211.clear();
                    }catch (Exception e ){
                        e.printStackTrace();
                    }
                }else{
                    Frame parent = new JFrame();
                    parent.setTitle("failed !");
                    JOptionPane.showMessageDialog(parent, "error while adding Person!, there's already someone with that email!");
                }
                //dbHandler.addPerson(p);
            }
            catch (Exception e){
                e.printStackTrace();
                Frame parent = new JFrame();
                parent.setTitle("unknown error !");
                JOptionPane.showMessageDialog(parent, "error while adding Person!");
            }
            /**/


        }

    }

    public void editSalesmanHideEditPane() {
        editwManagerPane11.setVisible(false);
    }

    public void editingSalesmanDeleteMethod() {

        String address=AdminsPanelAddAddressTextField1111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField1111.getText();
        String Email=AdminsPanelAddEmailTextField1111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField1111.getText();
        String Id=AdminsPanelAddIdTextField1111.getText();
        String LastName=AdminsPanelAddLastNameTextField1111.getText();
        String Notes=AdminsPanelAddNotesTextField1111.getText();
        String TellNo=AdminsPanelAddTellNoTextField1111.getText();
        String pass=searchedAdminsPasswordTextField1111.getText();
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
            try{
                //b=deleted=true if b
                boolean b=dbHandler.deleteUserWithPersonInfo(u);
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");

                    AdminsPanelAddAddressTextField1111.clear();
                    AdminsPanelAddBirthDateTextField1111.clear();
                    AdminsPanelAddEmailTextField1111.clear();
                    AdminsPanelAddFirstNameTextField1111.clear();
                    AdminsPanelAddIdTextField1111.clear();
                    AdminsPanelAddLastNameTextField1111.clear();
                    AdminsPanelAddNotesTextField1111.clear();
                    AdminsPanelAddTellNoTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    EditingAdminSearchEmailTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    searchedManagerEmailTextField1111.clear();
                    editwManagerPane11.setVisible(false);


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

    public void editingSalesmanPasswordReset() {

        String address=AdminsPanelAddAddressTextField1111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField1111.getText();
        String Email=AdminsPanelAddEmailTextField1111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField1111.getText();
        String Id=AdminsPanelAddIdTextField1111.getText();
        String LastName=AdminsPanelAddLastNameTextField1111.getText();
        String Notes=AdminsPanelAddNotesTextField1111.getText();
        String TellNo=AdminsPanelAddTellNoTextField1111.getText();
        String pass=searchedAdminsPasswordTextField1111.getText();
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
                boolean b=dbHandler.resetUsersPasswordSearchByEmail(Email);
                //b=deleted=true if b
                if(b){
                    Frame parent = new JFrame();
                    parent.setTitle("Success !");
                    JOptionPane.showMessageDialog(parent, "Success !");
                    AdminsPanelAddAddressTextField1111.clear();
                    AdminsPanelAddBirthDateTextField1111.clear();
                    AdminsPanelAddEmailTextField1111.clear();
                    AdminsPanelAddFirstNameTextField1111.clear();
                    AdminsPanelAddIdTextField1111.clear();
                    AdminsPanelAddLastNameTextField1111.clear();
                    AdminsPanelAddNotesTextField1111.clear();
                    AdminsPanelAddTellNoTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    EditingAdminSearchEmailTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    searchedManagerEmailTextField1111.clear();
                    editwManagerPane11.setVisible(false);
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
    public void editingSalesmanUpdate() {
        String address=AdminsPanelAddAddressTextField1111.getText();
        String BirthDate=AdminsPanelAddBirthDateTextField1111.getText();
        String Email=AdminsPanelAddEmailTextField1111.getText();
        String FirstName=AdminsPanelAddFirstNameTextField1111.getText();
        String Id=AdminsPanelAddIdTextField1111.getText();
        String LastName=AdminsPanelAddLastNameTextField1111.getText();
        String Notes=AdminsPanelAddNotesTextField1111.getText();
        String TellNo=AdminsPanelAddTellNoTextField1111.getText();
        String pass=searchedAdminsPasswordTextField1111.getText();
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
                    AdminsPanelAddAddressTextField1111.clear();
                    AdminsPanelAddBirthDateTextField1111.clear();
                    AdminsPanelAddEmailTextField1111.clear();
                    AdminsPanelAddFirstNameTextField1111.clear();
                    AdminsPanelAddIdTextField1111.clear();
                    AdminsPanelAddLastNameTextField1111.clear();
                    AdminsPanelAddNotesTextField1111.clear();
                    AdminsPanelAddTellNoTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    EditingAdminSearchEmailTextField1111.clear();
                    searchedAdminsPasswordTextField1111.clear();
                    searchedManagerEmailTextField1111.clear();
                    editwManagerPane11.setVisible(false);

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

    public void editingSalesmanFindByEmail() {
        String Email1=searchedManagerEmailTextField1111.getText();
        String Email=EditingAdminSearchEmailTextField1111.getText();
        if(!Email.isEmpty()&&!Email1.isEmpty()){
            Person p=new Person(Email);
            Person p2=new Person(Email1);
            if((!dbHandler.isThereSuchaPerson(p)||!Email.endsWith("@admin"))&&(!dbHandler.isThereSuchaPerson(p2)||!Email1.endsWith("@sales"))) {
                Frame parent = new JFrame();
                JOptionPane.showMessageDialog(parent, "check the info...");
                ;
            }
            else{
                String pass=searchedAdminsPasswordTextField1111.getText();
                if(pass.isEmpty()){
                    Frame parent = new JFrame();
                    JOptionPane.showMessageDialog(parent, "provied that admin's password!");
                }else{
                    try {
                        User u=new User(new Person(Email),pass);
                        User u2=dbHandler.getUserByEmail(Email1);
                        p2=dbHandler.getPerson(p2);
                        Admin a=new Admin("",u);
                        a.setEmail(Email);
                        System.out.println(a.getEmail()+a.getPassword());
                        Admin admin = dbHandler.getAdmin(a);
                        ////
                        AdminsPanelAddAddressTextField1111.setText(p2.getAddress());
                        AdminsPanelAddBirthDateTextField1111.setText(p2.getBirth());
                        AdminsPanelAddEmailTextField1111.setText(p2.getEmail());
                        AdminsPanelAddFirstNameTextField1111.setText(p2.getName());
                        AdminsPanelAddIdTextField1111.setText(p2.getId_no());
                        AdminsPanelAddLastNameTextField1111.setText(p2.getLasname());
                        AdminsPanelAddNotesTextField1111.setText(p2.getNotes());
                        AdminsPanelAddTellNoTextField1111.setText(p2.getTel_no());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        Frame parent = new JFrame();
                        JOptionPane.showMessageDialog(parent, "errror!");
                    }
                }
            }
        }
    }

    public void onEditingSalesmansCleanAllViews() {
        AdminsPanelAddAddressTextField1111.clear();
        AdminsPanelAddBirthDateTextField1111.clear();
        AdminsPanelAddEmailTextField1111.clear();
        AdminsPanelAddFirstNameTextField1111.clear();
        AdminsPanelAddIdTextField1111.clear();
        AdminsPanelAddLastNameTextField1111.clear();
        AdminsPanelAddNotesTextField1111.clear();
        AdminsPanelAddTellNoTextField1111.clear();
        searchedAdminsPasswordTextField1111.clear();
        EditingAdminSearchEmailTextField1111.clear();
        searchedAdminsPasswordTextField1111.clear();
        searchedManagerEmailTextField1111.clear();
    }
}
