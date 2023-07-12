package com.example.Entity2_Demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Shrub extends Plant {
    private Double height;
    private Double width;
    @ManyToMany
    private List<Delivery> deliveries;

    public Shrub() {
    }
}

