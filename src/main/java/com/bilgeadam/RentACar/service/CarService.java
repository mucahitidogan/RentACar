package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveCarRequestDto;
import com.bilgeadam.RentACar.dto.response.FindCarResponseDto;
import com.bilgeadam.RentACar.dto.response.FindJoinRentalDateCarnameBrandComponynameResponseDto;
import com.bilgeadam.RentACar.entity.Brand;
import com.bilgeadam.RentACar.entity.Car;
import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import com.bilgeadam.RentACar.entity.jointable.JoinRentalDateCarnameBrandComponyname;
import com.bilgeadam.RentACar.mapper.ICarMapper;
import com.bilgeadam.RentACar.repository.ICarRepository;
import com.bilgeadam.RentACar.service.joinService.JoinCarsWithColornameAndBrandnameService;
import com.bilgeadam.RentACar.service.joinService.JoinRentalDateCarnameBrandComponynameService;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService extends ServiceManager<Car, Long> {

    private final ICarRepository carRepository;
    private final CarColorService carColorService;
    private final BrandService brandService;
    public final JoinRentalDateCarnameBrandComponynameService joinRentalDateCarnameBrandComponynameService;
    public final JoinCarsWithColornameAndBrandnameService joinCarsWithColornameAndBrandnameService;


    public CarService(ICarRepository carRepository, BrandService brandService, CarColorService carColorService,
                      JoinRentalDateCarnameBrandComponynameService joinRentalDateCarnameBrandComponynameService,
                      JoinCarsWithColornameAndBrandnameService joinCarsWithColornameAndBrandnameService){
        super(carRepository);
        this.carRepository = carRepository;
        this.brandService = brandService;
        this.carColorService = carColorService;
        this.joinRentalDateCarnameBrandComponynameService = joinRentalDateCarnameBrandComponynameService;
        this.joinCarsWithColornameAndBrandnameService = joinCarsWithColornameAndBrandnameService;
    }

    public void save(SaveCarRequestDto dto){
        Optional<Brand> brand = brandService.findById(dto.getBrandid());
        if (brand.isPresent()){
            Car car = save(ICarMapper.INSTANCE.toCar(dto));
            dto.getColorids().forEach(colorid -> {
                carColorService.save(colorid, car.getId());
            });
        }else{
            throw new NotFoundException("Belirttiğiniz marka veritabanında bulunamadı.");
        }

    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }
    public List<Car> findAllByNameStartingWithIgnoreCase(String name){
        return carRepository.findAllByNameStartingWithIgnoreCase(name);
    }

    public List<Car> findAllByBrandid(Long brandId){
        return carRepository.findAllByBrandid(brandId);
    }

    public List<Car> findCarsByColorId(Long colorId){
        return carRepository.findCarsByColorId(colorId);
    }

    public List<JoinCarsWithColornameAndBrandname> carsWithColorAndBrand(){
        List<JoinCarsWithColornameAndBrandname>  carList =
                joinCarsWithColornameAndBrandnameService.carsWithColorAndBrand();
        if (carList.isEmpty()){
            throw new NullPointerException("Veritabanına kayıtlı araba bulunamamıştır");
        }
        return carList;
    }

    public  List<Car> findAllByDailypriceLessThan(double dailyPrice){
        return carRepository.findAllByDailypriceLessThan(dailyPrice);
    }

    public List<FindCarResponseDto> findCarsByRentalDailyPrice(){
        List<Car> carList = carRepository.findCarsByRentalDailyPrice();
        if(carList.isEmpty()){
            throw new NullPointerException("Veritabanında kiralık araba bulunamadı.");
        }
        List<FindCarResponseDto> dtoList = new ArrayList<>();
        carList.forEach(car -> {
            dtoList.add(ICarMapper.INSTANCE.toFindCarResponseDto(car));
                });
        return dtoList;
    }

//    public  List<Object> findDateBrandCompanyCarName(){
//        List oList = carRepository.findDateBrandCompanyCarName();
//        return oList;
//    }
   public List<FindJoinRentalDateCarnameBrandComponynameResponseDto> findDateBrandCompanyCarName(){
       List<FindJoinRentalDateCarnameBrandComponynameResponseDto> dtoList =
               joinRentalDateCarnameBrandComponynameService.findDateBrandCompanyCarName();
        if(dtoList.isEmpty()){
            throw new NotFoundException("Aradığınız veri veritabanında veri bulunamamıştır.");
        }
        return dtoList;
   }

}
