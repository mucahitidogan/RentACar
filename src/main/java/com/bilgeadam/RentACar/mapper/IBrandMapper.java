package com.bilgeadam.RentACar.mapper;

import com.bilgeadam.RentACar.dto.request.SaveBrandRequestDto;
import com.bilgeadam.RentACar.entity.Brand;
import com.bilgeadam.RentACar.service.BrandService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,  componentModel = "spring")
public interface IBrandMapper {

    IBrandMapper INSTANCE = Mappers.getMapper(IBrandMapper.class);

    Brand toBrand(final SaveBrandRequestDto dto);
}
