package com.example.demo_api.dto.request;

import lombok.Data;

@Data
public class PayoffCallbackRequest {
    private String refNumber;
    private String dateTime;
    private String channelCode;
    private String terminalId;
    private String terminalLocation;
    private String traceId;
    private String arrangementId;
}
