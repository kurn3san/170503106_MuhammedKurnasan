package com.example.demo.model;

public class Car extends CarModel{


    int counts;
    int price;

    @Override
    public String toString() {
        return "Car{" +
                "model_id='" + this.getModel_id() + '\'' +
                ", count=" + counts +
                ", price=" + price +
                '}';
    }




    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public Car(Brand brand, String model_id, String model_name, String model_date) {
        super(brand, model_id, model_name, model_date);
    }

    public Car(String brandName, String model_id, String model_name, String model_date) {
        super(brandName, model_id, model_name, model_date);
    }

    public Car(String brandName, String modelName) {
        super(brandName, modelName);
    }
    public Car(String brandname,String modelName,int counts,int price){
        super(brandname, modelName);
        this.counts=counts;
        this.price=price;

    }
}
