package com.example.demo_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo_api.dto.request.PayoffCallbackRequest;
import com.example.demo_api.dto.response.PayoffMainResponse;
import com.example.demo_api.service.LoanPayoffCallbackService;

@RestController
@RequestMapping("/api/v2")
public class LoanPayoffCallbackController {

    private final LoanPayoffCallbackService service;

    public LoanPayoffCallbackController(
            LoanPayoffCallbackService service) {

        this.service = service;
    }

    @PostMapping("/loanPayoffCallback")
    public PayoffMainResponse loanPayoffCallback(
            @RequestBody PayoffCallbackRequest request) {

        return service.response(request);
    }

    
}