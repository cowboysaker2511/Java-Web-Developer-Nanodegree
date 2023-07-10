package com.example.Swagger_Demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwaggerDemoApplication {

    private DogRepository dogRepository ;

    public SwaggerDemoApplication(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            dogRepository.save(new Dog("Name 1", "Breed 1", "Origin 1"));
            dogRepository.save(new Dog("Name 2", "Breed 2", "Origin 2"));
        };
    }
}
