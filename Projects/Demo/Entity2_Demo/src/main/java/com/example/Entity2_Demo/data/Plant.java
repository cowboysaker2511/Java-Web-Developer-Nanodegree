package com.example.Entity2_Demo.data;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Plant {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized
    private String name;
    @Column(precision = 12, scale = 4)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Plant() {
    }

}
