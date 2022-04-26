package com.example.demo.model;

public class Repairman extends User{
    // 1 attributes
    // 2 constructor
    // 3 getters and setters


    /////////////////
    //
    // 1 attributes
    //
    private int seniority=1;

    public Repairman(String id_no, String user_id, String password) {
        super(id_no, user_id, password);
    }

    public Repairman(Person person, String user_id, String password) {
        super(person, user_id, password);
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
