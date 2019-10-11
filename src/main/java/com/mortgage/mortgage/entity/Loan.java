package com.mortgage.mortgage.entity;

import antlr.DocBookCodeGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    private Double loanId;
    private Double account;
   // private Double loanAmount;
    private Double userId;

    private Double principalAmount;
    private Double rateOfInterest;
    private Double monthlyEmi;
    private Double tenure;
    private String interestType;


}
