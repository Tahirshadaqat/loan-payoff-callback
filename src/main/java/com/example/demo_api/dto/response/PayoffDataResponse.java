package com.example.demo_api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayoffDataResponse {

    private String transactionAmount;

    private String cifNo;

    private String coreReference;

    private String accountNo;

    private String creditAccountNo;
}