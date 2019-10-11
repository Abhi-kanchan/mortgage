package com.hcl.mortgage.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.EligibilityCheckResponseDto;
import com.hcl.mortgage.dto.LoanResponseDto;
import com.hcl.mortgage.service.EligibilityCheckService;
import com.hcl.mortgage.service.LoanService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = EligibilityCheckController.class)
public class ELigibilirtyCheckConrollerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EligibilityCheckService eligibilityCheckService;
	
	@MockBean
	LoanService  loanService;
	
	EligibilityCheckRequestDto requestDto;
	EligibilityCheckResponseDto responseDto;
	LoanResponseDto loanResponseDto;
	
	@Before
	public void setup() {
		requestDto=new EligibilityCheckRequestDto();
		responseDto=new EligibilityCheckResponseDto();
		loanResponseDto = new LoanResponseDto();
		requestDto.setAge(18);
		requestDto.setCustomerName("abhi");
		responseDto.setMessage("Eligbility Checked successfully");
		loanResponseDto.setLoanAccountNumber(123456788765L);
		loanResponseDto.setMessage("success");
	}
	
	@Test
	public void eligibilityCheck() throws Exception {
		Mockito.when(eligibilityCheckService.checkEligibility(requestDto)).thenReturn(responseDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/eligibility").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(responseDto))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void applyLoan() throws Exception {
		Mockito.when(loanService.applyLoan(requestDto)).thenReturn(loanResponseDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/loan").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(loanResponseDto))).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
