package com.example.restapi_demo.repository;

import com.example.restapi_demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    @Query("SELECT id, breed FROM Dog")
    List<String> findAllBreed();

    @Query("SELECT id, breed FROM Dog WHERE id = :id")
    List<String> findAllBreedById(Long id);

    @Query("SELECT id, breed FROM Dog WHERE name = :name")
    List<String> findAllBreedByName(String name);
}
