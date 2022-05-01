package com.example.demo.model;

public class User extends Person{
    // 1 attributes
    // 2 constructor
    // 3 getters and setters


    /////////////////
    //
    // 1 attributes
    //
    private boolean works_or_not=false;

    // default
    //
    //
    //
    private String user_id;

    private String password;

    public User(String id_no, String name, String lasname,
                String address, String birth, String tel_no,
                String email, String notes) {
        super(id_no, name,
                lasname, address,
                birth, tel_no,
                email, notes);
    }

    public User(String id_no, String user_id, String password) {

        super(id_no);
        this.user_id=user_id;
        this.password=password;

    }

    public User(Person p,String user_id,String password){

        super(p.getId_no(),p.getName(),p.getLasname(),
                p.getAddress(),p.getBirth(),
                p.getTel_no(),p.getEmail(),p.getNotes());

        this.user_id=user_id;
        this.password=password;
    }
    public User (Person p,String password){
        super(p.getEmail());
        this.password=password;
    }

    //
    //
    // 2 constructor
    //


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
