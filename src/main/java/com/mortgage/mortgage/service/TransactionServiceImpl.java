package com.mortgage.mortgage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mortgage.mortgage.dto.TransactionDto;
import com.mortgage.mortgage.entity.Transaction;
import com.mortgage.mortgage.repository.TransactionRepository;

/**
 * @author Laxman
 * @date 11-10-2019
 *
 *       This service is to get the details of the transactions
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	/**
	 * @author Laxman
	 * 
	 * @param accountNumber
	 * @param pageNo
	 * @param pageSize
	 * @return List<TransactionDto>
	 * 
	 *         This method is for getting all transaction done by particular account
	 */
	@Override
	public List<TransactionDto> getTransactions(Long accountNumber, Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Transaction> pageResult = transactionRepository.findByAccountNumber(accountNumber, paging);
		List<Transaction> pagedTransactionResult = pageResult.getContent();
		List<TransactionDto> transactionDtoList = new ArrayList<>();
		pagedTransactionResult.stream().forEach(transaction -> {
			TransactionDto transactionDto = new TransactionDto();
			BeanUtils.copyProperties(transaction, transactionDto);
			transactionDtoList.add(transactionDto);
		});
		return transactionDtoList;
	}
}
