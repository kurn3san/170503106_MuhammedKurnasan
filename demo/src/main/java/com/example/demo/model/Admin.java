package com.example.demo.model;

public class Admin extends User{


    public Admin(String id_no, String name,
                 String lasname, String address,
                 String birth, String tel_no,
                 String email, String notes) {

        super(id_no, name,
                lasname, address,
                birth, tel_no,
                email, notes);
    }

    public Admin(String id_no,
                 String user_id,
                 String password) {

        super(id_no, user_id, password);
    }

    public Admin(Person p,
                 String user_id,
                 String password) {
        super(p, user_id, password);
    }
}
