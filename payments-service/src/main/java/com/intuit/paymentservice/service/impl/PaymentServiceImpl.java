package com.intuit.paymentservice.service.impl;

import com.intuit.paymentservice.mapper.PaymentMapper;
import com.intuit.paymentservice.model.domain.PaymentRequestDmn;
import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import com.intuit.paymentservice.model.dto.PaymentRequestResultDto;
import com.intuit.paymentservice.mq.StatelessPaymentMQSender;
import com.intuit.paymentservice.repository.ErrorPaymentRepository;
import com.intuit.paymentservice.repository.PaymentsRepository;
import com.intuit.paymentservice.repository.entity.ErrorPaymentEntity;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import com.intuit.paymentservice.model.domain.PaymentStatus;
import com.intuit.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.AmqpException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    public static final String PAYMENT_RISK_ASSESSMENT_ERROR = "Payment %s could not be sent to risk Assessment, saved in Error Table";
    private final PaymentsRepository paymentsRepository;
    private final ErrorPaymentRepository errorPaymentRepository;

    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;
    private final StatelessPaymentMQSender statelessPaymentMQSender;
    private static final Logger log = LogManager.getLogger(PaymentServiceImpl.class);



    @Override
    public PaymentRequestResultDto createPayment(PaymentRequestDto paymentRequestDto) {
        PaymentEntity paymentEntity = savePaymentRequestAsPlaced(paymentRequestDto);

        PaymentRequestDmn paymentRequestDmn = paymentMapper.entityToDmnMapper(paymentEntity);
        try {
            statelessPaymentMQSender.sendForRiskAssessmentQueue(paymentRequestDmn);
        }catch (AmqpException amqpEx){
            savePaymentInErrorTable(paymentRequestDmn);
        }

        return paymentMapper.entityToDtoMapper(paymentsRepository.save(paymentEntity));
    }

    private PaymentEntity savePaymentRequestAsPlaced(PaymentRequestDto paymentRequestDto) {
        PaymentEntity paymentEntity = paymentMapper.dtoToEntityMapper(paymentRequestDto);
        paymentEntity.setStatus(PaymentStatus.PLACED);
        paymentEntity = paymentsRepository.save(paymentEntity);
        return paymentEntity;
    }

    private void savePaymentInErrorTable(PaymentRequestDmn paymentRequestDmn) {
        ErrorPaymentEntity errorPaymentEntity = paymentMapper.DmnToErrorPaymentMapper(paymentRequestDmn);
        errorPaymentEntity.setStatus(PaymentStatus.ERROR);
        errorPaymentRepository.save(errorPaymentEntity);

        log.info(String.format(PAYMENT_RISK_ASSESSMENT_ERROR,errorPaymentEntity.getPaymentId()));
    }
}
