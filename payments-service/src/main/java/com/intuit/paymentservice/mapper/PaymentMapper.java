package com.intuit.paymentservice.mapper;

import com.intuit.paymentservice.model.domain.PaymentRequestDmn;
import com.intuit.paymentservice.model.domain.PaymentStatus;
import com.intuit.paymentservice.model.dto.PayeeDto;
import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import com.intuit.paymentservice.model.dto.PaymentRequestResultDto;
import com.intuit.paymentservice.repository.entity.ErrorPaymentEntity;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",imports = UUID.class)
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentEntity dmnToEntityMapper(PaymentRequestDmn paymentRequestDmn);
    PaymentEntity dtoToEntityMapper(PaymentRequestDto paymentRequestDto);
    PaymentRequestDmn entityToDmnMapper(PaymentEntity paymentRequest);

    PaymentRequestResultDto entityToDtoMapper(PaymentEntity paymentRequest);
    PaymentRequestDmn DtoToDmnMapper(PaymentRequestDto paymentRequestDto);

    ErrorPaymentEntity DmnToErrorPaymentMapper(PaymentRequestDmn paymentRequestDmn);

    List<PayeeDto> entityToPayeeDtoMapper(List<PaymentEntity> paymentRequest);
}
