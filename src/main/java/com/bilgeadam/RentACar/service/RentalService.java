package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveRentalRequestDto;
import com.bilgeadam.RentACar.entity.Car;
import com.bilgeadam.RentACar.entity.Customer;
import com.bilgeadam.RentACar.entity.Rental;
import com.bilgeadam.RentACar.exception.RentACarException;
import com.bilgeadam.RentACar.mapper.IRentalMapper;
import com.bilgeadam.RentACar.repository.IRentalRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import static com.bilgeadam.RentACar.exception.ErrorType.*;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService extends ServiceManager<Rental, Long> {

    private final IRentalRepository rentalRepository;
    private final CarService carService;
    private final CustomerService customerService;

    public RentalService(IRentalRepository rentalRepository, CarService carService, CustomerService customerService){
        super(rentalRepository);
        this.rentalRepository = rentalRepository;
        this.carService = carService;
        this.customerService = customerService;
    }

    public void save(SaveRentalRequestDto dto){
        Optional<Car> car = carService.findById(dto.getCarid());
        Optional<Customer> customer = customerService.findById(dto.getCustomerid());
        if(car.isPresent() || customer.isPresent()){
            save(IRentalMapper.INSTANCE.toRental(dto));
        }else {
            throw new RentACarException(CUSTOMER_OR_CAR_NOT_FOUND);
        }
    }

    public List<Rental> findAll(){
        List<Rental> rentalList = rentalRepository.findAll();
        if(rentalList.isEmpty()){
            throw new RentACarException(RENTAL_NOT_FOUND);
        }else {
            return rentalList;
        }
    }
}
