package com.example.demo_api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayoffMainResponse {
    private String responseCode;

    private String responseMessage;

    private String traceId;

    private String timestamp;

    private PayoffResultResponse result;
}
