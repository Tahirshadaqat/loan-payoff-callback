package com.example.demo_api.repository;

import com.example.demo_api.entity.PayoffCallbackResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayoffRepository
        extends JpaRepository<PayoffCallbackResult, Long> {

    Optional<PayoffCallbackResult>
    findFirstByArrangementIdOrderByCreatedAtDesc(
            String arrangementId);
}