package com.mortgage.mortgage.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mortgage.mortgage.controller.TransactionController;
import com.mortgage.mortgage.dto.TransactionDto;
import com.mortgage.mortgage.service.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

	@Mock
	private TransactionService transactionService;
	
	@InjectMocks
	private TransactionController transactionController;
	
	private List<TransactionDto> transactionList =null;
	
	@Before
	public void setUp() {
		transactionList = new ArrayList<>();
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setAccountNumber(101011L);
		transactionDto.setDataTime(LocalDateTime.now());
		transactionDto.setId(101);
		transactionDto.setInstalment(1000.0);
		transactionDto.setRemarks("CR - 99999123");
		transactionList.add(transactionDto);
		transactionList.add(transactionDto);
	}
	
	@Test
	public void testGetTransactions() {
		Mockito.when(transactionService.getTransactions(101011L, 0, 5)).thenReturn(transactionList);
		ResponseEntity<List<TransactionDto>> actualResult = transactionController.getTransactions("Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXJlc2giLCJleHAiOjE1NzE2NTM1MjZ9.cNkItQAX8u_A-wxpcEuu-exHxUisVSLyECJVLJwF1WTqRqQ148C1WZf1ByHXVp2rtptHJ8evLgwMXZIPLp_F_Q", 101011L, 0, 5);
		assertEquals(200, actualResult.getStatusCode().value());
	}
	
}
