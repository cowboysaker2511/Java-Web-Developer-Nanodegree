package com.example.Entity2_Demo.data;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized
    private String recipientName;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryDateTime;
    private Boolean completed;

    @OneToMany(mappedBy = "delivery")
    private List<Plant> plants;

    public Delivery() {
    }
}
