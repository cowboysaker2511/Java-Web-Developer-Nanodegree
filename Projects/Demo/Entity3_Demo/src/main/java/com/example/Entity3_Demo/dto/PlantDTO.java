package com.example.Entity3_Demo.dto;

import java.math.BigDecimal;

public class PlantDTO {
    private String name;
    private BigDecimal price;

    public PlantDTO() {
    }

    public PlantDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "PlantDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
