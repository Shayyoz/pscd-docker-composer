package com.intuit.paymentservice.web.rest;

import com.intuit.paymentservice.model.dto.PaymentRequestDto;
import com.intuit.paymentservice.model.dto.PayeeDto;
import com.intuit.paymentservice.model.dto.PaymentMethodDto;
import com.intuit.paymentservice.model.dto.PaymentRequestResultDto;
import com.intuit.paymentservice.service.UsersService;
import com.intuit.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentsController {
    private final PaymentService paymentService;
    private final UsersService usersService;

    @PostMapping(value = "/createPayment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentRequestResultDto> saveTournamentResults(@RequestBody PaymentRequestDto request) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(request));
    }


    @GetMapping(value = "/{userId}/paymentMethods", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentMethodDto>> getPaymentMethods(@PathVariable String userId){
        return  ResponseEntity.ok(usersService.getUserPaymentMethods(userId));
    }


    @GetMapping(value = "/{userId}/payees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PayeeDto>> getPayees(@PathVariable String userId){
        return  ResponseEntity.ok(usersService.getUserPayees(userId));
    }
}
