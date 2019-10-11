package com.mortgage.mortgage.impl;

import com.mortgage.mortgage.controller.UserController;
import com.mortgage.mortgage.entity.Loan;
import com.mortgage.mortgage.entity.User;
import com.mortgage.mortgage.repository.LoanRepository;
import com.mortgage.mortgage.repository.UserRepository;
import com.mortgage.mortgage.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoanServiceImpl implements LoanService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanServiceImpl.class);
    private LoanRepository loanRepository;
    private Double principleAmount = null;


    private Double userId = null;
    private Loan loan = null;

    private UserRepository userRepository;


    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Map<String, List> loanInfo(Double userId) {
        this.userId = userId;

        Map<String, List> hm = new HashMap<>();
        List<Double> list = new ArrayList<>();

        loan = loanRepository.findAllByUserId(userId);
        principleAmount = loan.getPrincipalAmount();

        Double tenure = loan.getTenure();
        Double rateOfInterest = loan.getRateOfInterest();
        rateOfInterest = rateOfInterest / (12 * 100);
        tenure = tenure * 12;
        double emi = (principleAmount * rateOfInterest * Math.pow(1 + rateOfInterest, tenure)) / (Math.pow(1 + rateOfInterest, tenure) - 1);

        //  Double emi = loan.getMonthlyEmi();


        //   Double loanAmount = loan.getLoanAmount();
        list.add(emi);
        list.add(principleAmount);
        list.add(tenure);
        Double months = 12d;
        list.add(months);

        list.add(rateOfInterest);
        // list.add(loanAmount);

        hm.put("LoanDetails", list);
        List<Double> row1 = new ArrayList<>();
        Double interest = (principleAmount * rateOfInterest) / months;
        principleAmount = emi - interest;
        row1.add(interest);
        row1.add(principleAmount);

        hm.put("Schedule Details Row 1", row1);

        return hm;

    }

    @Scheduled(fixedRate = 20000)
    public void debit() {

        User user = userRepository.findAllByUserId(userId);
        Optional<User> user1 = Optional.ofNullable(user);
        if (user1.isPresent()) {
            user.setAmount(user.getAmount() - principleAmount);
            userRepository.saveAndFlush(user);
            LOGGER.info("scheduler executed " + principleAmount + " has been deducted from savings account ");
            LOGGER.info("Remaining balance is  " + user.getAmount());
        }
    }
}
