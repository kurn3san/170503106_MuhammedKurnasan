package com.example.demo.model;

public class Sale {
    //1 attributes
    //2 constructor
    //3 getters and setters


    //1 attributes

    private String sale_id;
    private String salesman_id;
    private String date;
    private String customer_id;


    //2 constructor

    public Sale(String sale_id, String salesman_id, String date, String customer_id) {
        this.sale_id = sale_id;
        this.salesman_id = salesman_id;
        this.date = date;
        this.customer_id = customer_id;
    }


    //3 getters and setters

    public String getSale_id() {
        return sale_id;
    }

    public void setSale_id(String sale_id) {
        this.sale_id = sale_id;
    }

    public String getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(String salesman_id) {
        this.salesman_id = salesman_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }
}
