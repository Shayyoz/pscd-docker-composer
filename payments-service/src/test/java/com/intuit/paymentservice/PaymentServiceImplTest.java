package com.intuit.paymentservice;

import com.intuit.paymentservice.mapper.PaymentMapper;
import com.intuit.paymentservice.model.domain.PaymentStatus;
import com.intuit.paymentservice.model.domain.PaymentType;
import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import com.intuit.paymentservice.model.dto.PaymentRequestResultDto;
import com.intuit.paymentservice.mq.StatelessPaymentMQSender;
import com.intuit.paymentservice.repository.ErrorPaymentRepository;
import com.intuit.paymentservice.repository.PaymentsRepository;
import com.intuit.paymentservice.repository.entity.PaymentEntity;
import com.intuit.paymentservice.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceImplTest {
    public static final String MOCK_PAYEE_ID = "d368e095-41b2-406a-9f92-3130c8f5e895";
    public static final String MOCK_USER_ID = "e8af92bd-1910-421e-8de0-cb3dcf9bf44d";
    public static final String MOCK_CURRENCY = "USD";
    public static final double MOCK_AMOUNT = 100.00;
    public static final String MOCK_PAYMENT_METHOD = "5712768e-4d2d-46e5-9045-8ed731718227";
    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private PaymentsRepository paymentsRepository;

    @Mock
    private ErrorPaymentRepository errorPaymentRepository;

    @Spy
    private final PaymentMapper paymentMapper = PaymentMapper.INSTANCE;

    @Mock
    private StatelessPaymentMQSender statelessPaymentMQSender;


    @Test
    public void simplePaymentCreationSavedAsPlaced() throws Exception {
        PaymentRequestDto mockPaymentRequestDto = PaymentRequestDto.builder()
                .payeeId(MOCK_PAYEE_ID)
                .userId(MOCK_USER_ID)
                .currency(MOCK_CURRENCY)
                .amount(MOCK_AMOUNT)
                .paymentMethodId(MOCK_PAYMENT_METHOD)
                .paymentType(PaymentType.TRANSFER)
                .build();

        PaymentEntity mockPaymentEntity = paymentMapper.dtoToEntityMapper(mockPaymentRequestDto);
        mockPaymentEntity.setStatus(PaymentStatus.PLACED);

        when(paymentsRepository.save(any(PaymentEntity.class)))
                .thenReturn(mockPaymentEntity);

        PaymentRequestResultDto mockPaymentRequestResultDtoResponse =  paymentService.createPayment(mockPaymentRequestDto);

        assertNotNull(mockPaymentRequestResultDtoResponse);
        assertEquals(PaymentStatus.PLACED,mockPaymentRequestResultDtoResponse.getStatus());
        assertEquals(PaymentType.TRANSFER,mockPaymentRequestResultDtoResponse.getPaymentType());
    }
}
