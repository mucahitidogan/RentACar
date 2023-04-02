package com.bilgeadam.RentACar.mapper;

import com.bilgeadam.RentACar.dto.request.SaveCustomerRequestDto;
import com.bilgeadam.RentACar.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(final SaveCustomerRequestDto dto);
}
