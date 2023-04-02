package com.bilgeadam.RentACar.repository;

import com.bilgeadam.RentACar.entity.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarColorRepository extends JpaRepository<CarColor, Long> {
}
