package com.spapplication.loans.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "loan_number", nullable = false, length = 50)
    private String loanNumber;

    @Column(name = "loan_type", nullable = false, length = 100)
    private String loanType;

    @Column(name = "total_loan", nullable = false)
    private BigDecimal totalLoan;

    @Column(name = "amount_paid", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "outstanding_amount", nullable = false)
    private BigDecimal outstandingAmount;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "created_by", nullable = false, length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "updated_by", length = 20)
    private String updatedBy;
}

