package com.bilgeadam.RentACar.service.joinService;

import com.bilgeadam.RentACar.dto.response.FindJoinRentalDateCarnameBrandComponynameResponseDto;
import com.bilgeadam.RentACar.entity.jointable.JoinRentalDateCarnameBrandComponyname;
import com.bilgeadam.RentACar.mapper.JoinMapper.IRentalDateCarnameBrandComponynameMapper;
import com.bilgeadam.RentACar.repository.joinRepository.IJoinRentalDateCarnameBrandComponynameRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoinRentalDateCarnameBrandComponynameService extends ServiceManager<JoinRentalDateCarnameBrandComponyname, Long> {

    private final IJoinRentalDateCarnameBrandComponynameRepository joinRentalDateCarnameBrandComponynameRepository;

    public JoinRentalDateCarnameBrandComponynameService(IJoinRentalDateCarnameBrandComponynameRepository joinRentalDateCarnameBrandComponynameRepository){
        super(joinRentalDateCarnameBrandComponynameRepository);
        this.joinRentalDateCarnameBrandComponynameRepository = joinRentalDateCarnameBrandComponynameRepository;
    }

    public List<FindJoinRentalDateCarnameBrandComponynameResponseDto> findDateBrandCompanyCarName(){
        List<JoinRentalDateCarnameBrandComponyname> joinRentalDateCarnameBrandComponynameList =
                joinRentalDateCarnameBrandComponynameRepository.findDateBrandCompanyCarName();
        List<FindJoinRentalDateCarnameBrandComponynameResponseDto> dtoList = new ArrayList<>();
        joinRentalDateCarnameBrandComponynameList.forEach(joinRentalDateCarnameBrandComponyname -> {
            dtoList.add(IRentalDateCarnameBrandComponynameMapper.INSTANCE
                    .toRentalDateCarnameBrandComponyname(joinRentalDateCarnameBrandComponyname));
        });
        return dtoList;
    }
}
