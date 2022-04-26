package com.example.demo.model;

public class Delivery {

    // 1 attributes
    // 2 constructor
    // 3 getters and setters
    // 4 equals()
    //
    //
    // 1 attributes

    private String delivery_id;
    private String brand_id;
    private String date;
    private String notes="";
    private String address;
    /////////////////////////////////////////////////

    // 2 constructor

    public Delivery(String delivery_id, String brand_id, String date, String address) {
        this.delivery_id = delivery_id;
        this.brand_id = brand_id;
        this.date = date;
        this.address = address;
    }

    public Delivery(String delivery_id, String brand_id, String date, String notes, String address) {
        this.delivery_id = delivery_id;
        this.brand_id = brand_id;
        this.date = date;
        this.notes = notes;
        this.address = address;
    }
    /////////////////////////////////


    // 3 getters and setters

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    ////////////////////////


    // 4 equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery)) return false;
        Delivery delivery = (Delivery) o;
        return getDelivery_id().equals(delivery.getDelivery_id());
    }

}
