package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CarCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nameCategory;

    @OneToMany(mappedBy = "carcategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Car> cars;


    public CarCategory() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
