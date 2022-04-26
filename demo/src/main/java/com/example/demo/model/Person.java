package com.example.demo.model;

import java.util.Objects;

public class Person {
    // 1 attributes
    // 2 constructor
    // 3 getters and setters
    // 4 equals

    /////////////////
    // 1 attributes
    //
    //

    private String id_no;       //Not null!
    private String name;       //Not null!
    private String lasname;       //Not null!
    private String adress="";
    private String birth="";
    private String tel_no;       //Not null!

    private String email;       //Not null!
    private String notes="";
    ////////////

    // 2 constructors
    //
    //
    //
    public Person(String id_no, String name, String lasname, String adress, String birth, String tel_no, String email, String notes) {
        this.id_no = id_no;
        this.name = name;
        this.lasname = lasname;
        this.adress = adress;
        this.birth = birth;
        this.tel_no = tel_no;
        this.email = email;
        this.notes = notes;
    }
    public Person(String id_no){
        this.id_no=id_no;
    }


    //////////////
    // 3 getters and setters
    //
    //
    //
    public String getId_no() {
        return id_no;}

    public void setId_no(String id_no) {this.id_no = id_no;}


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    public String getBirth() {return birth;}

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLasname() {
        return lasname;
    }

    public void setLasname(String lasname) {
        this.lasname = lasname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    /////////////////////////////////////

    //
    //  4 equals()
    //
    //
    //
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId_no().equals(person.getId_no());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_no());
    }




}
