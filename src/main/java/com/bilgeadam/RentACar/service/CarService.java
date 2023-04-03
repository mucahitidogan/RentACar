package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveCarRequestDto;
import com.bilgeadam.RentACar.dto.response.FindCarResponseDto;
import com.bilgeadam.RentACar.dto.response.FindJoinRentalDateCarnameBrandComponynameResponseDto;
import com.bilgeadam.RentACar.entity.Brand;
import com.bilgeadam.RentACar.entity.Car;
import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import com.bilgeadam.RentACar.exception.RentACarException;
import com.bilgeadam.RentACar.mapper.ICarMapper;
import com.bilgeadam.RentACar.repository.ICarRepository;
import com.bilgeadam.RentACar.service.joinService.JoinCarsWithColornameAndBrandnameService;
import com.bilgeadam.RentACar.service.joinService.JoinRentalDateCarnameBrandComponynameService;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import static com.bilgeadam.RentACar.exception.ErrorType.*;

import java.util.*;

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
            throw new RentACarException(BRAND_NOT_FOUND);
        }

    }

    public List<Car> findAll(){
        List<Car> carList =  carRepository.findAll();
        if(carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return carList;
        }
    }

    public Optional<Car> findById(Long id){
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else {
            return optionalCar;
        }
    }
    public List<Car> findAllByNameStartingWithIgnoreCase(String name){
        List<Car> carList =  carRepository.findAllByNameStartingWithIgnoreCase(name);
        if(carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return carList;
        }
    }

    public List<Car> findAllByBrandid(Long brandId){
        List<Car> carList =  carRepository.findAllByBrandid(brandId);
        if(carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return carList;
        }
    }

    public List<Car> findCarsByColorId(Long colorId){
        List<Car> carList = carRepository.findCarsByColorId(colorId);
        if(carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return carList;
        }
    }

    public List<JoinCarsWithColornameAndBrandname> carsWithColorAndBrand(){
        List<JoinCarsWithColornameAndBrandname>  carList =
                joinCarsWithColornameAndBrandnameService.carsWithColorAndBrand();
        if (carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }
        return carList;
    }

    public  List<Car> findAllByDailypriceLessThan(double dailyPrice){
        List<Car> carList = carRepository.findAllByDailypriceLessThan(dailyPrice);
        if (carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }
        return carList;
    }

    public List<FindCarResponseDto> findCarsByRentalDailyPrice(){
        List<FindCarResponseDto> dtoList = new ArrayList<>();
        List<Car> carList = carRepository.findCarsByRentalDailyPrice();
        if(carList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else {
            carList.forEach(car -> {
                dtoList.add(ICarMapper.INSTANCE.toFindCarResponseDto(car));
            });
            return dtoList;
        }
    }

   public List<FindJoinRentalDateCarnameBrandComponynameResponseDto> findDateBrandCompanyCarName(){
       List<FindJoinRentalDateCarnameBrandComponynameResponseDto> dtoList =
               joinRentalDateCarnameBrandComponynameService.findDateBrandCompanyCarName();
        if(dtoList.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return dtoList;
        }
   }

}
