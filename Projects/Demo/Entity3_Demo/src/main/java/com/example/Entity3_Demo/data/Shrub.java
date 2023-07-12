package com.example.Entity3_Demo.data;

import jakarta.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private Double height;
    private Double width;

    public Shrub() {
    }
}

