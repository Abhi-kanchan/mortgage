package com.hcl.mortgage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.dto.EmiCalculationRequestDto;
import com.hcl.mortgage.dto.EmiCalculationResponseDto;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class EmiCalculationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmiCalculationController.class);
	
	@PostMapping("/emi")
	public ResponseEntity<EmiCalculationResponseDto> createCustomer(@RequestBody EmiCalculationRequestDto requestDto ) {
		LOGGER.info("inside emi calculation controller");
		return new ResponseEntity<>(new EmiCalculationResponseDto(), HttpStatus.CREATED);
	}
	
}
