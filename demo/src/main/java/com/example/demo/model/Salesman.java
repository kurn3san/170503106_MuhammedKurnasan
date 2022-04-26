package com.example.demo.model;

public class Salesman extends User{
    // 1 attributes
    // 2 constructor
    // 3 getters and setters



    /////////////////
    //
    // 1 attributes
    //


    private int seniority=1;

    public Salesman(String id_no, String user_id, int seniority) {
        super(id_no, user_id);
        this.seniority = seniority;
    }

    public Salesman(Person person, String user_id, int seniority) {
        super(person, user_id);
        this.seniority = seniority;
    }
    ///////////////////

    // 2 constructor
    //
    //

    //////////////////////////

    // 3 getters and setters
    //
    //
    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }
}
