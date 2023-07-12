package com.example.Entity3_Demo;

import com.example.Entity3_Demo.data.Flower;
import com.example.Entity3_Demo.data.Plant;
import com.example.Entity3_Demo.repository.PlantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Entity3DemoApplication {
    private PlantRepository plantRepository;

    public Entity3DemoApplication(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Entity3DemoApplication.class, args);
    }


    @Bean
    CommandLineRunner initData() {
        return args -> {
//            Delivery delivery = new Delivery("recipientName", "address", LocalDateTime.now(), true);
            Plant plant = new Flower("name", new BigDecimal(100),
                    null,
                    "color");
            plantRepository.save(plant);
        };
    }
}
