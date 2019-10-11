package com.hcl.mortgage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.EligibilityCheckResponseDto;
import com.hcl.mortgage.dto.LoanResponseDto;
import com.hcl.mortgage.service.EligibilityCheckService;
import com.hcl.mortgage.service.LoanService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class EligibilityCheckController {
	
	private static final Logger lOGGER = LoggerFactory.getLogger(EligibilityCheckController.class);
	
	@Autowired
	EligibilityCheckService eligibilityCheckService;
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/eligibility")
	public ResponseEntity<EligibilityCheckResponseDto> eligibilityCheck(@RequestBody EligibilityCheckRequestDto eligibilityCheckRequestDto) {
		lOGGER.info("eligibility controller eligibilityCheck method");
		EligibilityCheckResponseDto response = eligibilityCheckService.checkEligibility(eligibilityCheckRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/loan")
	public ResponseEntity<LoanResponseDto> applyLoan(@RequestBody EligibilityCheckRequestDto eligibilityCheckRequestDto) {
		lOGGER.info("eligibility controller eligibilityCheck method");
		LoanResponseDto response = loanService.applyLoan(eligibilityCheckRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
