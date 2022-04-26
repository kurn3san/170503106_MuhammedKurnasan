package com.example.demo.model;

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
    private String password;
    ///////////////////

    // 2 constructor
    //
    //
    public User(String id_no, String user_id, String password) {
        super(id_no);
        this.user_id=user_id;
        this.password = password;
    }
    public User(Person person, String user_id, String password){
        super(person.getId_no(),person.getName(), person.getLasname(), person.getAdress(), person.getBirth(), person.getEmail(), person.getTel_no(),person.getNotes());
        this.user_id=user_id;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
