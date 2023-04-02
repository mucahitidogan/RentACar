package com.bilgeadam.RentACar.mapper;

import com.bilgeadam.RentACar.dto.request.SaveCarRequestDto;
import com.bilgeadam.RentACar.dto.response.FindCarResponseDto;
import com.bilgeadam.RentACar.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,  componentModel = "spring")
public interface ICarMapper {

    ICarMapper INSTANCE = Mappers.getMapper(ICarMapper.class);

    Car toCar(final SaveCarRequestDto dto);
    FindCarResponseDto toFindCarResponseDto(final Car car);
}
