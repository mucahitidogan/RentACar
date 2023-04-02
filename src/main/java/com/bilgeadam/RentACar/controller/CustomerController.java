package com.bilgeadam.RentACar.controller;

import com.bilgeadam.RentACar.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.RentACar.entity.Customer;
import com.bilgeadam.RentACar.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.RentACar.constants.EndPointList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping(SAVE)
    public ResponseEntity<Customer> save(@RequestBody @Valid SaveCustomerRequestDto dto){
        customerService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
