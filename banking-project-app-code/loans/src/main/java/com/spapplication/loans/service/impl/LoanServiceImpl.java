package com.spapplication.loans.service.impl;

import com.spapplication.loans.dto.LoanDto;
import com.spapplication.loans.entity.Loan;
import com.spapplication.loans.repository.LoanRepository;
import com.spapplication.loans.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        Loan loan = new Loan();
        loan.setCustomerId(loanDto.getCustomerId());
        loan.setLoanNumber(loanDto.getLoanNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setTotalLoan(loanDto.getTotalLoan());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        loan.setCreatedAt(LocalDate.now());
        loan.setCreatedBy("SYSTEM");

        Loan saved = loanRepository.save(loan);
        loanDto.setLoanId(saved.getLoanId());
        return loanDto;
    }

    @Override
    public List<LoanDto> getLoansByCustomerId(Long customerId) {
        return loanRepository.findByCustomerId(customerId)
                .stream()
                .map(loan -> {
                    LoanDto dto = new LoanDto();
                    dto.setLoanId(loan.getLoanId());
                    dto.setCustomerId(loan.getCustomerId());
                    dto.setLoanNumber(loan.getLoanNumber());
                    dto.setLoanType(loan.getLoanType());
                    dto.setTotalLoan(loan.getTotalLoan());
                    dto.setAmountPaid(loan.getAmountPaid());
                    dto.setOutstandingAmount(loan.getOutstandingAmount());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

