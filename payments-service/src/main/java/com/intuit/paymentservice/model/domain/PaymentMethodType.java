package com.intuit.paymentservice.model.domain;

public enum PaymentMethodType {
    CREDIT_CARD("CREDIT_CARD"),
    BANK_ACCOUNT("BANK_ACCOUNT"),
    PAYPAL("PAYPAL");

    private String value;

    PaymentMethodType(String value){this.value = value;}

    public String getValue(){return value;}

    @Override
    public String toString(){ return String.valueOf(value);}

    public static PaymentMethodType fromValue(String value){
        for(PaymentMethodType s : PaymentMethodType.values()){
            if(s.value.equals(value)){
                return s;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
