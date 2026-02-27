package com.spapplication.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(
        name = "Loan",
        description = "Schema to hold Loan information"
)
public class LoanDto {

    @Schema(description = "Loan identifier", example = "1")
    private Long loanId;

    @Schema(description = "Customer identifier", example = "1001")
    private Long customerId;

    @Schema(description = "Loan number", example = "LN-1234567890")
    private String loanNumber;

    @Schema(description = "Type of loan", example = "Home Loan")
    private String loanType;

    @Schema(description = "Total loan amount", example = "500000.00")
    private BigDecimal totalLoan;

    @Schema(description = "Amount paid so far", example = "100000.00")
    private BigDecimal amountPaid;

    @Schema(description = "Outstanding amount", example = "400000.00")
    private BigDecimal outstandingAmount;
}

