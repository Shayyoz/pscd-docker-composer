package com.intuit.paymentservice.service;

import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import com.intuit.paymentservice.model.dto.PaymentRequestResultDto;

public interface PaymentService {
    PaymentRequestResultDto createPayment(PaymentRequestDto paymentRequestDto);
}
