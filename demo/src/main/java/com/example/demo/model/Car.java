package com.example.demo.model;

import java.util.Objects;

public class Car extends CarModel{


    //1 attributes
    //2 constructor
    //3 getters and setters
    //4 equals



    //1 attributes

    private String car_id;
    private int price;
    private String delivery_date;
    private String car_notes="";



    //
    //
    //
    // 2 constructors

    public Car(Brand brand, String model_id, String model_name, String model_date,
               String car_id,int price,
               String delivery_date,String car_notes) {
        super(brand, model_id, model_name, model_date);
        this.car_id=car_id;
        this.price=price;
        this.delivery_date=delivery_date;
        this.car_notes=car_notes;
    }

    public Car(String brandName, String model_id, String model_name, String model_date,
               String car_id,int price,
               String delivery_date,String car_notes) {
        super(brandName, model_id, model_name, model_date);
        this.car_id=car_id;
        this.price=price;
        this.delivery_date=delivery_date;
        this.car_notes=car_notes;
    }

    public Car(String brandName, String modelName,
               String car_id,int price,
               String delivery_date,String car_notes) {
        super(brandName, modelName);
        this.car_id=car_id;
        this.price=price;
        this.delivery_date=delivery_date;
        this.car_notes=car_notes;
    }


    //
    //
    //
    //3 getters and setters

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getCar_notes() {
        return car_notes;
    }

    public void setCar_notes(String car_notes) {
        this.car_notes = car_notes;
    }

    //4 equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return getCar_id().equals(car.getCar_id());
    }

}
