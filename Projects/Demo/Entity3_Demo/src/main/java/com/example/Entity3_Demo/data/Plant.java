package com.example.Entity3_Demo.data;

import com.example.Entity3_Demo.jsonview.PlantJSON;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Plant {
    @Id
    @GeneratedValue
    @JsonView(PlantJSON.class)
    private Long id;
    @Nationalized
    private String name;
    @Column(precision = 12, scale = 4)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonView(PlantJSON.class)
    private Delivery delivery;

    public Plant() {
    }

}
