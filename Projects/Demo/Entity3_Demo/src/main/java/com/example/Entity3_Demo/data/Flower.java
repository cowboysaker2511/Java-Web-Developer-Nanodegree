package com.example.Entity3_Demo.data;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Flower extends Plant {
    private String color;

    public Flower() {
    }

    public Flower(String color) {
        this.color = color;
    }

    public Flower(String name, BigDecimal price, Delivery delivery, String color) {
        super(name, price, delivery);
        this.color = color;
    }
}
