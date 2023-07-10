package com.example.Swagger_Demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private com.example.Swagger_Demo.DogRepository dogRepository;

    public DogService(com.example.Swagger_Demo.DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDog() {
        return dogRepository.findAll();
    }
}
