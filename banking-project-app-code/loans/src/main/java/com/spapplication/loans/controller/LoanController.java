package com.spapplication.loans.controller;

import com.spapplication.loans.dto.LoanDto;
import com.spapplication.loans.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Loans APIs",
        description = "REST APIs for managing customer loans"
)
@RestController
@RequestMapping(path = "/api/loans", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class LoanController {

    private final LoanService loanService;

    @Operation(
            summary = "Create Loan",
            description = "Create a new loan for a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Loan created",
                    content = @Content(schema = @Schema(implementation = LoanDto.class))
            )
    })
    @PostMapping
    public ResponseEntity<LoanDto> createLoan(@Valid @RequestBody LoanDto loanDto) {
        LoanDto created = loanService.createLoan(loanDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(
            summary = "Get Loans by Customer",
            description = "Fetch all loans for a given customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Loans fetched",
                    content = @Content(schema = @Schema(implementation = LoanDto.class))
            )
    })
    @GetMapping
    public ResponseEntity<List<LoanDto>> getLoansByCustomer(
            @RequestParam @NotNull Long customerId) {
        return ResponseEntity.ok(loanService.getLoansByCustomerId(customerId));
    }
}

