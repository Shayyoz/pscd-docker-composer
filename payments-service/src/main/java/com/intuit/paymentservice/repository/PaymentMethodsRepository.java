package com.intuit.paymentservice.repository;

import com.intuit.paymentservice.repository.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethodEntity,Integer> {
    List<PaymentMethodEntity> findByUserId(String userId);
}
