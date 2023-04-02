package com.bilgeadam.RentACar.mapper.JoinMapper;

import com.bilgeadam.RentACar.dto.response.FindJoinRentalDateCarnameBrandComponynameResponseDto;
import com.bilgeadam.RentACar.entity.jointable.JoinRentalDateCarnameBrandComponyname;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IRentalDateCarnameBrandComponynameMapper {

    IRentalDateCarnameBrandComponynameMapper INSTANCE = Mappers.getMapper(IRentalDateCarnameBrandComponynameMapper.class);

    FindJoinRentalDateCarnameBrandComponynameResponseDto toRentalDateCarnameBrandComponyname(final JoinRentalDateCarnameBrandComponyname joinRentalDateCarnameBrandComponyname);
}
