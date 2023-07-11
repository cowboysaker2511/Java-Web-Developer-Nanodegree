package com.example.SpringDataRest_Demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
public class DogController {
    @GetMapping
    public ResponseEntity<String> getAllDog() {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
