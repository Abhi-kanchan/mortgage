package com.hcl.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
	private double loanAmount;
	private long accountNumber;
	private double monthlyEmi;
	private double principalAmount;
	private double interestRate;
	private int tenure;
	private String interestType;
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
}
