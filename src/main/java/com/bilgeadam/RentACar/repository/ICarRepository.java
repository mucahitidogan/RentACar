package com.bilgeadam.RentACar.repository;

import com.bilgeadam.RentACar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
    
    List<Car> findAllByNameStartingWithIgnoreCase(String name);

    List<Car> findAllByBrandid(Long brandId);

    Optional<Car> findById(Long id);
    @Query(nativeQuery = true, value = "Select * from tblcar as c\n" +
            "inner join tblcarcolor as cc\n" +
            "on c.carid = cc.car_id\n" +
            "inner join tblcolor as co\n" +
            "on co.colorid = cc.color_id\n" +
            "where co.colorid = ?1")
    List<Car> findCarsByColorId(Long colorId);

    List<Car> findAllByDailypriceLessThan(double dailyPrice);

    @Query(nativeQuery = true, value = "select * from tblcar as c inner join tblrental as r on c.carid = r.carid")
    List<Car> findCarsByRentalDailyPrice();

}
