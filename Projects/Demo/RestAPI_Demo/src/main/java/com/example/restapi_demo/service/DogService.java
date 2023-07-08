package com.example.restapi_demo.service;

import com.example.restapi_demo.entity.Dog;
import com.example.restapi_demo.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private DogRepository dogRepository;

    public List<Dog> retrieveDog() {
        return dogRepository.findAll();
    }
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    public List<String> retrieveDogBreeds() {
        return dogRepository.findAllBreed();
    }

    public List<String> retrieveDogBreedById(Long id) {
        return dogRepository.findAllBreedById(id);
    }

    public List<String> retrieveDogNames(String name) {
        return dogRepository.findAllBreedByName(name);
    }

}
