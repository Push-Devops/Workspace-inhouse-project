package com.spapplication.loans.service;

import com.spapplication.loans.dto.LoanDto;

import java.util.List;

public interface LoanService {

    LoanDto createLoan(LoanDto loanDto);

    List<LoanDto> getLoansByCustomerId(Long customerId);
}

