package com.hcl.mortgage.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Emi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emiId;
	private int loanId;
	private int montlyInstalment;
	private double interest;
	private double principalAmount;
	private double balance;
	private LocalDate dueDate;
}
