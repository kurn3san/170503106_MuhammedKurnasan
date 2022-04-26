package com.example.demo.model;

public class Customer extends Person {
    //1 attributes
    //2 constructor
    //3 getters and setters
    //4 equals

    //1 attributes

    private String customer_id;


    //2 constructor

    public Customer(String id_no, String name, String lasname, String adress, String birth, String tel_no, String email, String notes, String customer_id) {
        super(id_no, name, lasname, adress, birth, tel_no, email, notes);
        this.customer_id = customer_id;
    }

    public Customer(String id_no, String customer_id) {
        super(id_no);
        this.customer_id = customer_id;
    }
}

