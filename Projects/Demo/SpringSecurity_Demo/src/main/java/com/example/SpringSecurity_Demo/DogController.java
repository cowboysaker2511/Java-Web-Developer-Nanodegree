package com.example.SpringSecurity_Demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dog")
public class DogController {
    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDog() {
        return new ResponseEntity<>(dogService.getAllDog(), HttpStatus.OK);
    }

//    @GetMapping
//    public String getAllDog() {
//        return "OK";
//    }
}
