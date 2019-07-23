package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class CarDealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String dealerName;

    @NotNull
    private String dealerCity;

    @NotNull
    private String dealerPhone;

    @NotNull
    private String dealerEmail;

    @OneToMany(mappedBy = "cardealership", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    public Set<CarDealership> cardealership;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getDealerCity() {
        return dealerCity;
    }

    public void setDealerCity(String dealerCity) {
        this.dealerCity = dealerCity;
    }

    public String getDealerPhone() {
        return dealerPhone;
    }

    public void setDealerPhone(String dealerPhone) {
        this.dealerPhone = dealerPhone;
    }

    public String getDealerEmail() {
        return dealerEmail;
    }

    public void setDealerEmail(String dealerEmail) {
        this.dealerEmail = dealerEmail;
    }

    public Set<CarDealership> getCardealership() {
        return cardealership;
    }

    public void setCardealership(Set<CarDealership> cardealership) {
        this.cardealership = cardealership;
    }
}

