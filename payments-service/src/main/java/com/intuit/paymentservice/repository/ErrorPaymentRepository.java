package com.intuit.paymentservice.repository;

import com.intuit.paymentservice.repository.entity.ErrorPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ErrorPaymentRepository extends JpaRepository<ErrorPaymentEntity,Integer> {

//    List<ErrorPaymentEntity> findTop10ByPaymentId();
}
