package com.example.demo_api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayoffResultResponse {
    private String refNumber;

    private String dateTime;

    private PayoffDataResponse data;
}
