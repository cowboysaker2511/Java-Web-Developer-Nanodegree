package com.example.Entity3_Demo.controller;

import com.example.Entity3_Demo.data.Plant;
import com.example.Entity3_Demo.dto.PlantDTO;
import com.example.Entity3_Demo.jsonview.PlantJSON;
import com.example.Entity3_Demo.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/dto/{id}")
    public PlantDTO getPlantDTO(@PathVariable Long id) {
        return convertPlantToPlantDTO(plantService.getPlantById(id));
    }

    @GetMapping("/json/{id}")
    @JsonView(PlantJSON.Public.class)
    public Plant getFilteredPlant(@PathVariable Long id) {
        Plant plantById = plantService.getPlantById(id);
        System.out.println(plantById);
        return plantById;
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO(plant.getName(), plant.getPrice());
        System.out.println(plant);
        System.out.println(plantDTO);
        return plantDTO;
    }
}