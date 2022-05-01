package com.example.demo.model;

public class Brand {
    // Brand = Hersteller

    // 1 attributes
    // 2 constructor
    // 3 getters and setters
    // 4 equals()
    //
    //


    //    // 1 attributes
    private String brand_id;
    private String brand_name;
    private String address;
    private String notes="";


    //
    //
    // 2constructor
    public Brand(String brand_id, String brand_name, String address, String notes) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.address = address;
        this.notes = notes;
    }

    public Brand() {
    }

    public Brand(String brand_id, String brand_name, String address) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.address = address;
    }
    public Brand(String brand_name){
        this.brand_name=brand_name;
    }

    //
    //
    //
    //
    // 3 getters and setters
    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    //
    //
    // 4 equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return getBrand_id().equals(brand.getBrand_id());
    }

}
