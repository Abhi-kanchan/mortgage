package com.hcl.mortgage.service;

import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.LoanResponseDto;

@Service
public interface LoanService {
	
	LoanResponseDto applyLoan(EligibilityCheckRequestDto eligibilityCheckRequestDto);
}
