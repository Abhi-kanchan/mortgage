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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mortgage.mortgage.dto.TransactionDto;
import com.mortgage.mortgage.entity.Transaction;
import com.mortgage.mortgage.repository.TransactionRepository;
import com.mortgage.mortgage.service.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private TransactionServiceImpl transactionServiceImpl;
	
	private List<TransactionDto> transactionList =null;
	private Page<Transaction> pageResult = null;
	
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
		
		List<Transaction> transactionList = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(101234L);
		transaction.setDataTime(LocalDateTime.now());
		transaction.setId(101);
		transaction.setInstalment(1000.0);
		transaction.setRemarks("CR - 99999123");
		transactionList.add(transaction);
		pageResult = new PageImpl<>(transactionList);
	}
	
	@Test
	public void testGetTransactions() {
		Pageable paging = PageRequest.of(0, 5);
		Mockito.when(transactionRepository.findByAccountNumber(101234L, paging)).thenReturn(pageResult);
		List<TransactionDto> actualResult = transactionServiceImpl.getTransactions(101234L, 0, 5);
		
		assertEquals("CR - 99999123", actualResult.get(0).getRemarks());
	}
}
