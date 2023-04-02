package com.bilgeadam.RentACar.service.joinService;

import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import com.bilgeadam.RentACar.repository.joinRepository.IJoinCarsWithColornameAndBrandnameRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinCarsWithColornameAndBrandnameService extends ServiceManager<JoinCarsWithColornameAndBrandname, Long> {

    private final IJoinCarsWithColornameAndBrandnameRepository joinCarsWithColornameAndBrandnameRepository;

    public JoinCarsWithColornameAndBrandnameService(IJoinCarsWithColornameAndBrandnameRepository joinCarsWithColornameAndBrandnameRepository){
        super(joinCarsWithColornameAndBrandnameRepository);
        this.joinCarsWithColornameAndBrandnameRepository = joinCarsWithColornameAndBrandnameRepository;
    }

    public List<JoinCarsWithColornameAndBrandname> carsWithColorAndBrand(){
        return joinCarsWithColornameAndBrandnameRepository.carsWithColorAndBrand();
    }
}
