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
    private Long id;
    @Nationalized
    @JsonView(PlantJSON.Public.class)
    private String name;
    @Column(precision = 12, scale = 4)
    @JsonView(PlantJSON.Public.class)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Plant() {
    }

    public Plant(String name, BigDecimal price, Delivery delivery) {
        this.name = name;
        this.price = price;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", delivery=" + delivery +
                '}';
    }
}
