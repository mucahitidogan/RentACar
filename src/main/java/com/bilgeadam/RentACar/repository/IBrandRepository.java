package com.bilgeadam.RentACar.repository;

import com.bilgeadam.RentACar.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

    public Optional<Brand> findByNameIgnoreCase(String name);

    public Optional<Brand> findById(Long id);
}
