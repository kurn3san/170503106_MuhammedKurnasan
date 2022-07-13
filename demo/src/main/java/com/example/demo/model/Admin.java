package com.example.demo.model;

public class Admin extends User{

    private String admin_id;


    public Admin(String admin_id,String id_no, String name, String lasname, String address, String birth, String tel_no, String email, String notes) {
        super(id_no, name, lasname, address, birth, tel_no, email, notes);
        this.admin_id=admin_id;
    }

    public Admin(String admin_id,String id_no, String user_id, String password) {
        super(id_no, user_id, password);
        this.admin_id=admin_id;

    }

    public Admin(String admin_id,String id_no, String user_id) {
        super(id_no, user_id);
        this.admin_id=admin_id;

    }

    public Admin(String admin_id,Person p, String user_id, String password) {
        super(p, user_id, password);
        this.admin_id=admin_id;

    }

    public Admin(String admin_id,Person p, String password) {
        super(p, password);
        this.admin_id=admin_id;

    }
    public Admin(String admin_id,User u) {
        super(u.getId_no(),u.getUser_id(), u.getPassword());
        this.admin_id=admin_id;

    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
}
