package com.example.Entity3_Demo.service;

import com.example.Entity3_Demo.data.Plant;
import com.example.Entity3_Demo.repository.PlantRepository;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

    private PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlantById(Long id) {
        return plantRepository.findById(id).get();
    }
}
