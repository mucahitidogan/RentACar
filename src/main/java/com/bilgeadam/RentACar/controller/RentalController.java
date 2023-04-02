package com.bilgeadam.RentACar.controller;

import com.bilgeadam.RentACar.dto.request.SaveCarRequestDto;
import com.bilgeadam.RentACar.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.RentACar.dto.request.SaveRentalRequestDto;
import com.bilgeadam.RentACar.entity.Rental;
import com.bilgeadam.RentACar.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.RentACar.constants.EndPointList.*;

@RestController
@RequestMapping(RENTAL)
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping(SAVE)
    public ResponseEntity<Rental> save(@RequestBody @Valid SaveRentalRequestDto dto){
       rentalService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Rental>> findAll(){
        return ResponseEntity.ok(rentalService.findAll());
    }
}
