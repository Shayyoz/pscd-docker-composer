package com.intuit.paymentservice.mapper;

import com.intuit.paymentservice.model.dto.PayeeDto;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PayeeMapper {
    PayeeMapper INSTANCE = Mappers.getMapper(PayeeMapper.class);

    PayeeDto entityToDtoMapper(PaymentEntity paymentRequest);


}
