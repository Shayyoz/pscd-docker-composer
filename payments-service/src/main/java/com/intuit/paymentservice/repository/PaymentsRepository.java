package com.intuit.paymentservice.repository;

import com.intuit.paymentservice.repository.entity.PaymentEntity;
import com.intuit.paymentservice.repository.entity.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentsRepository extends JpaRepository<PaymentEntity,Integer> {
    List<PaymentEntity> findByUserId(String userId);
}
