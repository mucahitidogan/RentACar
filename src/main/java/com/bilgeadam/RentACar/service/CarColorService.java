package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.entity.CarColor;
import com.bilgeadam.RentACar.repository.ICarColorRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CarColorService extends ServiceManager<CarColor, Long> {

    private final ICarColorRepository carColorRepository;

    public CarColorService(ICarColorRepository carColorRepository){
        super(carColorRepository);
        this.carColorRepository = carColorRepository;
    }

    public void save(Long colorId, Long carId){
        save(CarColor.builder()
                .colorId(colorId)
                .carId(carId)
                .build());
    }
}
