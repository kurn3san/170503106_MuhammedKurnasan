package com.example.demo.model;

public class CarModel extends Brand{
    //1 attributes
    //2 getters and setters
    //3 constructor
    //4 equals
    private String model_id;
    private String model_name;
    private String model_date;


    //
    //
    //
    //getters and setters
    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_date() {
        return model_date;
    }

    public void setModel_date(String model_date) {
        this.model_date = model_date;
    }

    public CarModel(Brand brand,String model_id, String model_name, String model_date) {
        super(brand.getBrand_id(), brand.getBrand_name(), brand.getAddress(), brand.getNotes());
        this.model_id = model_id;
        this.model_name = model_name;
        this.model_date = model_date;
    }

}
