package com.intuit.paymentservice.mq;

import com.intuit.paymentservice.config.MQPaymentsConfig;
import com.intuit.paymentservice.model.domain.PaymentRequestDmn;
import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StatelessPaymentMQSender {
    @Autowired
    private RabbitTemplate template;

    public void sendAndForget(PaymentRequestDto paymentRequestDto) {
        UUID correlationId = UUID.randomUUID();

//        registrationService.saveCar(carDto, correlationId);

        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties
                    = message.getMessageProperties();
            messageProperties.setReplyTo(MQPaymentsConfig.PAYMENTS_RESPONSE_QUEUE);
            messageProperties.setCorrelationId(correlationId.toString());
            return message;
        };


        template.convertAndSend(MQPaymentsConfig.NEW_PAYMENTS_EXCHANGE,
                MQPaymentsConfig.NEW_PAYMENT_ROUTING_KEY,
                paymentRequestDto,
                messagePostProcessor);
    }
    public void sendForRiskAssessmentQueue(PaymentRequestDmn paymentRequestDmn) throws AmqpException {
        template.convertAndSend(MQPaymentsConfig.NEW_PAYMENTS_EXCHANGE,
                MQPaymentsConfig.NEW_PAYMENT_ROUTING_KEY, paymentRequestDmn);
    }
}
