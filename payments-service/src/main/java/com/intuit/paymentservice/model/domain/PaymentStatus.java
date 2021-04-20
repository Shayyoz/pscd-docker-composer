package com.intuit.paymentservice.model.domain;

public enum PaymentStatus {
    ERROR("ERROR"),
    PLACED("PLACED"),
    APPROVED("APPROVED"),
    DECLINED("DECLINED");

    private String value;

    PaymentStatus(String value){this.value = value;}

    public String getValue(){return value;}

    @Override
    public String toString(){ return String.valueOf(value);}

    public static PaymentStatus fromValue(String value){
        for(PaymentStatus s : PaymentStatus.values()){
            if(s.value.equals(value)){
                return s;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

}
