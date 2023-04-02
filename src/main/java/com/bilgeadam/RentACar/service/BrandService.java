package com.bilgeadam.RentACar.service;

import com.bilgeadam.RentACar.dto.request.SaveBrandRequestDto;
import com.bilgeadam.RentACar.entity.Brand;
import com.bilgeadam.RentACar.mapper.IBrandMapper;
import com.bilgeadam.RentACar.repository.IBrandRepository;
import com.bilgeadam.RentACar.utility.ServiceManager;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService extends ServiceManager<Brand,Long>{

    private final IBrandRepository brandRepository;

    public BrandService(IBrandRepository brandRepository){
        super(brandRepository);
        this.brandRepository = brandRepository;
    }

    public void save(SaveBrandRequestDto dto){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(dto.getName());
        if (brand.isPresent()){
            throw new NotFoundException(dto.getName() + " markası veritabanında kayıtlı");
        }else {
            save(IBrandMapper.INSTANCE.toBrand(dto));
        }
    }

    public List<Brand> findAll(){
        return brandRepository.findAll();
    }

    public Optional<Brand> findById(Long id){
        return brandRepository.findById(id);
    }
}
