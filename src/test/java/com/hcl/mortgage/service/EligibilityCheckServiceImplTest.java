package com.hcl.mortgage.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.EligibilityCheckResponseDto;
import com.hcl.mortgage.entity.LoanCategory;
import com.hcl.mortgage.repository.LoanCategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class EligibilityCheckServiceImplTest {
	
	@InjectMocks
	EligibilityCheckServiceImpl eligibilityCheckServiceImpl;
	
	@Mock
	LoanCategoryRepository categoryRepository;
	
	LoanCategory category;
	EligibilityCheckRequestDto requestDto;
	EligibilityCheckResponseDto responseDto;
	
	@Before
	public void setup() {
		requestDto = new EligibilityCheckRequestDto();
		responseDto = new EligibilityCheckResponseDto();
		category = new LoanCategory();
		requestDto.setAge(20);
		requestDto.setCustomerId(1);
		requestDto.setEligibleAmount(300000);
		requestDto.setLoanAmount(100000);
		category.setExposure(25);
		category.setMinAge(18);
		category.setMaxAge(30);
		responseDto.setMessage("Eligbility Checked successfully");
	}
	
	@Test
	public void eligibilityCheckTest() {
		Mockito.when(categoryRepository.findLoanCategoryByAge(Mockito.any())).thenReturn(Optional.<LoanCategory>empty());
		responseDto= eligibilityCheckServiceImpl.checkEligibility(requestDto);
		assertEquals("Loan applied successfully", responseDto.getMessage());
	}
	

}
