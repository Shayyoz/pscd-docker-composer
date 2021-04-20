package com.intuit.paymentservice.mapper;

import com.intuit.paymentservice.model.dto.PaymentMethodDto;
import com.intuit.paymentservice.repository.entity.PaymentMethodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMethodsMapper {
    PaymentMethodsMapper INSTANCE = Mappers.getMapper(PaymentMethodsMapper.class);
    List<PaymentMethodDto> entityToDtoMapper(List<PaymentMethodEntity> paymentRequest);
}
