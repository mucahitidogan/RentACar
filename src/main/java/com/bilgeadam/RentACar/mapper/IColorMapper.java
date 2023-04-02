package com.bilgeadam.RentACar.mapper;

import com.bilgeadam.RentACar.dto.request.SaveColorRequestDto;
import com.bilgeadam.RentACar.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IColorMapper {

    IColorMapper INSTANCE = Mappers.getMapper(IColorMapper.class);

    Color toColor(final SaveColorRequestDto dto);
}
