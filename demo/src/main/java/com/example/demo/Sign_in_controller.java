package com.example.demo;

import com.example.demo.database.dbHandler;
import com.example.demo.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Sign_in_controller {
    public static User current_user=new User("0000","00000");
    public static boolean isAdmin=false;
    public static Person current_person=new Person("000@user");
    @FXML
    private TextField signInEmailTextField;
    @FXML
    private PasswordField signInPasswordField;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSignInButtonClick(){
        String email=signInEmailTextField.getText();
        String password=signInPasswordField.getText();
        System.out.println(email+password);
        if(email.endsWith("@admin")){
            System.out.println("admin");
            User u=new User(new Person(email),password);

            Admin a=new Admin("",u);
            a.setEmail(email);
            System.out.println(a.getEmail()+a.getPassword());
            try {

                current_user= dbHandler.getUser(u);
                isAdmin=true;
                current_person=test_get_people_with_id(current_user);
                Admin admin = dbHandler.getAdmin(a);
                showAdminMainView();

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            User u=new User(new Person(email),password);
            //dbHandler.getUser(u);
            try {
                User user =dbHandler.getUser(u);
                System.out.println("     "+user.getUser_id());
                System.out.println(user.getEmail()+"   .");
                System.out.println("personal id"+user.getId_no());
                current_user=user;
                current_person=test_get_people_with_id(new Person(user.getEmail()));


            }
            catch(Exception e ){
                e.printStackTrace();
                System.out.println(1);
                System.out.println();
            }
        }


    }
    private void showAdminMainView(){
        signInEmailTextField.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adminMainView.fxml"));
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
    private void initialize(){
        connect();
        //some delicious tests...
        //System.out.println("222222"+dbHandler.isThereSuchaUser(u));
        //some tests...
        //test_add_admin(); // done!
        //insert_new_brand();
        //insert_car();
        //insert_person2(); //inserted koro1@admin
        //insert_salesman();
        //insert_new_CarModel_for_existing_brand();
        //makePersonKoroUserKoro1();
        //test_add_Koro_admin();done!
        //test_deleteaPerson(); done!
        //User u=new User(new Person("sdfsfsdf"),"fff");
        //u.setEmail("sdfsfsdf");
        //Admin a=new Admin("0001",u);
        //u.setEmail("e@admin");
        //u.setPassword("default");
        //dbHandler.deleteAdmin(a);
        //dbHandler.deleteUserWithPersonInfo(u);
        //dbHandler.deletePerson(new Person("sdfsfsdf"));
        // well done!!!




    }



    private void connect(){

        try {
            dbHandler.connect();
            System.out.println("connected!");
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
    private void test_add_admin(){
        User u = new User("99","00002","fff");
        Admin a = new Admin("0001",u);
        a.setEmail("sdfsfsdf");
        try{
            long l =dbHandler.addAdmin(a);
            System.out.println(l);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
    private void updatesomeone(){
        // # person_id, name, lastname, address, birth, tel_no, email, notes
        //'2', 'b', 'asdf', 'sadf', 'asdf', 'sdfaa', 'sdfaf', 'sadf'
        Person p=new Person("sdfaf");
        p.setEmail("sdfaf");
        p.setId_no("2");
        p.setName("b");
        p.setLasname("asdf");
        p.setAddress("sadf");
        p.setBirth("asdf");
        p.setTel_no("sdfaa");
        p.setEmail("sdfaf");
        p.setNotes("sadf");
        Person person =dbHandler.getPerson(p);
        p.setName   ("aaaaa");
        p.setLasname("aaaaaa");
        p.setAddress("aaaaaa");
        p.setTel_no ("aaaaaa");
        p.setNotes  ("aaaaaa");

        dbHandler.updatePersonInfo(person);
    }
    private void test_add_Koro_admin(){
        Person koro=new Person("99999999","koro1",
                "koro1","korostan1","10-06-1996",
                "000000001","koro1@admin","koro1");
        User koroUser1=new User(koro,"00000","koro1");
        Admin a=new Admin("000000",koroUser1);
        try{
            long l =dbHandler.addAdmin(a);
            System.out.println(l);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
    private void makePersonKoroUserKoro1(){
        Person koro=new Person("999456999","ko456o1",
                "kor456o1","koros456tan1","10-456996",
                "000004560001","kor456o1@admin","ko456ro1");
        User koroUser1=new User(koro,"00000","koro1");
        long l =dbHandler.addUser(koroUser1);
        System.out.println(l);
    }
    private Person test_get_people_with_id(Person p){
        Person P=new Person("koro@admin");
        Person my_person=dbHandler.getPerson(P);
        return my_person;
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
        CarModel c = new CarModel("somethings22i22iiii","1toyota_cruz","cruz","2014");
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
    private void insert_person(){
        Person p=new Person("991901230","Ahmad","Aljbawy",
                "Aleppo", "19-10-1999","0933581706",
                "malk@laksd.com","nonotes");
        dbHandler.addPerson(p);
    }
    private void insert_person2(){
        Person koro=new Person("99999999","koro1",
                "koro1","korostan1","10-06-1996",
                "000000001","koro1@admin","koro1");
                dbHandler.addPerson(koro);
    }
    private void insert_user1(){
        Person alj=new Person("991901230","Ahmad","Aljbawy",
                "Aleppo","19-10-1999","safdsaf",
                "lsk;dfa","kl");
        User u=new User(alj,"00001","pas");
        dbHandler.addUser(u);
    }
    private void insert_user2(){
        Person alj=new Person("9994","a1","Aljbawy1",
                "Aleppo","19-10-1999","safdsaf",
                "lsk;dfa","kl");
        User u=new User(alj,"000002","pa0s");
        dbHandler.addUser(u);
    }
    private void insert_salesman(){
        Person alj=new Person("99","a","Aljbawy","Aleppo","19-10-1999","safdsaf","lsk;dfa","kl");
        Salesman s=new Salesman(alj,"00002","pass");
        s.setSeniority(3);
        dbHandler.addSalesman(s);
    }


}