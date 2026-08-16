package com.example.demo_api.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(schema = "loanservice", name = "t_payoff_transaction_result")

public class PayoffCallbackResult {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cif_no")
    private String cifNo;

    @Column(name = "arrangement_id")
    private String arrangementId;

    @Column(name = "debit_account_no")
    private String debitAccountNo;

    @Column(name = "core_reference")
    private String coreReference;

    @Column(name = "total_transaction")     
    private BigDecimal totalTransaction;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
