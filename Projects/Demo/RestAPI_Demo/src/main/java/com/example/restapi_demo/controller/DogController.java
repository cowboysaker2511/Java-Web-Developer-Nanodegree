package com.example.restapi_demo.controller;

import com.example.restapi_demo.entity.Dog;
import com.example.restapi_demo.service.DogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dog/all")
    public ResponseEntity<List<Dog>> retrieveDog() {
        return new ResponseEntity<>(dogService.retrieveDog(), HttpStatus.OK);
    }

    @GetMapping("/breeds/all")
    public ResponseEntity<List<String>> retrieveDogBreed() {
        return new ResponseEntity<>(dogService.retrieveDogBreeds(), HttpStatus.OK);
    }

    @GetMapping("/breeds/{id}")
    public ResponseEntity<List<String>> retrieveDogBreedById(@PathVariable Long id) {
        List<String> strings = dogService.retrieveDogBreedById(id);
        if(strings.size() <= 0) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> retrieveDogNames(@RequestParam String name) {
        List<String> strings = dogService.retrieveDogNames(name);
        return new ResponseEntity<>(strings, HttpStatus.OK);
    }
}
