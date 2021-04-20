package com.intuit.paymentservice.util;

import com.intuit.paymentservice.mq.StatelessPaymentMQSender;
import com.intuit.paymentservice.repository.ErrorPaymentRepository;
import com.intuit.paymentservice.repository.entity.ErrorPaymentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableAsync
@RequiredArgsConstructor
public class ScheduledFixPaymentsErrorTask {
    private final StatelessPaymentMQSender statelessPaymentMQSender;
    private final ErrorPaymentRepository errorPaymentRepository;

//    @Async
//    @Scheduled(fixedDelay = 10000, initialDelay = 100000)
//    public void scheduleFixedRateTaskAsync() throws InterruptedException {
//        List<ErrorPaymentEntity> errorPaymentEntityList = errorPaymentRepository.findTop10ByPaymentIdAsc();

//        errorPaymentEntityList.stream()
//                .flatMap(errorPaymentEntity -> {
//                    statelessPaymentMQSender.sendToRiskAssessmentQueue(paymentRequestDmn);
//                });
//    }
}
