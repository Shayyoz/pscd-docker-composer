package com.intuit.paymentservice.service.impl;

import com.intuit.paymentservice.mapper.PaymentMapper;
import com.intuit.paymentservice.mapper.PaymentMethodsMapper;
import com.intuit.paymentservice.model.dto.PayeeDto;
import com.intuit.paymentservice.model.dto.PaymentMethodDto;
import com.intuit.paymentservice.repository.PaymentMethodsRepository;
import com.intuit.paymentservice.repository.PaymentsRepository;
import com.intuit.paymentservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final PaymentMethodsRepository paymentMethodsRepository;
    private final PaymentsRepository paymentsRepository;
    private final PaymentMethodsMapper paymentMethodsMapper = PaymentMethodsMapper.INSTANCE;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Override
    public List<PaymentMethodDto> getUserPaymentMethods(String userId) {
        return paymentMethodsMapper.entityToDtoMapper(paymentMethodsRepository.findByUserId(userId));
    }

    @Override
    public List<PayeeDto> getUserPayees(String userId) {
        return paymentMapper.entityToPayeeDtoMapper(paymentsRepository.findByUserId(userId));
    }
}
