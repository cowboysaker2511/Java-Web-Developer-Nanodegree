package com.example.Entity3_Demo.repository;

import com.example.Entity3_Demo.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
