package com.mortgage.mortgage.service;

import com.mortgage.mortgage.entity.Loan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LoanService {
    public Map<String, List> loanInfo(Double userId);
}
