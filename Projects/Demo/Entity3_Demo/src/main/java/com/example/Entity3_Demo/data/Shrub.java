package com.example.Entity3_Demo.data;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Shrub extends Plant {
    private Double height;
    private Double width;

    public Shrub() {
    }

    public Shrub(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Shrub(String name, BigDecimal price, Delivery delivery, Double height, Double width) {
        super(name, price, delivery);
        this.height = height;
        this.width = width;
    }
}

