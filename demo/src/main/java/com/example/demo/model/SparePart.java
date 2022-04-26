package com.example.demo.model;

public class SparePart extends Brand{


    //1 attributes
    //2 getters and setters
    //3 constructor
    //4 equals
    private String part_id;
    private String model_id;
    private String model_name;
    private String model_date;


    //
    //
    //
    //getters and setters
    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }
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
    //
    // 3 constructor
    public SparePart(Brand brand,String part_id,String model_id, String model_name, String model_date) {
        super(brand.getBrand_id(), brand.getBrand_name(), brand.getAddress(), brand.getNotes());
        this.part_id=part_id;
        this.model_id = model_id;
        this.model_name = model_name;
        this.model_date = model_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SparePart)) return false;
        if (!super.equals(o)) return false;
        SparePart sparePart = (SparePart) o;
        return getPart_id().equals(sparePart.getPart_id()) && getModel_id().equals(sparePart.getModel_id());
    }

}
