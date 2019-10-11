package com.mortgage.mortgage.service;

import java.util.List;

import com.mortgage.mortgage.dto.TransactionDto;

public interface TransactionService {

	List<TransactionDto> getTransactions(Long accountNumber, Integer pageNo, Integer pageSize);

}
