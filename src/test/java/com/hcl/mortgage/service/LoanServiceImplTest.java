package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.LoanResponseDto;
import com.hcl.mortgage.entity.Customer;
import com.hcl.mortgage.entity.Loan;
import com.hcl.mortgage.repository.CustomerRepository;
import com.hcl.mortgage.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceImplTest {
	
	@InjectMocks
	LoanServiceImpl serviceImpl;
	
	@Mock
	LoanRepository loanRepository;
	
	@Mock
	CustomerRepository customerRepository;
	
	EligibilityCheckRequestDto requestDto;
	
	LoanResponseDto responseDto;
	Loan loan;
	Customer customer;
	
	@Before
	public void setup() {
		requestDto = new EligibilityCheckRequestDto();
		responseDto = new LoanResponseDto();
		loan = new Loan();
		requestDto.setAge(20);
		requestDto.setCustomerId(1);
		requestDto.setEligibleAmount(300000);
		requestDto.setLoanAmount(100000);
		customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("abhi");
		loan.setLoanId(1);
		responseDto.setMessage("Loan applied successfully");
	}
	
	@Test
	public void applyLoanTest() {
		Mockito.when(loanRepository.save(Mockito.any())).thenReturn(loan);
		responseDto= serviceImpl.applyLoan(requestDto);
		assertEquals("Loan applied successfully", responseDto.getMessage());
	}

}
