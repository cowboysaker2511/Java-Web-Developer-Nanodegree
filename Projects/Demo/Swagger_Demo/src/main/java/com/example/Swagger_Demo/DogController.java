package com.example.Swagger_Demo;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dog")
@ApiResponses(value = {
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 401, message = "You are forbidden"),
        @ApiResponse(code = 404, message = "URL not found"),
        @ApiResponse(code = 500, message = "Server is down")
})
public class DogController {
    private DogService dogService;
    private DogRepository dogRepository;

    public DogController(DogService dogService, DogRepository dogRepository) {
        this.dogService = dogService;
        this.dogRepository = dogRepository;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDog() {
        return new ResponseEntity<>(dogService.getAllDog(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public Dog getDogById(@PathVariable Long id) {
        return dogRepository.findById(id).get();
    }
}
