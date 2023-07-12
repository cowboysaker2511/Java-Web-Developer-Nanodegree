package com.example.Entity3_Demo.controller;

import com.example.Entity3_Demo.data.Plant;
import com.example.Entity3_Demo.dto.PlantDTO;
import com.example.Entity3_Demo.jsonview.PlantJSON;
import com.example.Entity3_Demo.service.PlantService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    @JsonView(PlantJSON.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }
}