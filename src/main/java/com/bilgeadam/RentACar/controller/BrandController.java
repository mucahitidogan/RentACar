package com.bilgeadam.RentACar.controller;

import com.bilgeadam.RentACar.dto.request.SaveBrandRequestDto;
import com.bilgeadam.RentACar.entity.Brand;
import com.bilgeadam.RentACar.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.RentACar.constants.EndPointList.*;

@RestController
@RequestMapping(BRAND)
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping(SAVE)
    public ResponseEntity<Brand> save(@RequestBody @Valid SaveBrandRequestDto dto){
        brandService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Brand>> findAll(){

        return ResponseEntity.ok(brandService.findAll());
    }
}
