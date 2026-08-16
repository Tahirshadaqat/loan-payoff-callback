package com.example.demo_api.service;

import com.example.demo_api.dto.request.PayoffCallbackRequest;
import com.example.demo_api.dto.response.PayoffDataResponse;
import com.example.demo_api.dto.response.PayoffMainResponse;
import com.example.demo_api.dto.response.PayoffResultResponse;
import com.example.demo_api.entity.PayoffCallbackResult;
import com.example.demo_api.repository.PayoffRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LoanPayoffCallbackService {

    private final PayoffRepository repository;

    public LoanPayoffCallbackService(
            PayoffRepository repository) {

        this.repository = repository;
    }

    public PayoffMainResponse response(
            PayoffCallbackRequest request) {

        PayoffCallbackResult data =
                repository
                .findFirstByArrangementIdOrderByCreatedAtDesc(
                        request.getArrangementId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Data tidak ditemukan"));

        PayoffDataResponse responseData =
                PayoffDataResponse.builder()
                        .transactionAmount(
                                data.getTotalTransaction().toPlainString())
                        .cifNo(data.getCifNo())
                        .coreReference(data.getCoreReference())
                        .accountNo(data.getDebitAccountNo())
                        .creditAccountNo(data.getArrangementId())
                        .build();

        PayoffResultResponse result =
                PayoffResultResponse.builder()
                        .refNumber(request.getRefNumber())
                        .dateTime(request.getDateTime())
                        .data(responseData)
                        .build();

        return PayoffMainResponse.builder()
                .responseCode("00")
                .responseMessage("Success")
                .traceId(request.getTraceId())
                .timestamp(
                        LocalDateTime.now()
                                .format(DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH:mm:ss")))
                .result(result)
                .build();
    }
}