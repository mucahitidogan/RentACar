package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveColorRequestDto;
import com.bilgeadam.RentACar.entity.Color;
import com.bilgeadam.RentACar.exception.RentACarException;
import com.bilgeadam.RentACar.mapper.IColorMapper;
import com.bilgeadam.RentACar.repository.IColorRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import static com.bilgeadam.RentACar.exception.ErrorType.*;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService extends ServiceManager<Color, Long> {

    private final IColorRepository colorRepository;
    public ColorService(IColorRepository colorRepository){
        super(colorRepository);
        this.colorRepository = colorRepository;
    }

    public void save(SaveColorRequestDto dto){
        Optional<Color> color = colorRepository.findByNameIgnoreCase(dto.getName());
        if(color.isPresent()){
           throw new RentACarException(COLOR_FOUND);
        }else{
            save(IColorMapper.INSTANCE.toColor(dto));
        }
    }

    public List<Color> findAll(){
        List<Color> colorList = colorRepository.findAll();
        if(colorList.isEmpty()){
            throw new RentACarException(COLOR_NOT_FOUND);
        }
        return colorList;
    }
}
