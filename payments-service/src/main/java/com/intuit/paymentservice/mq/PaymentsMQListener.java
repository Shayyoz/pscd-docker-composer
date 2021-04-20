package com.intuit.paymentservice.mq;

import com.intuit.paymentservice.config.MQPaymentsConfig;
import com.intuit.paymentservice.mapper.PaymentMapper;
import com.intuit.paymentservice.model.domain.PaymentRequestDmn;
import com.intuit.paymentservice.model.domain.PaymentStatus;
import com.intuit.paymentservice.repository.PaymentsRepository;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentsMQListener {
    private final PaymentsRepository paymentsRepository;
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @RabbitListener(queues = MQPaymentsConfig.PAYMENTS_RESPONSE_QUEUE)
    public void riskAssessmentResponseListener(PaymentRequestDmn riskAssessmentResponse){

        PaymentEntity paymentEntity = paymentMapper.dmnToEntityMapper(riskAssessmentResponse);
        paymentEntity.setStatus(riskAssessmentResponse.getRiskAssessment() > 0.3 ? PaymentStatus.APPROVED: PaymentStatus.DECLINED);

        paymentsRepository.save(paymentEntity);
    }
}
