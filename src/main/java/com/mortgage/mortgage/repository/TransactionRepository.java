package com.mortgage.mortgage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mortgage.mortgage.entity.Transaction;
/**
 * @author Laxman
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	public Page<Transaction> findByAccountNumber(Long accountNumber, Pageable pageable);
}
