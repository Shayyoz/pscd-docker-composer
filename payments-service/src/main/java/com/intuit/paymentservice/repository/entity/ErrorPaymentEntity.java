package com.intuit.paymentservice.repository.entity;

import com.intuit.paymentservice.model.domain.PaymentStatus;
import com.intuit.paymentservice.model.domain.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="Payments")
public class ErrorPaymentEntity {
    @Id
    @Column(length = 64)
    private String paymentId;
    private String payeeId;
    private String userId;
    private String currency;
    private Double amount;
    private String paymentMethodId;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private Double riskAssessment;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public ErrorPaymentEntity() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Double getRiskAssessment() {
        return riskAssessment;
    }

    public void setRiskAssessment(Double riskAssessment) {
        this.riskAssessment = riskAssessment;
    }
}
