package com.bilgeadam.RentACar.service.joinService;

import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import com.bilgeadam.RentACar.exception.RentACarException;
import com.bilgeadam.RentACar.repository.joinRepository.IJoinCarsWithColornameAndBrandnameRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import static com.bilgeadam.RentACar.exception.ErrorType.*;

import java.util.List;

@Service
public class JoinCarsWithColornameAndBrandnameService extends ServiceManager<JoinCarsWithColornameAndBrandname, Long> {

    private final IJoinCarsWithColornameAndBrandnameRepository joinCarsWithColornameAndBrandnameRepository;

    public JoinCarsWithColornameAndBrandnameService(IJoinCarsWithColornameAndBrandnameRepository joinCarsWithColornameAndBrandnameRepository){
        super(joinCarsWithColornameAndBrandnameRepository);
        this.joinCarsWithColornameAndBrandnameRepository = joinCarsWithColornameAndBrandnameRepository;
    }

    public List<JoinCarsWithColornameAndBrandname> carsWithColorAndBrand(){
        List<JoinCarsWithColornameAndBrandname> list = joinCarsWithColornameAndBrandnameRepository.carsWithColorAndBrand();
        if(list.isEmpty()){
            throw new RentACarException(CAR_NOT_FOUND);
        }else{
            return list;
        }
    }
}
