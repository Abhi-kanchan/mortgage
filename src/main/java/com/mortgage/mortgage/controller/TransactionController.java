package com.mortgage.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.mortgage.dto.TransactionDto;
import com.mortgage.mortgage.service.TransactionService;

/**
 * @author Laxman
 *
 */
@RestController
@RequestMapping("/api")
//@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	/**
	 * @author Laxman
	 * 
	 * @param token
	 * @param accountNumber
	 * @param pageNo
	 * @param pageSize
	 * @return List<TransactionDto>
	 * 
	 *         This method is for getting all transaction done by particular account
	 */
	@GetMapping("/transactions/{accountNumber}")
	public ResponseEntity<List<TransactionDto>> getTransactions(@RequestHeader String token,
			@RequestParam Long accountNumber, @RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize) {

		return new ResponseEntity<>(transactionService.getTransactions(accountNumber, pageNo, pageSize), HttpStatus.OK);
	}

}
