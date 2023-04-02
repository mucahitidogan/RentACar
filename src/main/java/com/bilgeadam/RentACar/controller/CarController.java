package com.bilgeadam.RentACar.controller;

import com.bilgeadam.RentACar.dto.request.SaveCarRequestDto;
import com.bilgeadam.RentACar.dto.response.FindCarResponseDto;
import com.bilgeadam.RentACar.dto.response.FindJoinRentalDateCarnameBrandComponynameResponseDto;
import com.bilgeadam.RentACar.entity.Car;
import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import com.bilgeadam.RentACar.entity.jointable.JoinRentalDateCarnameBrandComponyname;
import com.bilgeadam.RentACar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

import static com.bilgeadam.RentACar.constants.EndPointList.*;

@RestController
@RequestMapping(CAR)
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    @PostMapping(SAVE)
    public ResponseEntity<Car> save(@RequestBody @Valid SaveCarRequestDto dto){
        carService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping(FIND_ALL_BY_NAME_STARTING_WITH)
    public ResponseEntity<List<Car>> findAllByNameStartingWithIgnoreCase(String name){
        return ResponseEntity.ok(carService.findAllByNameStartingWithIgnoreCase(name));
    }

    @GetMapping(FIND_ALL_BY_BRANID)
    public ResponseEntity<List<Car>> findAllByBrandid(Long brandId){
        return ResponseEntity.ok(carService.findAllByBrandid(brandId));
    }
    @GetMapping(FIND_CARS_BY_COLORID)
    public ResponseEntity<List<Car>> findCarsByColorId(Long colorId){
        return ResponseEntity.ok(carService.findCarsByColorId(colorId));
    }
    @GetMapping(CARS_WITH_COLOR_AND_BRAND)
    public ResponseEntity<List<JoinCarsWithColornameAndBrandname>> carsWithColorAndBrand(){
        return ResponseEntity.ok(carService.carsWithColorAndBrand());
    }

    @GetMapping(FIND_ALL_DAILY_PRICE_LESS_THAN)
    public ResponseEntity<List<Car>> findAllByDailypriceLessThan(double dailyPrice){
        return ResponseEntity.ok(carService.findAllByDailypriceLessThan(dailyPrice));
    }

    @GetMapping(FIND_ALL_CARS_RENTAL_DAILY_PRICE)
    public ResponseEntity<List<FindCarResponseDto>> findCarsByRentalDailyPrice(){
        return ResponseEntity.ok(carService.findCarsByRentalDailyPrice());
    }

    @GetMapping(FIND_ALL_RENTAL_DATE_CARNAME_BRANDNAME_COMPANYNAME)
    public ResponseEntity<List<FindJoinRentalDateCarnameBrandComponynameResponseDto>> findDateBrandCompanyCarName(){
        return ResponseEntity.ok(carService.findDateBrandCompanyCarName());
    }




}
