package com.udacity.pricing.domain.price;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
