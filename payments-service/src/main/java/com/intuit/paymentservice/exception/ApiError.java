package com.intuit.paymentservice.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ApiError {
    private List<String> errorMessages;

    public ApiError(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
