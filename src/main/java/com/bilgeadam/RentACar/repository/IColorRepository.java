package com.bilgeadam.RentACar.repository;

import com.bilgeadam.RentACar.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IColorRepository extends JpaRepository<Color, Long> {

    public Optional<Color> findByNameIgnoreCase(String name);

}
