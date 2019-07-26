package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Car
{

    // var
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String brand;

    @NotNull
    private String model;


    private String year;

    @NotNull
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CarCategory carcategory;


    // constr
    public Car() {
    }

    public Car(@NotNull String brand, @NotNull String model, String year, @NotNull int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // getter & setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CarCategory getCarCategory() {
        return carcategory;
    }

    public void setCarCategory(CarCategory carcategory) {
        this.carcategory = carcategory;
    }
}
