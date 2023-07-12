package com.example.Entity3_Demo.dto;

import com.example.Entity3_Demo.data.Delivery;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

public class PlantDTO {
    private String name;
    private BigDecimal price;
}
