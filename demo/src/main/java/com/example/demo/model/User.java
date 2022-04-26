package com.example.demo.model;

import java.util.Objects;

public class User extends Person{
    // 1 attributes
    // 2 constructor
    // 3 getters and setters



    /////////////////
    //
    // 1 attributes
    //
    private boolean works_or_not=false;     // default


    private String user_id;
    ///////////////////

    // 2 constructor
    //
    //
    public User(String id_no,String user_id) {
        super(id_no);
        this.user_id=user_id;
    }
    public User(Person person,String user_id){
        super(person.getId_no(),person.getName(), person.getLasname(), person.getAdress(), person.getBirth(), person.getEmail(), person.getTel_no(),person.getNotes());
        this.user_id=user_id;
    }

    public boolean isWorks_or_not() {
        return works_or_not;
    }
    //////////////////////////

    // 3 getters and setters
    //
    //
    public void setWorks_or_not(boolean works_or_not) {
        this.works_or_not = works_or_not;
    }
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
