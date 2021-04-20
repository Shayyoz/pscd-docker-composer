package com.intuit.paymentservice.service;

import com.intuit.paymentservice.model.dto.PayeeDto;
import com.intuit.paymentservice.model.dto.PaymentMethodDto;

import java.util.List;
import java.util.UUID;

public interface UsersService {
     List<PaymentMethodDto> getUserPaymentMethods(String userId);

     List<PayeeDto> getUserPayees(String userId);
}
